package application;
	

import java.io.IOException;

import controller.ChronometerController;
import controller.ClockController;
import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	Stage currentStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Menu.fxml"));
			root = (BorderPane)loader.load();
			
			MenuController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openClock() {
		
		try {
			BorderPane newRoot;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Clock.fxml"));
			newRoot = (BorderPane)loader.load();
			BorderPane root = (BorderPane) currentStage.getScene().getRoot();
			ClockController controllerz = loader.getController();
			controllerz.setMain(this);
			root.setCenter(newRoot);
			currentStage.setHeight(400);
			currentStage.setWidth(400);
			currentStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void openChronometer() {
		try {
			BorderPane newRoot;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Chronometer.fxml"));
			newRoot = (BorderPane)loader.load();
			BorderPane root = (BorderPane) currentStage.getScene().getRoot();
			ChronometerController controllerz = loader.getController();
			controllerz.setMain(this);
			root.setCenter(newRoot);
			currentStage.setHeight(400);
			currentStage.setWidth(400);
			currentStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
