
package de.mosbach.lan.smarthome.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMosbachTemperatureToday complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMosbachTemperatureToday">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="testData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMosbachTemperatureToday", propOrder = {
    "testData"
})
public class GetMosbachTemperatureToday {

    protected String testData;

    /**
     * Gets the value of the testData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestData() {
        return testData;
    }

    /**
     * Sets the value of the testData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestData(String value) {
        this.testData = value;
    }

}
