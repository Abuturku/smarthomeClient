
package de.mosbach.lan.smarthome.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statusData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="insideTempRequirement" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="internalTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="outsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stateAirConditioner" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stateHeater" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stateWindow" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statusData", propOrder = {
    "insideTempRequirement",
    "internalTemperature",
    "outsideTemperature",
    "stateAirConditioner",
    "stateHeater",
    "stateWindow"
})
public class StatusData {

    protected int insideTempRequirement;
    protected int internalTemperature;
    protected int outsideTemperature;
    protected int stateAirConditioner;
    protected int stateHeater;
    protected int stateWindow;

    /**
     * Gets the value of the insideTempRequirement property.
     * 
     */
    public int getInsideTempRequirement() {
        return insideTempRequirement;
    }

    /**
     * Sets the value of the insideTempRequirement property.
     * 
     */
    public void setInsideTempRequirement(int value) {
        this.insideTempRequirement = value;
    }

    /**
     * Gets the value of the internalTemperature property.
     * 
     */
    public int getInternalTemperature() {
        return internalTemperature;
    }

    /**
     * Sets the value of the internalTemperature property.
     * 
     */
    public void setInternalTemperature(int value) {
        this.internalTemperature = value;
    }

    /**
     * Gets the value of the outsideTemperature property.
     * 
     */
    public int getOutsideTemperature() {
        return outsideTemperature;
    }

    /**
     * Sets the value of the outsideTemperature property.
     * 
     */
    public void setOutsideTemperature(int value) {
        this.outsideTemperature = value;
    }

    /**
     * Gets the value of the stateAirConditioner property.
     * 
     */
    public int getStateAirConditioner() {
        return stateAirConditioner;
    }

    /**
     * Sets the value of the stateAirConditioner property.
     * 
     */
    public void setStateAirConditioner(int value) {
        this.stateAirConditioner = value;
    }

    /**
     * Gets the value of the stateHeater property.
     * 
     */
    public int getStateHeater() {
        return stateHeater;
    }

    /**
     * Sets the value of the stateHeater property.
     * 
     */
    public void setStateHeater(int value) {
        this.stateHeater = value;
    }

    /**
     * Gets the value of the stateWindow property.
     * 
     */
    public int getStateWindow() {
        return stateWindow;
    }

    /**
     * Sets the value of the stateWindow property.
     * 
     */
    public void setStateWindow(int value) {
        this.stateWindow = value;
    }

}
