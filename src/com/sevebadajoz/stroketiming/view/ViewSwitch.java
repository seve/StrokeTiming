package com.sevebadajoz.stroketiming.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewSwitch {
    public static final String BOAT_LIST_SCENE = "boatList.fxml";
    public static Stage activeStage;

    public static void setStage(Stage stage) {
        activeStage = stage;
    }

    public static void loadScene(String title, String sceneFXML) {
        try {
            activeStage.setTitle(title);
            Scene scene = new Scene(FXMLLoader.load(ViewSwitch.class.getClassLoader().getResource(sceneFXML)));
            activeStage.setScene(scene);
            activeStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

