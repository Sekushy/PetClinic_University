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
import model.Medic;
import util.DatabaseUtil;

public class MainController implements Initializable {

	@FXML
	private TableView<String> mainListView;
	
	@FXML
	private Label nameLabel;
	
	private List<Medic> listOfMedics;
	
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
