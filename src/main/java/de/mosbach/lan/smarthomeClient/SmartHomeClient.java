package de.mosbach.lan.smarthomeClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@SuppressWarnings("restriction")
public class SmartHomeClient extends Application {

	@FXML
	private TextField internalTemperature;

	@FXML
	private TextField outsideTemperature;

	@FXML
	private TextField stateWindow;

	@FXML
	private TextField stateHeater;

	@FXML
	private TextField stateAirConditioner;

	@FXML
	private TextField insideTempRequirement;

	private Controller controller;

	private IStatusData statusData;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("gui.fxml"));

		Scene scene = new Scene(root, 600, 425);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@FXML
	private void refresh() {
		if (this.controller == null) {
			System.out.println("neuer Controller");
			StatusData statusData = new StatusData();
			this.controller = new Controller(statusData);
			this.statusData = statusData;

			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						refresh();
					}
				}
			}).start();
		}

		
		this.loadInsideTempRequirement();
		this.controller.start();
		this.internalTemperature.setText(this.statusData.getInternalTemperature() + "°C");
		this.outsideTemperature.setText(this.statusData.getOutsideTemperature() + "°C");
		this.stateAirConditioner.setText(this.statusData.getStateAirConditioner() ? "Angeschaltet" : "Ausgeschaltet");
		this.stateHeater.setText(this.statusData.getStateHeater() ? "Angeschaltet" : "Ausgeschaltet");
		this.stateWindow.setText(this.statusData.getStateWindow() ? "Geoeffnet" : "Geschlossen");

	}

	private void loadInsideTempRequirement() {
		String value = this.insideTempRequirement.getText();
		try {
			int intValue = Integer.valueOf(value);
			this.insideTempRequirement.setStyle("-fx-control-inner-background: #FFFFFF");
			this.statusData.setInsideTempRequirement(intValue);
		} catch (NumberFormatException e) {
			this.insideTempRequirement.setStyle("-fx-control-inner-background: #8B0000");
		}
	}

}