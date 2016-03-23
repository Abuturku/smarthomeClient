
package de.mosbach.lan.smarthome.services;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2016-03-23T14:40:24.049+01:00
 * Generated source version: 2.7.0
 * 
 */
public final class InsideTemperatureService_InsideTemperatureService_Client {

    private static final QName SERVICE_NAME = new QName("http://services.smarthome.lan.mosbach.de/", "insideTemperatureService");

    private InsideTemperatureService_InsideTemperatureService_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = InsideTemperatureService_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        InsideTemperatureService_Service ss = new InsideTemperatureService_Service(wsdlURL, SERVICE_NAME);
        InsideTemperatureService port = ss.getInsideTemperatureService();  
        
        {
        System.out.println("Invoking getInsideTempByRoomName...");
        java.lang.String _getInsideTempByRoomName_roomName = "";
        de.mosbach.lan.smarthome.services.InsideTemperature _getInsideTempByRoomName__return = port.getInsideTempByRoomName(_getInsideTempByRoomName_roomName);
        System.out.println("getInsideTempByRoomName.result=" + _getInsideTempByRoomName__return);


        }
        {
        System.out.println("Invoking setGoalTemperature...");
        java.lang.String _setGoalTemperature_roomName = "";
        double _setGoalTemperature_temperature = 0.0;
        port.setGoalTemperature(_setGoalTemperature_roomName, _setGoalTemperature_temperature);


        }
        {
        System.out.println("Invoking addInsideTemperature...");
        java.lang.String _addInsideTemperature_roomName = "";
        java.lang.String _addInsideTemperature__return = port.addInsideTemperature(_addInsideTemperature_roomName);
        System.out.println("addInsideTemperature.result=" + _addInsideTemperature__return);


        }
        {
        System.out.println("Invoking removeInsideTemperature...");
        java.lang.String _removeInsideTemperature_roomName = "";
        port.removeInsideTemperature(_removeInsideTemperature_roomName);


        }
        {
        System.out.println("Invoking getInsideTemperature...");
        java.lang.String _getInsideTemperature_roomName = "";
        int _getInsideTemperature__return = port.getInsideTemperature(_getInsideTemperature_roomName);
        System.out.println("getInsideTemperature.result=" + _getInsideTemperature__return);


        }

        System.exit(0);
    }

}
