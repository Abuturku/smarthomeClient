package de.mosbach.lan.serviceClients;

import java.util.Collection;
import java.util.List;

import javax.xml.ws.BindingProvider;

import com.google.common.collect.Iterables;

import de.mosbach.lan.smarthomeClient.IStatusData;
import de.mosbach.lan.serviceClients.UddiClient;
import de.mosbach.lan.smarthome.smarthomecontrolservice.SmarthomeControlService;
import de.mosbach.lan.smarthome.smarthomecontrolservice.SmarthomeControlService_Service;

public class SmartHomeControlServiceClient {
	private String roomID;
	private SmarthomeControlService port;

	public SmartHomeControlServiceClient(String roomID) {
		this.roomID = roomID;
		try {
			System.out.println("Load SmartHomeControllerService");
			final Collection<javax.xml.registry.infomodel.Service> smartHomeControllerService = UddiClient
					.getServices("WSO2", "smarthomeControlService", 1, 0);

			final javax.xml.registry.infomodel.Service smartHomeControllerServiceDescription = Iterables
					.getFirst(smartHomeControllerService, null);
			String smartHomeControllerServiceEndpoint;
			smartHomeControllerServiceEndpoint = (smartHomeControllerServiceDescription != null)
					? UddiClient.getFirstServiceBinding(smartHomeControllerServiceDescription) : null;
			final SmarthomeControlService_Service ws = new SmarthomeControlService_Service();
			this.port = ws.getSmarthomeControlService();
			final BindingProvider outsideTemperatureBp = (BindingProvider) port;
			outsideTemperatureBp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					smartHomeControllerServiceEndpoint);

			System.out.println("SmartHomeControllerService is Initialisiert");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error while loading SmartHomeControllerService");
		}

	}

	public int[] shutdownAll() {
		int[] status = new int[3];
		if (this.port == null) {
			status[0] = IStatusData.DEFECT;
			status[1] = IStatusData.DEFECT;
			status[2] = IStatusData.DEFECT;
		} else {
			List<Integer> statusList = this.port.shutdownAll(this.roomID);
			status[0] = statusList.get(0);
			status[1] = statusList.get(1);
			status[2] = statusList.get(2);
		}
		return status;
	}

	public int[] openWindows() {
		int[] status = new int[3];
		if (this.port == null) {
			status[0] = IStatusData.DEFECT;
			status[1] = IStatusData.DEFECT;
			status[2] = IStatusData.DEFECT;
		} else {
			List<Integer> statusList = this.port.openWindows(this.roomID);
			status[0] = statusList.get(0);
			status[1] = statusList.get(1);
			status[2] = statusList.get(2);
		}
		return status;
	}

	public int[] turnOnHeaters() {

		int[] status = new int[3];
		if (this.port == null) {
			status[0] = IStatusData.DEFECT;
			status[1] = IStatusData.DEFECT;
			status[2] = IStatusData.DEFECT;
		} else {
			List<Integer> statusList = this.port.turnOnHeater(this.roomID);
			status[0] = statusList.get(0);
			status[1] = statusList.get(1);
			status[2] = statusList.get(2);
		}
		return status;
	}

	public int[] turnOnAirConditioner() {

		int[] status = new int[3];
		if (this.port == null) {
			status[0] = IStatusData.DEFECT;
			status[1] = IStatusData.DEFECT;
			status[2] = IStatusData.DEFECT;
		} else {
			List<Integer> statusList = this.port.turnOnAirConditioner(this.roomID);
			status[0] = statusList.get(0);
			status[1] = statusList.get(1);
			status[2] = statusList.get(2);
		}
		return status;
	}
}
