package de.mosbach.lan.smarthomeClient;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

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

	@FXML
	private TextField roomName;

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
			System.out.println("Frage Raumname ab");
			String roomID = this.roomName.getText();
			this.roomName.setEditable(false);
			this.roomName.setStyle("-fx-control-inner-background: lightyellow");

			System.out.println("neuer Controller");
			StatusData statusData = new StatusData();
			this.controller = new Controller(statusData, roomID);
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

		System.out.println("--------------------");
		System.out.println("Aktualisiere");
		System.out.println("--------------------");
		this.loadInsideTempRequirement();
		this.controller.start();

		if (this.statusData.getOutsideTemperature() == IStatusData.DEFECT) {
			this.outsideTemperature.setText("ERROR");
			this.outsideTemperature.setStyle("-fx-control-inner-background: #8B0000");

			this.internalTemperature.setText("---");
			this.stateAirConditioner.setText("---");
			this.stateHeater.setText("---");
			this.stateWindow.setText("---");

			this.internalTemperature.setStyle("-fx-control-inner-background: #8B0000");
			this.stateAirConditioner.setStyle("-fx-control-inner-background: #8B0000");
			this.stateHeater.setStyle("-fx-control-inner-background: #8B0000");
			this.stateWindow.setStyle("-fx-control-inner-background: #8B0000");

		} else {
			this.outsideTemperature.setText(this.statusData.getOutsideTemperature() + "°C");
			this.outsideTemperature.setStyle("-fx-control-inner-background: lightyellow");

			if (this.statusData.getInternalTemperature() == IStatusData.DEFECT) {
				this.internalTemperature.setText("ERROR");

				this.stateAirConditioner.setText("---");
				this.stateHeater.setText("---");
				this.stateWindow.setText("---");

				this.internalTemperature.setStyle("-fx-control-inner-background: #8B0000");
				this.stateAirConditioner.setStyle("-fx-control-inner-background: #8B0000");
				this.stateHeater.setStyle("-fx-control-inner-background: #8B0000");
				this.stateWindow.setStyle("-fx-control-inner-background: #8B0000");
			} else {
				this.internalTemperature.setText(this.statusData.getInternalTemperature() + "°C");
				this.internalTemperature.setStyle("-fx-control-inner-background: lightyellow");

				if (this.statusData.getStateAirConditioner() == IStatusData.TRUE) {
					this.stateAirConditioner.setText("Angeschaltet");
					this.stateAirConditioner.setStyle("-fx-control-inner-background: lightyellow");
				} else if (this.statusData.getStateAirConditioner() == IStatusData.FALSE) {
					this.stateAirConditioner.setText("Ausgeschaltet");
					this.stateAirConditioner.setStyle("-fx-control-inner-background: lightyellow");
				} else if (this.statusData.getStateAirConditioner() == IStatusData.DEFECT) {
					this.stateAirConditioner.setText("Defekt");
					this.stateAirConditioner.setStyle("-fx-control-inner-background: #8B0000");
				}

				if (this.statusData.getStateHeater() == IStatusData.TRUE) {
					this.stateHeater.setText("Angeschaltet");
					this.stateHeater.setStyle("-fx-control-inner-background: lightyellow");
				} else if (this.statusData.getStateHeater() == IStatusData.FALSE) {
					this.stateHeater.setText("Ausgeschaltet");
					this.stateHeater.setStyle("-fx-control-inner-background: lightyellow");
				} else if (this.statusData.getStateHeater() == IStatusData.DEFECT) {
					this.stateHeater.setText("Defekt");
					this.stateHeater.setStyle("-fx-control-inner-background: #8B0000");
				}

				if (this.statusData.getStateWindow() == IStatusData.TRUE) {
					this.stateWindow.setText("Geoeffnet");
					this.stateWindow.setStyle("-fx-control-inner-background: lightyellow");
				} else if (this.statusData.getStateWindow() == IStatusData.FALSE) {
					this.stateWindow.setText("Geschlossen");
					this.stateWindow.setStyle("-fx-control-inner-background: lightyellow");
				} else if (this.statusData.getStateWindow() == IStatusData.DEFECT) {
					this.stateWindow.setText("Defekt");
					this.stateWindow.setStyle("-fx-control-inner-background: #8B0000");
				}

			}
		}

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