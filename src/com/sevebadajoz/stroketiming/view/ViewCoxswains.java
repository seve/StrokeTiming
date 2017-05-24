package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.Coxswain;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewCoxswains implements Initializable {

    private static final Controller mController = Controller.getInstance();
    @FXML
    private Button mBackButton;
    @FXML
    private ListView<Coxswain> mCoxswainsListView;
    @FXML
    public Object exit()
    {
        ViewSwitch.loadScene("Stroke Timing", ViewSwitch.BOAT_LIST_SCENE);
        return this;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mCoxswainsListView.setItems(mController.getCoxswains());
    }
}
