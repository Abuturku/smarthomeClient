package de.mosbach.lan.smarthomeClient;

import de.mosbach.lan.serviceClients.InsideTemperatureServiceClient;
import de.mosbach.lan.serviceClients.OutsideTemperatureServiceClient;
import de.mosbach.lan.serviceClients.SmartHomeControlServiceClient;

public class Controller {
	private final String roomID;
	private final StatusData statusData;
	private final OutsideTemperatureServiceClient outsideTemperatureServiceClient;
	private final InsideTemperatureServiceClient internalTemperatureServiceClient;
	private final SmartHomeControlServiceClient smartHomeControllerServiceClient;

	public Controller(StatusData statusData, String roomID) {
		this.statusData = statusData;
		this.roomID = roomID;
		this.outsideTemperatureServiceClient = new OutsideTemperatureServiceClient();
		this.internalTemperatureServiceClient = new InsideTemperatureServiceClient(this.roomID);
		this.smartHomeControllerServiceClient = new SmartHomeControlServiceClient(this.roomID);

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

		if (this.statusData.getInternalTemperature() != this.statusData.getInsideTempRequirement()) {
			adjustTemperature();
		} else {
			int[] status = this.smartHomeControllerServiceClient.shutdownAll();
			this.statusData.setStateWindow(status[0]);
			this.statusData.setStateHeater(status[1]);
			this.statusData.setStateAirConditioner(status[2]);
		}

	}

	/**
	 * TODO: Das hier ist kein Clean Code !!!!!
	 */
	private void adjustTemperature() {
		if (this.statusData.getInternalTemperature() > this.statusData.getInsideTempRequirement()) {
			if (this.statusData.getOutsideTemperature() < this.statusData.getInsideTempRequirement()) {
				int[] status = this.smartHomeControllerServiceClient.openWindows();
				this.statusData.setStateWindow(status[0]);
				this.statusData.setStateHeater(status[1]);
				this.statusData.setStateAirConditioner(status[2]);
			} else {
				int[] status = this.smartHomeControllerServiceClient.turnOnAirConditioner();
				this.statusData.setStateWindow(status[0]);
				this.statusData.setStateHeater(status[1]);
				this.statusData.setStateAirConditioner(status[2]);

			}
		} else {
			if (this.statusData.getOutsideTemperature() > this.statusData.getInsideTempRequirement()) {
				int[] status = this.smartHomeControllerServiceClient.openWindows();
				this.statusData.setStateWindow(status[0]);
				this.statusData.setStateHeater(status[1]);
				this.statusData.setStateAirConditioner(status[2]);
			} else {
				int[] status = this.smartHomeControllerServiceClient.turnOnHeaters();
				this.statusData.setStateWindow(status[0]);
				this.statusData.setStateHeater(status[1]);
				this.statusData.setStateAirConditioner(status[2]);
			}
		}
	}

	private void loadInternalTemperature() {
		this.statusData.setInternalTemperature(this.internalTemperatureServiceClient.getTemperature(statusData));
	}

	private void loadOutsideTemperature() {
		this.statusData.setOutsideTemperature(this.outsideTemperatureServiceClient.getTemperature());
	}
}
