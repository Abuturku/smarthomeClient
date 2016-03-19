package de.mosbach.lan.smarthomeClient;

import java.util.Collection;

import javax.xml.registry.JAXRException;
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
					turnOffAirConditioner();
				}
			});

			Thread turnOffHeaterThread = new Thread(new Runnable() {

				@Override
				public void run() {
					turnOffHeater();
				}
			});

			Thread closeWindowThread = new Thread(new Runnable() {

				@Override
				public void run() {
					closeWindow();
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
			turnOffHeater();
			if (this.statusData.getOutsideTemperature() > this.statusData.getInsideTempRequirement()) {
				closeWindow();
				turnOnAirConditioner();
			} else {
				turnOffAirConditioner();
				openWindow();
			}
		} else {
			turnOffAirConditioner();
			if (this.statusData.getOutsideTemperature() > this.statusData.getInsideTempRequirement()) {
				turnOffHeater();
				openWindow();
			} else {
				closeWindow();
				turnOnHeater();
			}
		}
	}

	private void turnOffAirConditioner() {
		this.statusData.setStateAirConditioner(IStatusData.FALSE);
	}

	private void turnOnAirConditioner() {
		this.statusData.setStateAirConditioner(IStatusData.TRUE);
	}

	private void turnOffHeater() {
		this.statusData.setStateHeater(IStatusData.FALSE);
	}

	private void turnOnHeater() {
		this.statusData.setStateHeater(IStatusData.TRUE);
	}

	private void closeWindow() {
		this.statusData.setStateWindow(IStatusData.FALSE);
	}

	private void openWindow() {
		this.statusData.setStateWindow(IStatusData.TRUE);
	}

	private void loadInternalTemperature() {
		System.out.println("Load InternalTemperature");
		this.statusData.setInternalTemperature(20);
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
			final OutsideTemperatureService port = ots.getOutsideTemperatureServicePort();
			final BindingProvider outsideTemperatureBp = (BindingProvider) port;
			outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					outsideTemperatureServiceEndpoint);

			final float outsideTemperature = port.getMosbachTemperatureToday("test");
			this.statusData.setOutsideTemperature((int) outsideTemperature);
			System.out.println("OutsideTemperature was loaded");
		} catch (JAXRException e) {
			System.err.println(e.getMessage());
			this.statusData.setOutsideTemperature(StatusData.DEFEKT);
			System.err.println("Error while loading OutsideTemperature");
		}

	}
}
