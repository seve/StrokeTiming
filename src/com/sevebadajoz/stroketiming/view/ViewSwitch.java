package com.sevebadajoz.stroketiming.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewSwitch {
    public static final String BOAT_LIST_SCENE = "com/sevebadajoz/stroketiming/view/boatList.fxml";
    public static final String ADD_BOAT_SCENE = "com/sevebadajoz/stroketiming/view/addBoat.fxml";
    public static final String ADD_LINEUP_SCENE = "com/sevebadajoz/stroketiming/view/addLineup.fxml";
    public static final String ADD_ROWER_SCENE = "com/sevebadajoz/stroketiming/view/addRower.fxml";
    public static final String ADD_COXSWAIN_SCENE = "com/sevebadajoz/stroketiming/view/addCoxswain.fxml";
    public static final String PRACTICE_LIST_SCENE = "com/sevebadajoz/stroketiming/view/practiceList.fxml";
    public static final String ADD_PRACTICE_SCENE = "com/sevebadajoz/stroketiming/view/addPractice.fxml";
    public static final String VIEW_ROWERS = "com/sevebadajoz/stroketiming/view/viewRowers.fxml";
    public static final String VIEW_COXSWAINS = "com/sevebadajoz/stroketiming/view/viewCoxswains.fxml";
    public static final String EDIT_ROWER_SCENE = "com/sevebadajoz/stroketiming/view/editRower.fxml";

    public static Stage activeStage;
    public static Stage window;

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

    public static void newWindow(String title, String sceneFXML) {
        window = new Stage();
        window.setTitle(title);
        try {
            Scene scene = new Scene(FXMLLoader.load(ViewSwitch.class.getClassLoader().getResource(sceneFXML)));
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeWindow() {
        window.close();
    }
}