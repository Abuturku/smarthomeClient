package de.mosbach.lan.serviceClients;

import java.util.Collection;

import javax.xml.registry.JAXRException;
import javax.xml.ws.BindingProvider;

import com.google.common.collect.Iterables;

import de.mosbach.lan.smarthome.services.OutsideTemperatureService;
import de.mosbach.lan.smarthome.services.OutsideTemperatureService_Service;
import de.mosbach.lan.serviceClients.UddiClient;

public class OutsideTemperatureServiceClient{
	
	public static void main(String[] args) throws JAXRException{
		
		final Collection<javax.xml.registry.infomodel.Service> outsideTemperatureServices = UddiClient.getServices("WSO2", "outsideTemperatureService", 1, 0);
		
		final javax.xml.registry.infomodel.Service outsideTemperatureServiceDescription = Iterables.getFirst(outsideTemperatureServices, null);
		final String outsideTemperatureServiceEndpoint = (outsideTemperatureServiceDescription != null)
				? UddiClient.getFirstServiceBinding(outsideTemperatureServiceDescription) : null;
				
		final OutsideTemperatureService_Service ots = new OutsideTemperatureService_Service();
		final OutsideTemperatureService port = ots.getOutsideTemperatureServicePort();
		final BindingProvider outsideTemperatureBp = (BindingProvider) port;
		outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, outsideTemperatureServiceEndpoint);
		
		final float outsideTemperature = port.getMosbachTemperatureToday("test");
		System.out.println(outsideTemperature);
		
	}
	

}
