package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.Boat;
import com.sevebadajoz.stroketiming.model.Coxswain;
import com.sevebadajoz.stroketiming.model.Lineup;
import com.sevebadajoz.stroketiming.model.Rower;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AddLineUpScene implements Initializable {
    static Controller mController = Controller.getInstance();
    @FXML
    Button mBack;
    @FXML
    Button mAdd;
    @FXML
    ComboBox<Boat> mBoat;
    @FXML
    ComboBox<Coxswain> mCoxswain;
    @FXML
    ComboBox<Rower> mStroke;
    @FXML
    ComboBox<Rower> mSevenSeat;
    @FXML
    ComboBox<Rower> mSixSeat;
    @FXML
    ComboBox<Rower> mFiveSeat;
    @FXML
    ComboBox<Rower> mFourSeat;
    @FXML
    ComboBox<Rower> mThreeSeat;
    @FXML
    ComboBox<Rower> mTwoSeat;
    @FXML
    ComboBox<Rower> mBowSeat;

    @FXML
    Object addLineup() {
        Boat boat = mBoat.getSelectionModel().getSelectedItem();
        Coxswain coxswain = mCoxswain.getSelectionModel().getSelectedItem();
        Rower stroke = mStroke.getSelectionModel().getSelectedItem();
        Rower seven = mSevenSeat.getSelectionModel().getSelectedItem();
        Rower six = mSixSeat.getSelectionModel().getSelectedItem();
        Rower five = mFiveSeat.getSelectionModel().getSelectedItem();
        Rower four = mFourSeat.getSelectionModel().getSelectedItem();
        Rower three = mThreeSeat.getSelectionModel().getSelectedItem();
        Rower two = mTwoSeat.getSelectionModel().getSelectedItem();
        Rower bow = mBowSeat.getSelectionModel().getSelectedItem();
        Rower[] rowers = {stroke, seven, six, five, four, three, two, bow};
        mController.getLineups().add(new Lineup(rowers, coxswain, boat));
        ViewSwitch.loadScene("Stroke Timing", ViewSwitch.BOAT_LIST_SCENE);
        return this;
    }

    @FXML
    Object exit() {
        ViewSwitch.loadScene("Stroke Timing", ViewSwitch.BOAT_LIST_SCENE);
        return this;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!mController.getBoats().isEmpty())
            mBoat.getItems().addAll(mController.getBoats());
        else
            mBoat.setPlaceholder(new Label("Add a Boat"));
        if (!mController.getCoxswains().isEmpty())
            mCoxswain.getItems().addAll(mController.getCoxswains());
        else
            mCoxswain.setPlaceholder(new Label("Add a Coxswain"));
        if (!mController.getRowers().isEmpty()) {
            mStroke.getItems().addAll(mController.getRowers());
            mSevenSeat.getItems().addAll(mController.getRowers());
            mSixSeat.getItems().addAll(mController.getRowers());
            mFiveSeat.getItems().addAll(mController.getRowers());
            mFourSeat.getItems().addAll(mController.getRowers());
            mThreeSeat.getItems().addAll(mController.getRowers());
            mTwoSeat.getItems().addAll(mController.getRowers());
            mBowSeat.getItems().addAll(mController.getRowers());
        } else {
            mStroke.setPlaceholder(new Label("Add a Rower"));
            mSevenSeat.setPlaceholder(new Label("Add a Rower"));
            mSixSeat.setPlaceholder(new Label("Add a Rower"));
            mFiveSeat.setPlaceholder(new Label("Add a Rower"));
            mFourSeat.setPlaceholder(new Label("Add a Rower"));
            mThreeSeat.setPlaceholder(new Label("Add a Rower"));
            mTwoSeat.setPlaceholder(new Label("Add a Rower"));
            mBowSeat.setPlaceholder(new Label("Add a Rower"));
        }
    }
}
