package de.mosbach.lan.smarthome.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2016-03-23T14:40:24.061+01:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://services.smarthome.lan.mosbach.de/", name = "insideTemperatureService")
@XmlSeeAlso({ObjectFactory.class})
public interface InsideTemperatureService {

    @WebMethod
    @RequestWrapper(localName = "getInsideTempByRoomName", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.GetInsideTempByRoomName")
    @ResponseWrapper(localName = "getInsideTempByRoomNameResponse", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.GetInsideTempByRoomNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.mosbach.lan.smarthome.services.InsideTemperature getInsideTempByRoomName(
        @WebParam(name = "roomName", targetNamespace = "")
        java.lang.String roomName
    );

    @WebMethod
    @RequestWrapper(localName = "setGoalTemperature", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.SetGoalTemperature")
    @ResponseWrapper(localName = "setGoalTemperatureResponse", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.SetGoalTemperatureResponse")
    public void setGoalTemperature(
        @WebParam(name = "roomName", targetNamespace = "")
        java.lang.String roomName,
        @WebParam(name = "temperature", targetNamespace = "")
        double temperature
    );

    @WebMethod
    @RequestWrapper(localName = "addInsideTemperature", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.AddInsideTemperature")
    @ResponseWrapper(localName = "addInsideTemperatureResponse", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.AddInsideTemperatureResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String addInsideTemperature(
        @WebParam(name = "roomName", targetNamespace = "")
        java.lang.String roomName
    );

    @WebMethod
    @RequestWrapper(localName = "removeInsideTemperature", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.RemoveInsideTemperature")
    @ResponseWrapper(localName = "removeInsideTemperatureResponse", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.RemoveInsideTemperatureResponse")
    public void removeInsideTemperature(
        @WebParam(name = "roomName", targetNamespace = "")
        java.lang.String roomName
    );

    @WebMethod
    @RequestWrapper(localName = "getInsideTemperature", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.GetInsideTemperature")
    @ResponseWrapper(localName = "getInsideTemperatureResponse", targetNamespace = "http://services.smarthome.lan.mosbach.de/", className = "de.mosbach.lan.smarthome.services.GetInsideTemperatureResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int getInsideTemperature(
        @WebParam(name = "roomName", targetNamespace = "")
        java.lang.String roomName
    );
}