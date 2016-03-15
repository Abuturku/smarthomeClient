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
		 
		
		
	}
}