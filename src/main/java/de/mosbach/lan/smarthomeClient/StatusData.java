package de.mosbach.lan.smarthomeClient;

public class StatusData implements IStatusData {

	private int insideTempRequirement = 20;
	private int internalTemperature = 20;
	private int outsideTemperature = 10;
	private boolean stateAirConditioner = false;
	private boolean stateHeater = false;
	private boolean stateWindow = false;

	@Override
	public int getInternalTemperature() {
		return this.internalTemperature;
	}
	
	public int getInsideTempRequirement() {
		return this.insideTempRequirement;
	}

	@Override
	public int getOutsideTemperature() {
		return this.outsideTemperature;
	}

	@Override
	public boolean getStateAirConditioner() {
		return this.stateAirConditioner;
	}

	@Override
	public boolean getStateHeater() {
		return this.stateHeater;
	}

	@Override
	public boolean getStateWindow() {
		return this.stateWindow;
	}

	@Override
	public void setInsideTempRequirement(int value) {
		this.insideTempRequirement = value;
	}

	public void setInternalTemperature(int value) {
		this.internalTemperature = value;
	}

	public void setOutsideTemperature(int value) {
		this.outsideTemperature = value;
	}

	public void setStateAirConditioner(boolean value) {
		this.stateAirConditioner = value;
	}

	public void setStateHeater(boolean value) {
		this.stateHeater = value;
	}

	public void setStateWindow(boolean value) {
		this.stateWindow = value;
	}
}
