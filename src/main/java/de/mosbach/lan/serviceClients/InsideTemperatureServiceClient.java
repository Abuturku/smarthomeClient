package de.mosbach.lan.serviceClients;

import java.util.Collection;

import javax.xml.registry.JAXRException;
import javax.xml.ws.BindingProvider;

import com.google.common.collect.Iterables; 
import de.mosbach.lan.smarthomeClient.IStatusData;
import de.mosbach.lan.smarthomeClient.StatusData;
import de.mosbach.lan.serviceClients.UddiClient;

public class InsideTemperatureServiceClient {
	private InsideTemperatureService port;
	private final String roomID;

	public InsideTemperatureServiceClient(String roomID) {
		this.roomID = roomID;
		try {
			System.out.println("Load InsideTemperature");
			final Collection<javax.xml.registry.infomodel.Service> insideTemperatureServices = UddiClient
					.getServices("WSO2", "insideTemperatureService", 1, 0);

			final javax.xml.registry.infomodel.Service insideTemperatureServiceDescription = Iterables
					.getFirst(insideTemperatureServices, null);
			String insideTemperatureServiceEndpoint;
			insideTemperatureServiceEndpoint = (insideTemperatureServiceDescription != null)
					? UddiClient.getFirstServiceBinding(insideTemperatureServiceDescription) : null;
			final InsideTemperatureService_Service its = new InsideTemperatureService_Service();
			this.port = its.getInsideTemperatureService();
			final BindingProvider insideTemperatureBp = (BindingProvider) port;
			insideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					insideTemperatureServiceEndpoint);

			System.out.println("InsideTemperature is Initialisiert");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error while loading InsideTemperature");
		}

	}

	public int getTemperature(IStatusData statusData) {
		if (this.port == null) {
			return IStatusData.DEFECT;
		} else {
			final float insideTemperature = this.port
			return (int) insideTemperature;
		}
	}
}
