package de.mosbach.lan.smarthome.services;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2016-03-23T18:42:28.884+01:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://services.smarthome.lan.mosbach.de/", name = "outsideTemperatureService")
@XmlSeeAlso({ObjectFactory.class})
public interface OutsideTemperatureService {

    @WebMethod
    @RequestWrapper(localName = "getMosbachTemperatureToday", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.GetMosbachTemperatureToday")
    @ResponseWrapper(localName = "getMosbachTemperatureTodayResponse", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.GetMosbachTemperatureTodayResponse")
    @WebResult(name = "return", targetNamespace = "")
    public float getMosbachTemperatureToday();
}
