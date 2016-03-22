package de.mosbach.lan.smarthomeClient;

import java.util.Collection;

import javax.xml.ws.BindingProvider;

import com.google.common.collect.Iterables;

import de.mosbach.lan.serviceClients.UddiClient;
import de.mosbach.lan.smarthome.services.OutsideTemperatureService;
import de.mosbach.lan.smarthome.services.OutsideTemperatureService_Service;

public class Controller {
	private final StatusData statusData;

	public Controller(StatusData statusData) {
		this.statusData = statusData;
	}

	public synchronized void start() {

		Thread loadInternalTemperatureThread = new Thread(new Runnable() {

			@Override
			public void run() {
				loadInternalTemperature();
			}
		});
		Thread loadOutsideTemperatureThread = new Thread(new Runnable() {

			@Override
			public void run() {
				loadOutsideTemperature();
			}
		});
		loadInternalTemperatureThread.start();
		loadOutsideTemperatureThread.start();

		try {
			loadInternalTemperatureThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			loadOutsideTemperatureThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (this.statusData.getOutsideTemperature() == -1) {
			return;
		}

		if (this.statusData.getInternalTemperature() != this.statusData.getOutsideTemperature()) {
			adjustTemperature();
		} else {

			Thread turnOffAirConditionerThread = new Thread(new Runnable() {

				@Override
				public void run() {
					setAirConditionerState(IStatusData.FALSE);
				}
			});

			Thread turnOffHeaterThread = new Thread(new Runnable() {

				@Override
				public void run() {
					setHeaterState(IStatusData.FALSE);
				}
			});

			Thread closeWindowThread = new Thread(new Runnable() {

				@Override
				public void run() {
					setWindowState(IStatusData.FALSE);
				}
			});
			turnOffAirConditionerThread.start();
			turnOffHeaterThread.start();
			closeWindowThread.start();

			try {
				turnOffAirConditionerThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				turnOffHeaterThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				closeWindowThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void adjustTemperature() {
		if (this.statusData.getInternalTemperature() > this.statusData.getInsideTempRequirement()) {
			setHeaterState(IStatusData.FALSE);
			if (this.statusData.getOutsideTemperature() > this.statusData.getInsideTempRequirement()) {
				setWindowState(IStatusData.FALSE);
				setAirConditionerState(IStatusData.TRUE);
			} else {
				setAirConditionerState(IStatusData.FALSE);
				setWindowState(IStatusData.TRUE);
			}
		} else {
			setAirConditionerState(IStatusData.FALSE);
			if (this.statusData.getOutsideTemperature() > this.statusData.getInsideTempRequirement()) {
				setHeaterState(IStatusData.FALSE);
				setWindowState(IStatusData.TRUE);
			} else {
				setWindowState(IStatusData.FALSE);
				setHeaterState(IStatusData.TRUE);
			}
		}
	}

	private void setAirConditionerState(int value) {
		try {
			System.out.println("Set AirConditionerState");
			final Collection<javax.xml.registry.infomodel.Service> outsideTemperatureServices = UddiClient
					.getServices("WSO2", "outsideTemperatureService", 1, 0);

			final javax.xml.registry.infomodel.Service outsideTemperatureServiceDescription = Iterables
					.getFirst(outsideTemperatureServices, null);
			String outsideTemperatureServiceEndpoint;
			outsideTemperatureServiceEndpoint = (outsideTemperatureServiceDescription != null)
					? UddiClient.getFirstServiceBinding(outsideTemperatureServiceDescription) : null;
			final OutsideTemperatureService_Service ots = new OutsideTemperatureService_Service();
			final OutsideTemperatureService port = ots.getOutsideTemperatureService();
			final BindingProvider outsideTemperatureBp = (BindingProvider) port;
			outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					outsideTemperatureServiceEndpoint);

			final float airConditionerState = port.getMosbachTemperatureToday();

			// this.statusData.setInternalTemperature((int) outsideTemperature);
			System.out.println("AirConditionerState was set");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			this.statusData.setStateAirConditioner(StatusData.DEFEKT);
			System.err.println("Error while set AirConditionerState");
		}
	}

	private void setHeaterState(int value) {

		try {
			System.out.println("Set HeaterState");
			final Collection<javax.xml.registry.infomodel.Service> outsideTemperatureServices = UddiClient
					.getServices("WSO2", "outsideTemperatureService", 1, 0);

			final javax.xml.registry.infomodel.Service outsideTemperatureServiceDescription = Iterables
					.getFirst(outsideTemperatureServices, null);
			String outsideTemperatureServiceEndpoint;
			outsideTemperatureServiceEndpoint = (outsideTemperatureServiceDescription != null)
					? UddiClient.getFirstServiceBinding(outsideTemperatureServiceDescription) : null;
			final OutsideTemperatureService_Service ots = new OutsideTemperatureService_Service();
			final OutsideTemperatureService port = ots.getOutsideTemperatureService();
			final BindingProvider outsideTemperatureBp = (BindingProvider) port;
			outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					outsideTemperatureServiceEndpoint);

			final float heaterState = port.getMosbachTemperatureToday();

			// this.statusData.setInternalTemperature((int) outsideTemperature);
			System.out.println("HeaterState was set");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			this.statusData.setStateHeater(StatusData.DEFEKT);
			System.err.println("Error while set HeaterState");
		}
	}

	private void setWindowState(int value) {
		try {
			System.out.println("Set WindowState");
			final Collection<javax.xml.registry.infomodel.Service> windowStateServices = UddiClient.getServices("WSO2",
					"windowStateServices", 1, 0);

			final javax.xml.registry.infomodel.Service windowStateServicesDescription = Iterables
					.getFirst(windowStateServices, null);
			String windowStateServicesEndpoint;
			windowStateServicesEndpoint = (windowStateServicesDescription != null)
					? UddiClient.getFirstServiceBinding(windowStateServicesDescription) : null;
			final OutsideTemperatureService_Service ots = new OutsideTemperatureService_Service();
			final OutsideTemperatureService port = ots.getOutsideTemperatureService();
			final BindingProvider outsideTemperatureBp = (BindingProvider) port;
			outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					windowStateServicesEndpoint);

			final float windowState = port.getMosbachTemperatureToday();

			// this.statusData.setInternalTemperature((int) outsideTemperature);
			System.out.println("WindowState was set");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			this.statusData.setStateWindow(StatusData.DEFEKT);
			System.err.println("Error while set WindowState");
		}

	}

	private void loadInternalTemperature() {
		// try {
		// System.out.println("Load InternalTemperature");
		// final Collection<javax.xml.registry.infomodel.Service>
		// internalTemperatureServices = UddiClient
		// .getServices("WSO2", "insideTemperatureService", 1, 0);
		//
		// final javax.xml.registry.infomodel.Service
		// internalTemperatureServicesDescription = Iterables
		// .getFirst(internalTemperatureServices, null);
		// String internalTemperatureServicesEndpoint;
		// internalTemperatureServicesEndpoint =
		// (internalTemperatureServicesDescription != null)
		// ?
		// UddiClient.getFirstServiceBinding(internalTemperatureServicesDescription)
		// : null;
		// final OutsideTemperatureService_Service ots = new
		// OutsideTemperatureService_Service();
		// final OutsideTemperatureService port =
		// ots.getOutsideTemperatureService();
		// final BindingProvider outsideTemperatureBp = (BindingProvider) port;
		// outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
		// internalTemperatureServicesEndpoint);
		//
		// final float outsideTemperature = port.getMosbachTemperatureToday();
		// this.statusData.setInternalTemperature((int) outsideTemperature);
		// System.out.println("InternalTemperature was loaded");
		// } catch (Exception e) {
		// System.err.println(e.getMessage());
		// this.statusData.setInternalTemperature(StatusData.DEFEKT);
		// System.err.println("Error while loading InternalTemperature");
		// }
		this.statusData.setInternalTemperature(111);
	}

	private void loadOutsideTemperature() {

		try {
			System.out.println("Load OutsideTemperature");
			final Collection<javax.xml.registry.infomodel.Service> outsideTemperatureServices = UddiClient
					.getServices("WSO2", "outsideTemperatureService", 1, 0);

			final javax.xml.registry.infomodel.Service outsideTemperatureServiceDescription = Iterables
					.getFirst(outsideTemperatureServices, null);
			String outsideTemperatureServiceEndpoint;
			outsideTemperatureServiceEndpoint = (outsideTemperatureServiceDescription != null)
					? UddiClient.getFirstServiceBinding(outsideTemperatureServiceDescription) : null;
			final OutsideTemperatureService_Service ots = new OutsideTemperatureService_Service();
			final OutsideTemperatureService port = ots.getOutsideTemperatureService();
			final BindingProvider outsideTemperatureBp = (BindingProvider) port;
			outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					outsideTemperatureServiceEndpoint);

			final float outsideTemperature = port.getMosbachTemperatureToday();
			this.statusData.setOutsideTemperature((int) outsideTemperature);
			System.out.println("OutsideTemperature was loaded");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			this.statusData.setOutsideTemperature(StatusData.DEFEKT);
			System.err.println("Error while loading OutsideTemperature");
		}

	}
}
