package de.mosbach.lan.smarthomeClient;

public interface IStatusData {

	public static final int TRUE = 0;
	public static final int FALSE = 1;
	public static final int DEFECT = -1;

	public void setInsideTempRequirement(int value);
	
	public int getInsideTempRequirement();

	public int getInternalTemperature();

	public int getOutsideTemperature();

	public int getStateAirConditioner();

	public int getStateHeater();

	public int getStateWindow();
}
