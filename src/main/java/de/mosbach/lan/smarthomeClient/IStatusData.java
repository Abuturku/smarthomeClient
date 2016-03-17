package de.mosbach.lan.smarthomeClient;

public interface IStatusData {

	public void setInsideTempRequirement(int value);
	
	public int getInternalTemperature();

	public int getOutsideTemperature();

	public boolean getStateAirConditioner();

	public boolean getStateHeater();

	public boolean getStateWindow();
}
