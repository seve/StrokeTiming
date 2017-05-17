package com.sevebadajoz.stroketiming.controller;

public class Controller {
	private static Controller theOne;

	private static final String DB_NAME = "stroke_timing.db";

	private static final String BOATS_TABLE_NAME = "boats";


	private static final String BOAT_LINEUPS_TABLE_NAME = "boat_lineups";


	private static final String ROWERS_TABLE_NAME = "rowers";


	private static final String COXSWAIN_TABLE_NAME = "coxswains";




	private Controller() {
	}

	public static Controller getInstance()
	{
		return theOne;
	}
}
