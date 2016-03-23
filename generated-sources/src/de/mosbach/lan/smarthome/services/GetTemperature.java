
package de.mosbach.lan.smarthome.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTemperature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTemperature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roomName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusData" type="{http://services.smarthome.lan.mosbach.de/}statusData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTemperature", propOrder = {
    "roomName",
    "statusData"
})
public class GetTemperature {

    @XmlElement(required = true)
    protected String roomName;
    @XmlElement(required = true)
    protected StatusData statusData;

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
     * Gets the value of the statusData property.
     * 
     * @return
     *     possible object is
     *     {@link StatusData }
     *     
     */
    public StatusData getStatusData() {
        return statusData;
    }

    /**
     * Sets the value of the statusData property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusData }
     *     
     */
    public void setStatusData(StatusData value) {
        this.statusData = value;
    }

}
