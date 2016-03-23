
package de.mosbach.lan.smarthome.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insideTemperature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insideTemperature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="currentTemp" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="deltaTemp" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="goalTemp" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="neededTime" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="roomName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startTemp" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="timePassed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insideTemperature", propOrder = {
    "a",
    "currentTemp",
    "deltaTemp",
    "goalTemp",
    "neededTime",
    "roomName",
    "sign",
    "startTemp",
    "startTime",
    "timePassed"
})
public class InsideTemperature {

    protected double a;
    protected double currentTemp;
    protected double deltaTemp;
    protected double goalTemp;
    protected double neededTime;
    protected String roomName;
    protected int sign;
    protected double startTemp;
    protected long startTime;
    protected long timePassed;

    /**
     * Gets the value of the a property.
     * 
     */
    public double getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     */
    public void setA(double value) {
        this.a = value;
    }

    /**
     * Gets the value of the currentTemp property.
     * 
     */
    public double getCurrentTemp() {
        return currentTemp;
    }

    /**
     * Sets the value of the currentTemp property.
     * 
     */
    public void setCurrentTemp(double value) {
        this.currentTemp = value;
    }

    /**
     * Gets the value of the deltaTemp property.
     * 
     */
    public double getDeltaTemp() {
        return deltaTemp;
    }

    /**
     * Sets the value of the deltaTemp property.
     * 
     */
    public void setDeltaTemp(double value) {
        this.deltaTemp = value;
    }

    /**
     * Gets the value of the goalTemp property.
     * 
     */
    public double getGoalTemp() {
        return goalTemp;
    }

    /**
     * Sets the value of the goalTemp property.
     * 
     */
    public void setGoalTemp(double value) {
        this.goalTemp = value;
    }

    /**
     * Gets the value of the neededTime property.
     * 
     */
    public double getNeededTime() {
        return neededTime;
    }

    /**
     * Sets the value of the neededTime property.
     * 
     */
    public void setNeededTime(double value) {
        this.neededTime = value;
    }

    /**
     * Gets the value of the roomName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the value of the roomName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomName(String value) {
        this.roomName = value;
    }

    /**
     * Gets the value of the sign property.
     * 
     */
    public int getSign() {
        return sign;
    }

    /**
     * Sets the value of the sign property.
     * 
     */
    public void setSign(int value) {
        this.sign = value;
    }

    /**
     * Gets the value of the startTemp property.
     * 
     */
    public double getStartTemp() {
        return startTemp;
    }

    /**
     * Sets the value of the startTemp property.
     * 
     */
    public void setStartTemp(double value) {
        this.startTemp = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     */
    public void setStartTime(long value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the timePassed property.
     * 
     */
    public long getTimePassed() {
        return timePassed;
    }

    /**
     * Sets the value of the timePassed property.
     * 
     */
    public void setTimePassed(long value) {
        this.timePassed = value;
    }

}
