package de.mosbach.lan.serviceClients;

import java.util.Collection;

import javax.xml.ws.BindingProvider;

import com.google.common.collect.Iterables;

import de.mosbach.lan.smarthomeClient.IStatusData;
import de.mosbach.lan.serviceClients.UddiClient;

public class SmartHomeControlServiceClient {
	private SmartHomeControllerService port;
	private String roomID;

	public SmartHomeControlServiceClient(String roomID) {
		this.roomID = roomID;
		try {
			System.out.println("Load SmartHomeControllerService");
			final Collection<javax.xml.registry.infomodel.Service> smartHomeControllerService = UddiClient
					.getServices("WSO2", "smartHomeControllerService", 1, 0);

			final javax.xml.registry.infomodel.Service smartHomeControllerServiceDescription = Iterables
					.getFirst(smartHomeControllerService, null);
			String smartHomeControllerServiceEndpoint;
			smartHomeControllerServiceEndpoint = (smartHomeControllerServiceDescription != null)
					? UddiClient.getFirstServiceBinding(smartHomeControllerServiceDescription) : null;
			final SmartHomeControllerService_Service ws = new SmartHomeControllerService_Service();
			this.port = ws.getSmartHomeControllerService();
			final BindingProvider outsideTemperatureBp = (BindingProvider) port;
			outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					smartHomeControllerServiceEndpoint);

			System.out.println("SmartHomeControllerService is Initialisiert");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error while loading SmartHomeControllerService");
		}

	}

	public int[] closeAll() {
		if (this.port == null) {
			int[] status = new int[3];
			status[0] = IStatusData.DEFECT;
			status[1] = IStatusData.DEFECT;
			status[2] = IStatusData.DEFECT;
			return status;
		} else {

		}
	}

	public int[] openWindow() {
		if (this.port == null) {
			int[] status = new int[3];
			status[0] = IStatusData.DEFECT;
			status[1] = IStatusData.DEFECT;
			status[2] = IStatusData.DEFECT;
			return status;
		} else {

		}
	}

	public int[] turnOnHeater() {
		if (this.port == null) {
			int[] status = new int[3];
			status[0] = IStatusData.DEFECT;
			status[1] = IStatusData.DEFECT;
			status[2] = IStatusData.DEFECT;
			return status;
		} else {

		}
	}

	public int[] turnOnAirCondition() {
		if (this.port == null) {
			int[] status = new int[3];
			status[0] = IStatusData.DEFECT;
			status[1] = IStatusData.DEFECT;
			status[2] = IStatusData.DEFECT;
			return status;
		} else {

		}
	}
}
