package com.sevebadajoz.stroketiming.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

public class BoatListScene {

	@FXML
	private Button mAddButton;
	@FXML
	private Button mExitButton;
	@FXML
	private ListView mBoatList;

	@FXML
	public Object exitCheck() {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?");
		alert.showAndWait()
				.filter(response -> response == ButtonType.OK)
				.ifPresent(response -> System.exit(0));
		return this;
	}

	@FXML
	public Object loadAddBoat() {
		ViewSwitch.loadScene("Add a Boat", ViewSwitch.ADD_BOAT_SCENE);
		return this;
	}
}
