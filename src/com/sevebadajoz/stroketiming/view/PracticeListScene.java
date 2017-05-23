package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.Practice;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class PracticeListScene implements Initializable {

    static Controller mController = Controller.getInstance();

    @FXML
    ListView<Practice> mPractices;

    @FXML
    Button addPractice;
    @FXML
    Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mPractices.setItems(mController.getPractices());
    }

    @FXML
    Object addPractice() {
        ViewSwitch.loadScene("Add New Practice", ViewSwitch.ADD_PRACTICE_SCENE);
        return this;
    }

    @FXML
    Object back() {
        ViewSwitch.loadScene("Stroke Timing", ViewSwitch.BOAT_LIST_SCENE);
        return this;
    }
}
