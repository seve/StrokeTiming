package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBoatScene {
    static final Controller mController = Controller.getInstance();
    // TODO: 5/22/2017 Add make and seat number functionality
    @FXML
    Button mBackButton;
    @FXML
    TextField mBoatName;
    @FXML
    TextField mBoatType;
    @FXML
    TextField mBoatWeight;
    @FXML
    Button mAddButton;

    @FXML
    Object addBoat() {
        String name = mBoatName.getText();
        String boatType = mBoatType.getText();
        String weight = mBoatWeight.getText().trim();
        if (weight.equals("")) {
            mController.addNewBoat(name, 8, 0, boatType);
        } else {
            mController.addNewBoat(name, 8, Integer.parseInt(weight), boatType);
        }
        ViewSwitch.loadScene("Add Lineup", ViewSwitch.ADD_LINEUP_SCENE);
        return this;
    }

    @FXML
    Object back() {
        clear();
        ViewSwitch.loadScene("Add Lineup", ViewSwitch.ADD_LINEUP_SCENE);
        return this;
    }

    @FXML
    Object clear() {
        mBoatName.setText("");
        mBoatType.setText("");
        mBoatWeight.setText("");
        return this;
    }
}
