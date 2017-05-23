package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.Lineup;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class BoatListScene implements Initializable {

	private static Controller mController = Controller.getInstance();
	@FXML
	private Button mAddButton;
	@FXML
	private Button mExitButton;
	@FXML
	private ListView<Lineup> mBoatList;
    @FXML
    private Button mMoreInfo;

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
		ViewSwitch.loadScene("Add a Lineup", ViewSwitch.ADD_LINEUP_SCENE);
		return this;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mBoatList.setItems(mController.getLineups());
	}

    @FXML
    public Object loadInfo() {
        Lineup lineup = mBoatList.getSelectionModel().getSelectedItem();
		mController.setmctiveLineup(lineup);
		ViewSwitch.loadScene("Pieces for " + lineup, ViewSwitch.PRACTICE_LIST_SCENE);
	}
}
