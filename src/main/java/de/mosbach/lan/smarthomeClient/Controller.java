package de.mosbach.lan.smarthomeClient;

public class Controller {
	private final StatusData statusData;

	public Controller(StatusData statusData) {
		this.statusData = statusData;
	}

	public synchronized void start() {

		// System.out.println("Starte Vorgang");
		// Thread loadInternalTemperatureThread = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		loadInternalTemperature();
		// }
		// });

		// Thread loadOutsideTemperatureThread = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		loadOutsideTemperature();
		// }
		// });

		// System.out.println("Starte loadInternalTemperatureThread");
		// loadInternalTemperatureThread.start();
		// System.out.println("Starte loadOutsideTemperatureThread");
		// loadOutsideTemperatureThread.start();
		// System.out.println("Warte auf loadInternalTemperatureThread");
		// if (loadInternalTemperatureThread.isAlive()) {
		// try {
		// loadInternalTemperatureThread.join();
		// } catch (InterruptedException e) {
		// }
		// }
		//
		// System.out.println("Warte auf loadOutsideTemperatureThread");
		// if (loadOutsideTemperatureThread.isAlive()) {
		// try {
		// loadOutsideTemperatureThread.join();
		// } catch (InterruptedException e) {
		// }
		// }

		if (this.statusData.getInternalTemperature() != this.statusData.getOutsideTemperature()) {
			adjustTemperature();
		} else {
			// Thread turnOffAirConditionerThread = new Thread(new Runnable() {
			//
			// @Override
			// public void run() {
			turnOffAirConditioner();
			// }
			// });

			// Thread turnOffHeaterThread = new Thread(new Runnable() {
			//
			// @Override
			// public void run() {
			turnOffHeater();
			// }
			// });

			// Thread closeWindowThread = new Thread(new Runnable() {
			//
			// @Override
			// public void run() {
			closeWindow();
			// }
			// });

			// System.out.println("Starte turnOffAirConditionerThread");
			// turnOffAirConditionerThread.start();
			// System.out.println("Starte turnOffHeaterThread");
			// turnOffHeaterThread.start();
			// System.out.println("Starte closeWindowThread");
			// closeWindowThread.start();
			//
			// System.out.println("Warte auf turnOffAirConditionerThread");
			// if (turnOffAirConditionerThread.isAlive()) {
			// try {
			// turnOffAirConditionerThread.join();
			// } catch (InterruptedException e) {
			// }
			// }
			//
			// System.out.println("Warte auf turnOffHeaterThread");
			// if (turnOffHeaterThread.isAlive()) {
			// try {
			// turnOffHeaterThread.join();
			// } catch (InterruptedException e) {
			// }
			// }
			//
			// System.out.println("Warte auf closeWindowThread");
			// if (closeWindowThread.isAlive()) {
			// try {
			// closeWindowThread.join();
			// } catch (InterruptedException e) {
			// }
			// }
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
		this.statusData.setStateAirConditioner(false);
	}

	private void turnOnAirConditioner() {
		this.statusData.setStateAirConditioner(true);
	}

	private void turnOffHeater() {
		this.statusData.setStateHeater(false);
	}

	private void turnOnHeater() {
		this.statusData.setStateHeater(true);
	}

	private void closeWindow() {
		this.statusData.setStateWindow(false);
	}

	private void openWindow() {
		this.statusData.setStateWindow(true);
	}

	private void loadInternalTemperature() {

		this.statusData.setInternalTemperature(20);
	}

	private void loadOutsideTemperature() {

		this.statusData.setOutsideTemperature(10);
	}
}
