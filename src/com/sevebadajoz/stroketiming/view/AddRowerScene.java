package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddRowerScene implements Initializable {
    static Controller mController = Controller.getInstance();
    @FXML
    TextField mName;
    @FXML
    TextField mWeight;
    @FXML
    Button mBack;
    @FXML
    Button mAdd;
    @FXML
    ComboBox<String> mSides;
    @FXML
    TextField mDistance;
    @FXML
    TextField mTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mSides.getItems().addAll("Port", "Starboard", "Both");
    }

    @FXML
    Object add() {

        return this;
    }
}
