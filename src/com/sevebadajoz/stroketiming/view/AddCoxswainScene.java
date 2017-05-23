package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.Coxswain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AddCoxswainScene {
    static final Controller mController = Controller.getInstance();
    @FXML
    TextField mName;
    @FXML
    TextField mWeight;
    @FXML
    Button mBack;
    @FXML
    Button mAdd;

    @FXML
    Object back() {
        clear();
        ViewSwitch.loadScene("Add a Lineup", ViewSwitch.ADD_LINEUP_SCENE);
        return this;
    }

    @FXML
    Object add() {
        mController.getCoxswains().add(new Coxswain(mName.getText().trim(), Double.parseDouble(mWeight.getText())));
        ViewSwitch.loadScene("Add a Lineup", ViewSwitch.ADD_LINEUP_SCENE);
        return this;
    }

    void clear() {
        mName.clear();
        mWeight.clear();
    }
}