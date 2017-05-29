package com.sevebadajoz.stroketiming.view;

import com.sevebadajoz.stroketiming.controller.Controller;
import com.sevebadajoz.stroketiming.model.Rower;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditRowerScene implements Initializable {
	@FXML
	Button mBack;
	@FXML
	Button mSave;
	@FXML
	Button mUndo;
	@FXML
	TextField mName;
	@FXML
	ComboBox<String> mSide;
	@FXML
	TextField mWeight;
	@FXML
	TextField mHeight;

	Controller mController = Controller.getInstance();
	Rower mActiveRower = mController.getActiveRower();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		undo();
	}

	@FXML
	Object save() {
		mActiveRower.setName(mName.getText());
		mActiveRower.setSide(mSide.getSelectionModel().getSelectedItem().toString());
		mActiveRower.setWeight(Double.parseDouble(mWeight.toString()));
		mActiveRower.setInches(Integer.parseInt(mHeight.toString()));
		return this;
	}

	@FXML
	Object undo() {
		mName.setText(mActiveRower.getName());
		mSide.getSelectionModel().select(mActiveRower.getSide());
		mWeight.setText(Double.toString(mActiveRower.getWeight()));
		mHeight.setText(Integer.toString(mActiveRower.getInches()));
		return this;
	}

	@FXML
	Object back() {
		ViewSwitch.loadScene("Rowers", ViewSwitch.VIEW_ROWERS);
		return this;
	}
}
