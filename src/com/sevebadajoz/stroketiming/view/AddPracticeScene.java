package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.WaterPiece;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddPracticeScene {
    static Controller mController = Controller.getInstance();
    @FXML
    Button mChooseFile;
    @FXML
    Button mAdd;
    @FXML
    ListView<WaterPiece> mWaterPieces;
    @FXML
    TextField mFileLocation;

    @FXML
    Object chooseFile() {
        mFileLocation.setText(new FileChooser().showOpenDialog(new Stage()).toString());
        return this;
    }

}
