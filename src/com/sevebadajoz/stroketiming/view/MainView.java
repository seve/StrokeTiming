package com.sevebadajoz.stroketiming.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewSwitch.setStage(primaryStage);
        ViewSwitch.loadScene("Stroke Timing", ViewSwitch.BOAT_LIST_SCENE);
    }
}
