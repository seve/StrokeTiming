package com.sevebadajoz.stroketiming.controller;

public class Controller {
	private static Controller ourInstance = new Controller();

	public static Controller getInstance() {
		return ourInstance;
	}

	private Controller() {
	}
}
