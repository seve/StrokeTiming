package com.sevebadajoz.stroketiming.controller;

public class Controller {
	private static Controller mOne = null;

	private static final String DB_NAME = "geedorah";


	private Controller() {}
	private Controller getInstance() {
		if(mOne == null) {

		}
		return mOne;
	}


}
