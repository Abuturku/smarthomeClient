
package de.mosbach.lan.smarthome.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for state.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="state">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OPENED"/>
 *     &lt;enumeration value="CLOSED"/>
 *     &lt;enumeration value="MALFUNCTIONING"/>
 *     &lt;enumeration value="TURNED_ON"/>
 *     &lt;enumeration value="TURNED_OFF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "state")
@XmlEnum
public enum State {

    OPENED,
    CLOSED,
    MALFUNCTIONING,
    TURNED_ON,
    TURNED_OFF;

    public String value() {
        return name();
    }

    public static State fromValue(String v) {
        return valueOf(v);
    }

}
