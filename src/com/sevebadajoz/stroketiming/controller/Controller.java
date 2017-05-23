package com.sevebadajoz.stroketiming.controller;

import com.sevebadajoz.stroketiming.model.Boat;
import com.sevebadajoz.stroketiming.model.Coxswain;
import com.sevebadajoz.stroketiming.model.Lineup;
import com.sevebadajoz.stroketiming.model.Rower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
	private static final String DB_NAME = "stroke_timing.db";

	private static final String BOATS_TABLE_NAME = "boats";
	private static final String[] BOATS_FIELD_NAMES = {"id", "name", "type", "weight", "seats"};
	private static final String[] BOATS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "TEXT", "REAL", "INTEGER"};

	private static final String BOAT_LINEUPS_TABLE_NAME = "boat_lineups";
	private static final String[] BOAT_LINEUPS_FIELD_NAMES = {"id", "coxswain_id", "stroke_seat_id", "seat_two_id", "seat_three_id",
			"seat_four_id", "seat_five_id", "seat_six_id", "seat_seven_id", "bow_seat_id"};
	private static final String[] BOAT_LINEUPS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER",
			"INTEGER", "INTEGER", "INTEGER", "INTEGER"};

	private static final String BOATS_TO_BOAT_LINEUPS_TABLE_NAME = "boats_to_boat_lineups";
	private static final String[] BOATS_TO_BOAT_LINEUPS_FIELD_NAMES = {"boat_id", "boat_lineup_id"};
	private static final String[] BOATS_TO_BOAT_LINEUPS_FIELD_TYPES = {"INTEGER", "INTEGER"};

	private static final String ROWERS_TABLE_NAME = "rowers";
	private static final String[] ROWERS_FIELD_NAMES = {"id", "name", "position", "weight"};
	private static final String[] ROWERS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "REAL"};

	private static final String ERG_SCORES_TABLE_NAME = "erg_scores";
	private static final String[] ERG_SCORES_FIELD_NAMES = {"id", "seconds", "meters", "weight"};
	private static final String[] ERG_SCORES_FIELD_TYPES = {"INTEGER PRIMARY KEY", "REAL", "INTEGER", "REAL"};

	private static final String ROWER_ERG_SCORES_TABLE_NAME = "rower_erg_scores";
	private static final String[] ROWER_ERG_SCORES_FIELD_NAMES = {"rower_id", "erg_score_id"};
	private static final String[] ROWER_ERG_SCORES_FIELD_TYPES = {"INTEGER", "INTEGER"};

	private static final String COXSWAINS_TABLE_NAME = "coxswains";
	private static final String[] COXSWAINS_FIELD_NAMES = {"id", "name", "weight"};
	private static final String[] COXSWAINS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "REAL"};

    private static final String WORKOUTS_TABLE_NAME = "workouts";
	private static final String[] WORKOUTS_FIELD_NAMES = {"id", "date", "comments"};
	private static final String[] WORKOUTS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "TEXT"};

	private static final String BOAT_WORKOUTS_TABLE_NAME = "boat_workouts";
	private static final String[] BOAT_WORKOUTS_FIELD_NAMES = {"boat_id", "workout_id"};
	private static final String[] BOAT_WORKOUTS_FIELD_TYPES = {"INTEGER", "INTEGER"};

    private static final String PIECES_TABLE_NAME = "pieces";
	private static final String[] PIECES_FIELD_NAMES = {"id", "type", "meters", "time", "comments"};
	private static final String[] PIECES_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "REAL", "TEXT"};

	private static final String WORKOUT_TO_PIECES_TABLE_NAME = "workout_to_pieces";
	private static final String[] WORKOUT_TO_PIECES_FIELD_NAMES = {"workout_id", "pieces_id"};
	private static final String[] WORKOUT_TO_PIECES_FIELD_TYPES = {"INTEGER", "INTEGER"};

    private static Controller theOne;

    private ObservableList<Lineup> mLineups;
    private ObservableList<Boat> mBoats;
    private ObservableList<Coxswain> mCoxswains;
    private ObservableList<Rower> mRowers;

	private Controller() { }

    public static Controller getInstance() {
        if (theOne == null) {
            theOne = new Controller();
            theOne.mLineups = FXCollections.observableArrayList();
            theOne.mBoats = FXCollections.observableArrayList();
            theOne.mCoxswains = FXCollections.observableArrayList();
            theOne.mRowers = FXCollections.observableArrayList();
        }
        return theOne;
	}

    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }

    public ObservableList<Lineup> getLineups() {
        return mLineups;
    }

    public ObservableList<Boat> getBoats() {
        return mBoats;
    }

    public ObservableList<Coxswain> getCoxswains() {
        return mCoxswains;
    }

    public ObservableList<Rower> getRowers() {
        return mRowers;
    }
}