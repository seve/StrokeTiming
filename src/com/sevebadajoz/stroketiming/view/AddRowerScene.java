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
    ComboBox<String> mSides;
    @FXML
    TextField mDistance;
    @FXML
    TextField mTime;
    @FXML
    TextField mHeight;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mSides.getItems().setAll("Port", "Starboard", "Both");
    }

    @FXML
    Object add() {
        String name = mName.getText().trim();
        int inches = Integer.parseInt(mHeight.getText());
        double weight = Double.parseDouble(mWeight.getText());
        String side = mSides.getSelectionModel().getSelectedItem();
//        if (!mDistance.getText().trim().equals("") && mTime.getText().trim().equals("")) {
//            ErgPiece ergPiece = new ErgPiece(mTime.getText().trim(), Integer.parseInt(mDistance.getText()));
//            mController.addNewRower(name, weight, inches);
        mController.addNewRower(name, weight, inches);
        clear();
        ViewSwitch.loadScene("Add a Lineup", ViewSwitch.ADD_LINEUP_SCENE);
        return this;
    }

    @FXML
    Object back() {
        clear();
        ViewSwitch.loadScene("Add a Lineup", ViewSwitch.ADD_LINEUP_SCENE);
        return this;
    }

    @FXML
    Object checkCompletion() {
        if (mName.getText().equals("") || mSides.getSelectionModel().isEmpty() || mWeight.getText().equals("") || mHeight.getText().equals("")) {
            mAdd.setDisable(true);
        } else mAdd.setDisable(false);
        return this;
    }

    void clear() {
        mName.clear();
        mHeight.clear();
        mWeight.clear();
        mSides.getSelectionModel().clearSelection();
        mDistance.clear();
        mTime.clear();
    }
}
