package views;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import model.Animal;
import model.Appointment;
import model.Medic;
import util.DatabaseUtil;

public class MainController implements Initializable {

	@FXML
	private TableView<String> mainListView;
	
	@FXML
	private Label nameLabel;
	@FXML 
	private Label petNameLabel;
	
	private List<Medic> listOfMedics;
	private List<Animal> listOfAnimals;
	private List<Appointment> listOfAppointments;
	
	public void setListOfMedicNames() throws Exception {
		DatabaseUtil dbVariable = new DatabaseUtil();
		dbVariable.setUp();
		dbVariable.startTransaction();
		this.listOfMedics = (List<Medic>) dbVariable.getAllMedicsFromDatabase();
		dbVariable.stopEntityManager();
	}
	
	
	public ObservableList<String> getNameOfMedics(List<Medic> listOfMedics) {
		ObservableList<String> nameOfMedicsList = FXCollections.observableArrayList();
		for (Medic medic : listOfMedics) nameOfMedicsList.add(medic.getNameOfMedic());
		return nameOfMedicsList;
	}
	
	public void setListOfAnimalNames() throws Exception {
		DatabaseUtil dbVariable = new DatabaseUtil();
		dbVariable.setUp();
		dbVariable.startTransaction();
		this.listOfAnimals = (List<Animal>) dbVariable.getAllAnimalsFromDatabase();
		dbVariable.stopEntityManager();
	}
	
	
	public ObservableList<String> getNameOfAnimals(List<Animal> listOfAnimals) {
		ObservableList<String> nameOfAnimalsList = FXCollections.observableArrayList();
		for (Animal animal : listOfAnimals) nameOfAnimalsList.add(animal.getNameOfAnimal());
		return nameOfAnimalsList;
	}
	
	public void populateMainListView() throws Exception {
		setListOfMedicNames();
		this.mainListView.setItems(getNameOfMedics(listOfMedics));
		this.mainListView.refresh();
	}
	
	public void showAppointmentDetail(Medic medic) {
		if (medic != null) {
			nameLabel.setText(medic.getNameOfMedic());
			
		} else {
			nameLabel.setText("");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			populateMainListView();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
