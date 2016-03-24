
package de.mosbach.lan.smarthome.smarthomecontrolservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.mosbach.lan.smarthome.smarthomecontrolservice package. 
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

    private final static QName _TurnOnAirConditioner_QNAME = new QName("http://smarthomeControlService.smarthome.lan.mosbach.de/", "turnOnAirConditioner");
    private final static QName _TurnOnHeaterResponse_QNAME = new QName("http://smarthomeControlService.smarthome.lan.mosbach.de/", "turnOnHeaterResponse");
    private final static QName _OpenWindowsResponse_QNAME = new QName("http://smarthomeControlService.smarthome.lan.mosbach.de/", "openWindowsResponse");
    private final static QName _ShutdownAll_QNAME = new QName("http://smarthomeControlService.smarthome.lan.mosbach.de/", "shutdownAll");
    private final static QName _TurnOnAirConditionerResponse_QNAME = new QName("http://smarthomeControlService.smarthome.lan.mosbach.de/", "turnOnAirConditionerResponse");
    private final static QName _ShutdownAllResponse_QNAME = new QName("http://smarthomeControlService.smarthome.lan.mosbach.de/", "shutdownAllResponse");
    private final static QName _TurnOnHeater_QNAME = new QName("http://smarthomeControlService.smarthome.lan.mosbach.de/", "turnOnHeater");
    private final static QName _OpenWindows_QNAME = new QName("http://smarthomeControlService.smarthome.lan.mosbach.de/", "openWindows");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.mosbach.lan.smarthome.smarthomecontrolservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TurnOnAirConditioner }
     * 
     */
    public TurnOnAirConditioner createTurnOnAirConditioner() {
        return new TurnOnAirConditioner();
    }

    /**
     * Create an instance of {@link ShutdownAll }
     * 
     */
    public ShutdownAll createShutdownAll() {
        return new ShutdownAll();
    }

    /**
     * Create an instance of {@link OpenWindows }
     * 
     */
    public OpenWindows createOpenWindows() {
        return new OpenWindows();
    }

    /**
     * Create an instance of {@link TurnOnAirConditionerResponse }
     * 
     */
    public TurnOnAirConditionerResponse createTurnOnAirConditionerResponse() {
        return new TurnOnAirConditionerResponse();
    }

    /**
     * Create an instance of {@link TurnOnHeaterResponse }
     * 
     */
    public TurnOnHeaterResponse createTurnOnHeaterResponse() {
        return new TurnOnHeaterResponse();
    }

    /**
     * Create an instance of {@link TurnOnHeater }
     * 
     */
    public TurnOnHeater createTurnOnHeater() {
        return new TurnOnHeater();
    }

    /**
     * Create an instance of {@link ShutdownAllResponse }
     * 
     */
    public ShutdownAllResponse createShutdownAllResponse() {
        return new ShutdownAllResponse();
    }

    /**
     * Create an instance of {@link OpenWindowsResponse }
     * 
     */
    public OpenWindowsResponse createOpenWindowsResponse() {
        return new OpenWindowsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TurnOnAirConditioner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smarthomeControlService.smarthome.lan.mosbach.de/", name = "turnOnAirConditioner")
    public JAXBElement<TurnOnAirConditioner> createTurnOnAirConditioner(TurnOnAirConditioner value) {
        return new JAXBElement<TurnOnAirConditioner>(_TurnOnAirConditioner_QNAME, TurnOnAirConditioner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TurnOnHeaterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smarthomeControlService.smarthome.lan.mosbach.de/", name = "turnOnHeaterResponse")
    public JAXBElement<TurnOnHeaterResponse> createTurnOnHeaterResponse(TurnOnHeaterResponse value) {
        return new JAXBElement<TurnOnHeaterResponse>(_TurnOnHeaterResponse_QNAME, TurnOnHeaterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenWindowsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smarthomeControlService.smarthome.lan.mosbach.de/", name = "openWindowsResponse")
    public JAXBElement<OpenWindowsResponse> createOpenWindowsResponse(OpenWindowsResponse value) {
        return new JAXBElement<OpenWindowsResponse>(_OpenWindowsResponse_QNAME, OpenWindowsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShutdownAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smarthomeControlService.smarthome.lan.mosbach.de/", name = "shutdownAll")
    public JAXBElement<ShutdownAll> createShutdownAll(ShutdownAll value) {
        return new JAXBElement<ShutdownAll>(_ShutdownAll_QNAME, ShutdownAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TurnOnAirConditionerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smarthomeControlService.smarthome.lan.mosbach.de/", name = "turnOnAirConditionerResponse")
    public JAXBElement<TurnOnAirConditionerResponse> createTurnOnAirConditionerResponse(TurnOnAirConditionerResponse value) {
        return new JAXBElement<TurnOnAirConditionerResponse>(_TurnOnAirConditionerResponse_QNAME, TurnOnAirConditionerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShutdownAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smarthomeControlService.smarthome.lan.mosbach.de/", name = "shutdownAllResponse")
    public JAXBElement<ShutdownAllResponse> createShutdownAllResponse(ShutdownAllResponse value) {
        return new JAXBElement<ShutdownAllResponse>(_ShutdownAllResponse_QNAME, ShutdownAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TurnOnHeater }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smarthomeControlService.smarthome.lan.mosbach.de/", name = "turnOnHeater")
    public JAXBElement<TurnOnHeater> createTurnOnHeater(TurnOnHeater value) {
        return new JAXBElement<TurnOnHeater>(_TurnOnHeater_QNAME, TurnOnHeater.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenWindows }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smarthomeControlService.smarthome.lan.mosbach.de/", name = "openWindows")
    public JAXBElement<OpenWindows> createOpenWindows(OpenWindows value) {
        return new JAXBElement<OpenWindows>(_OpenWindows_QNAME, OpenWindows.class, null, value);
    }

}
