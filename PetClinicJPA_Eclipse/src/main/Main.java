package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Medic;
import util.DatabaseUtil;


public class Main extends Application {
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Pet Clinic");
		
		initializeRootLayout();
		showAppointmentView();
	}
	
	public void initializeRootLayout( ) {
		try {
			FXMLLoader loaderVariable = new FXMLLoader();
			loaderVariable.setLocation(Main.class.getResource("/views/RootLayout.fxml"));
			rootLayout = (BorderPane) loaderVariable.load();
			
			Scene sceneVariable = new Scene(rootLayout);
			primaryStage.setScene(sceneVariable);
			primaryStage.show();
			
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
	public void showAppointmentView() {
		try {
			FXMLLoader loaderVariable = new FXMLLoader();
			loaderVariable.setLocation(Main.class.getResource("/views/AppointmentView.fxml"));
			AnchorPane appointmentPane = (AnchorPane) loaderVariable.load();
			
			rootLayout.setCenter(appointmentPane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage( ) {
		return primaryStage;
	}
	
	
	
	public static void main (String[] args) throws Exception {
		launch(args);
		/*
        DatabaseUtil dbUtil = new DatabaseUtil();
        Medic medicToBeAddedToDatabase = new Medic();

        medicToBeAddedToDatabase.setIdmedic(5);
        medicToBeAddedToDatabase.setNameOfMedic("Jonny");
		
        dbUtil.setUp();
        dbUtil.startTransaction();
        dbUtil.commitTransaction();
        dbUtil.printAllMedicsFromDatabase();
        dbUtil.stopEntityManager(); 
        */
	}
	
	
}
