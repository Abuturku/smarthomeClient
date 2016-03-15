package de.mosbach.lan.smarthomeClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
@SuppressWarnings("restriction")
public class SmartHomeClient extends Application {
   
     
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
	    Parent root = FXMLLoader.load(this.getClass().getResource("gui.fxml"));
	    
        Scene scene = new Scene(root, 300, 275);
    
        primaryStage.setTitle("Smarthome");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
}