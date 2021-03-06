package de.mosbach.lan.smarthome.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2016-03-24T09:24:18.103+01:00
 * Generated source version: 2.7.0
 * 
 */
@WebServiceClient(name = "outsideTemperatureService", 
                  wsdlLocation = "http://10.50.12.187:9763/smartHomeServices/services/outsideTemperatureService?wsdl",
                  targetNamespace = "http://services.smarthome.lan.mosbach.de/") 
public class OutsideTemperatureService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services.smarthome.lan.mosbach.de/", "outsideTemperatureService");
    public final static QName OutsideTemperatureService = new QName("http://services.smarthome.lan.mosbach.de/", "outsideTemperatureService");
    static {
        URL url = null;
        try {
            url = new URL("http://10.50.12.187:9763/smartHomeServices/services/outsideTemperatureService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(OutsideTemperatureService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://10.50.12.187:9763/smartHomeServices/services/outsideTemperatureService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public OutsideTemperatureService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public OutsideTemperatureService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OutsideTemperatureService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public OutsideTemperatureService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public OutsideTemperatureService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public OutsideTemperatureService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns OutsideTemperatureService
     */
    @WebEndpoint(name = "outsideTemperatureService")
    public OutsideTemperatureService getOutsideTemperatureService() {
        return super.getPort(OutsideTemperatureService, OutsideTemperatureService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OutsideTemperatureService
     */
    @WebEndpoint(name = "outsideTemperatureService")
    public OutsideTemperatureService getOutsideTemperatureService(WebServiceFeature... features) {
        return super.getPort(OutsideTemperatureService, OutsideTemperatureService.class, features);
    }

}
