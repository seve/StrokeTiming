package com.sevebadajoz.stroketiming.controller;

import com.sevebadajoz.stroketiming.model.Lineup;
import javafx.collections.ObservableList;

public class Controller {
	private static final String DB_NAME = "stroke_timing.db";
	private static final String BOATS_TABLE_NAME = "boats";
	private static final String BOAT_LINEUPS_TABLE_NAME = "boat_lineups";
	private static final String ROWERS_TABLE_NAME = "rowers";
	private static final String COXSWAINS_TABLE_NAME = "coxswains";
    private static final String ERG_SCORES_TABLE_NAME = "erg_scores";
    private static final String WORKOUTS_TABLE_NAME = "workouts";
    private static final String PIECES_TABLE_NAME = "pieces";
    private static Controller theOne;
    private ObservableList<Lineup> mLineups;

	private Controller() {
	}

	public static Controller getInstance()
	{
		return theOne;
	}

    public ObservableList<Lineup> getLineups() {
        return mLineups;
    }
}