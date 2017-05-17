package com.sevebadajoz.stroketiming.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewSwitch {
    public static final String BOAT_LIST_SCENE = "com/sevebadajoz/stroketiming/view/boatList.fxml";
	public static final String ADD_BOAT_SCENE = "com/sevebadajoz/stroketiming/view/addBoat.fxml";
	public static final String EXIT_PROMPT_SCENE = "com/sevebadajoz/stroketiming/view/exitPrompt.fxml";
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

    public static void newWindow(String title, String sceneFXML) {
    	Stage stage = new Stage();
	    stage.setTitle(title);
	    try {
		    Scene scene = new Scene(FXMLLoader.load(ViewSwitch.class.getClassLoader().getResource(sceneFXML)));
		    stage.setScene(scene);
		    stage.show();
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
    }
}

