
package de.mosbach.lan.smarthome.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.mosbach.lan.smarthome.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMosbachTemperatureToday_QNAME = new QName("http://services.smarthome.lan.mosbach.de/", "getMosbachTemperatureToday");
    private final static QName _GetMosbachTemperatureTodayResponse_QNAME = new QName("http://services.smarthome.lan.mosbach.de/", "getMosbachTemperatureTodayResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.mosbach.lan.smarthome.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMosbachTemperatureToday }
     * 
     */
    public GetMosbachTemperatureToday createGetMosbachTemperatureToday() {
        return new GetMosbachTemperatureToday();
    }

    /**
     * Create an instance of {@link GetMosbachTemperatureTodayResponse }
     * 
     */
    public GetMosbachTemperatureTodayResponse createGetMosbachTemperatureTodayResponse() {
        return new GetMosbachTemperatureTodayResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMosbachTemperatureToday }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.smarthome.lan.mosbach.de/", name = "getMosbachTemperatureToday")
    public JAXBElement<GetMosbachTemperatureToday> createGetMosbachTemperatureToday(GetMosbachTemperatureToday value) {
        return new JAXBElement<GetMosbachTemperatureToday>(_GetMosbachTemperatureToday_QNAME, GetMosbachTemperatureToday.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMosbachTemperatureTodayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.smarthome.lan.mosbach.de/", name = "getMosbachTemperatureTodayResponse")
    public JAXBElement<GetMosbachTemperatureTodayResponse> createGetMosbachTemperatureTodayResponse(GetMosbachTemperatureTodayResponse value) {
        return new JAXBElement<GetMosbachTemperatureTodayResponse>(_GetMosbachTemperatureTodayResponse_QNAME, GetMosbachTemperatureTodayResponse.class, null, value);
    }

}
