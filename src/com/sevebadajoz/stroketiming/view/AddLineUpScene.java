package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.Boat;
import com.sevebadajoz.stroketiming.model.Coxswain;
import com.sevebadajoz.stroketiming.model.Rower;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AddLineUpScene implements Initializable {
    static final Controller mController = Controller.getInstance();
    @FXML
    Button mBack;
    @FXML
    Button mAddLineup;
    @FXML
    Button mAddBoat;
    @FXML
    Button mAddRower;
    @FXML
    Button mAddCoxswain;

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
        mController.addNewLineup(rowers, coxswain, boat);

        ViewSwitch.loadScene("Stroke Timing", ViewSwitch.BOAT_LIST_SCENE);
        return this;
    }

    @FXML
    Object exit() {
        ViewSwitch.loadScene("Stroke Timing", ViewSwitch.BOAT_LIST_SCENE);
        return this;
    }

    @FXML
    Object addNewBoat() {
        ViewSwitch.loadScene("Add New Boat", ViewSwitch.ADD_BOAT_SCENE);
        return this;
    }

    @FXML
    Object addNewRower() {
        ViewSwitch.loadScene("Add New Rower", ViewSwitch.ADD_ROWER_SCENE);
        return this;
    }

    @FXML
    Object addNewCoxswain() {
        ViewSwitch.loadScene("Add New Coxswain", ViewSwitch.ADD_COXSWAIN_SCENE);
        return this;
    }

    @FXML
    Object checkCompletion() {
        if (mBoat.getSelectionModel().isEmpty() || mCoxswain.getSelectionModel().isEmpty() || mStroke.getSelectionModel().isEmpty() || mSevenSeat.getSelectionModel().isEmpty() ||
                mSixSeat.getSelectionModel().isEmpty() || mFiveSeat.getSelectionModel().isEmpty() || mFourSeat.getSelectionModel().isEmpty() || mThreeSeat.getSelectionModel().isEmpty()
                || mTwoSeat.getSelectionModel().isEmpty() || mBowSeat.getSelectionModel().isEmpty()) {
            mAddLineup.setDisable(true);
        } else mAddLineup.setDisable(false);
        return this;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mBoat.getItems().setAll(mController.getBoats());
        mCoxswain.getItems().setAll(mController.getCoxswains());
        ObservableList<Rower> allRowers = mController.getRowers();
        mStroke.getItems().setAll(allRowers);
        mSevenSeat.getItems().setAll(allRowers);
        mSixSeat.getItems().setAll(allRowers);
        mFiveSeat.getItems().setAll(allRowers);
        mFourSeat.getItems().setAll(allRowers);
        mThreeSeat.getItems().setAll(allRowers);
        mTwoSeat.getItems().setAll(allRowers);
        mBowSeat.getItems().setAll(allRowers);

    }
}
