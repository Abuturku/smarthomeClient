package de.mosbach.lan.serviceClients;

import java.util.Collection;

import javax.xml.registry.JAXRException;
import javax.xml.ws.BindingProvider;

import com.google.common.collect.Iterables;
 
import de.mosbach.lan.smarthomeClient.IStatusData;
import de.mosbach.lan.smarthomeClient.StatusData;
import de.mosbach.lan.serviceClients.UddiClient;

public class OutsideTemperatureServiceClient {
	private OutsideTemperatureService port;

	public OutsideTemperatureServiceClient() {
		try {
			System.out.println("Load OutsideTemperature");
			final Collection<javax.xml.registry.infomodel.Service> outsideTemperatureServices = UddiClient
					.getServices("WSO2", "outsideTemperatureService", 1, 0);

			final javax.xml.registry.infomodel.Service outsideTemperatureServiceDescription = Iterables
					.getFirst(outsideTemperatureServices, null);
			String outsideTemperatureServiceEndpoint;
			outsideTemperatureServiceEndpoint = (outsideTemperatureServiceDescription != null)
					? UddiClient.getFirstServiceBinding(outsideTemperatureServiceDescription) : null;
			final OutsideTemperatureService_Service ots = new OutsideTemperatureService_Service();
			this.port = ots.getOutsideTemperatureService();
			final BindingProvider outsideTemperatureBp = (BindingProvider) port;
			outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					outsideTemperatureServiceEndpoint);

			System.out.println("OutsideTemperature is Initialisiert");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error while loading OutsideTemperature");
		}

	}

	public int getTemperature() {
		if (this.port == null) {
			return IStatusData.DEFECT;
		} else {
			final float outsideTemperature = this.port.getMosbachTemperatureToday();
			return (int) outsideTemperature;
		}
	}
}
