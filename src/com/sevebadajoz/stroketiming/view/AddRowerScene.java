package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddRowerScene {
    static Controller mController = Controller.getInstance();
    @FXML
    TextField mName;
    @FXML
    TextField mWeight;
    @FXML
    Button mBack;
    @FXML
    Button mAdd;
}
