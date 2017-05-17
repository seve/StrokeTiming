package com.sevebadajoz.stroketiming.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class BoatListScene {

	@FXML
	private Button mAddButton;
	@FXML
	private Button mExitButton;
	@FXML
	private ListView mBoatList;

	@FXML
	public Object exitCheck() {
		ViewSwitch.newWindow("Are You Sure?", ViewSwitch.EXIT_PROMPT_SCENE);
		return this;
	}

	@FXML
	public Object loadAddBoat() {
		ViewSwitch.loadScene("Add a Boat", ViewSwitch.ADD_BOAT_SCENE);
		return this;
	}
}
