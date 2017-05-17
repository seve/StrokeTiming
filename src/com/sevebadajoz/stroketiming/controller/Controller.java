package com.sevebadajoz.stroketiming.controller;

public class Controller {
	private static Controller ourInstance = new Controller();

	private Controller() {
	}

	public static Controller getInstance()
	{
		return ourInstance;
	}
}
