package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.Piece;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class PieceListScene implements Initializable {
    static Controller mController = Controller.getInstance();
    @FXML
    ListView<Piece> mPieces;
    @FXML
    Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mPieces.setItems(mController.getPieces());
    }

    @FXML
    Object back() {
        ViewSwitch.loadScene("Practices for " + mController.getActiveLineup(), ViewSwitch.PRACTICE_LIST_SCENE);
        return this;
    }
}
