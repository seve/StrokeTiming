package com.sevebadajoz.stroketiming.controller;

import com.sevebadajoz.stroketiming.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
	private static final String DB_NAME = "stroke_timing.db";

	private static final String BOATS_TABLE_NAME = "boats";
	private static final String[] BOATS_FIELD_NAMES = {"id", "name", "seats", "weight", "make"};
	private static final String[] BOATS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "TEXT"};

	private static final String BOAT_LINEUPS_TABLE_NAME = "boat_lineups";
	private static final String[] BOAT_LINEUPS_FIELD_NAMES = {"id", "coxswain_id", "stroke_seat_id", "seat_two_id", "seat_three_id",
			"seat_four_id", "seat_five_id", "seat_six_id", "seat_seven_id", "bow_seat_id"};
	private static final String[] BOAT_LINEUPS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER",
			"INTEGER", "INTEGER", "INTEGER", "INTEGER"};

	private static final String BOATS_TO_BOAT_LINEUPS_TABLE_NAME = "boats_to_boat_lineups";
	private static final String[] BOATS_TO_BOAT_LINEUPS_FIELD_NAMES = {"boat_id", "boat_lineup_id"};
	private static final String[] BOATS_TO_BOAT_LINEUPS_FIELD_TYPES = {"INTEGER", "INTEGER"};

	private static final String ROWERS_TABLE_NAME = "rowers";
	private static final String[] ROWERS_FIELD_NAMES = {"id", "name", "weight", "inches"};
	private static final String[] ROWERS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "REAL", "INTEGER"};

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
    private static Lineup mActiveLineup;
    private DBModel mBoatsTable;
    private DBModel mBoatLineupsTable;
    private DBModel mBoatsToBoatLineupsTable;
    private DBModel mRowersTable;
    private DBModel mErgScoresTable;
    private DBModel mRowerErgScoresTable;
    private DBModel mCoxswainsTable;
    private DBModel mWorkoutsTable;
    private DBModel mBoatWorkoutTable;
    private DBModel mPiecesTable;
    private DBModel mWorkoutToPiecesTable;
    private ObservableList<Lineup> mLineups;
    private ObservableList<Boat> mBoats;
    private ObservableList<Coxswain> mCoxswains;
    private ObservableList<Rower> mRowers;

    private Controller() {
    }

    public static Controller getInstance() {
        if (theOne == null) {

            theOne = new Controller();

            theOne.mLineups = FXCollections.observableArrayList();
            theOne.mBoats = FXCollections.observableArrayList();
            theOne.mCoxswains = FXCollections.observableArrayList();
            theOne.mRowers = FXCollections.observableArrayList();

            try {
                theOne.mBoatsTable = new DBModel(DB_NAME, BOATS_TABLE_NAME, BOATS_FIELD_NAMES, BOATS_FIELD_TYPES);
                ArrayList<ArrayList<String>> rs = theOne.mBoatsTable.getAllRecords();

                for (ArrayList<String> values : rs)
                {
                    int ID = Integer.parseInt(values.get(0));
                    String name = values.get(1);
                    int seats = Integer.parseInt(values.get(2));
                    int weight = Integer.parseInt(values.get(3));
                    String make = values.get(4);

                    theOne.mBoats.add(new Boat(ID, name, seats, weight, make));
                }


                theOne.mRowersTable = new DBModel(DB_NAME, ROWERS_TABLE_NAME, ROWERS_FIELD_NAMES, ROWERS_FIELD_TYPES);
                rs = theOne.mRowersTable.getAllRecords();

                for (ArrayList<String> values : rs)
                {
                    int ID = Integer.parseInt(values.get(0));
                    String name = values.get(1);
                    double weight = Double.parseDouble(values.get(2));
                    int inches = Integer.parseInt(values.get(3));

                    theOne.mRowers.add(new Rower(ID, name, weight, inches));
                }


                theOne.mCoxswainsTable = new DBModel(DB_NAME, COXSWAINS_TABLE_NAME, COXSWAINS_FIELD_NAMES, COXSWAINS_FIELD_TYPES);
                rs = theOne.mCoxswainsTable.getAllRecords();

                for (ArrayList<String> values : rs)
                {
                    int ID = Integer.parseInt(values.get(0));
                    String name = values.get(1);
                    double weight = Double.parseDouble(values.get(2));

                    theOne.mCoxswains.add(new Coxswain(ID, name, weight));
                }


                theOne.mBoatLineupsTable = new DBModel(DB_NAME, BOAT_LINEUPS_TABLE_NAME, BOAT_LINEUPS_FIELD_NAMES, BOAT_LINEUPS_FIELD_TYPES);
                rs = theOne.mBoatLineupsTable.getAllRecords();

                for (ArrayList<String> values : rs)
                {
                    int ID = Integer.parseInt(values.get(0));
                    int coxswainID = Integer.parseInt(values.get(1));
                    int strokeSeat = Integer.parseInt(values.get(2));
                    int seatTwo = Integer.parseInt(values.get(3));
                    int seatThree = Integer.parseInt(values.get(4));
                    int seatFour = Integer.parseInt(values.get(5));
                    int seatFive = Integer.parseInt(values.get(6));
                    int seatSix = Integer.parseInt(values.get(7));
                    int seatSeven = Integer.parseInt(values.get(8));
                    int bowSeat = Integer.parseInt(values.get(9));

                    Rower[] rowers = {getRower(strokeSeat), getRower(seatTwo), getRower(seatThree), getRower(seatFour), getRower(seatFive), getRower(seatSix), getRower(seatSeven), getRower(bowSeat)};

                    theOne.mLineups.add(new Lineup(ID, getCoxwain(coxswainID), rowers));
                }

                theOne.mBoatsToBoatLineupsTable = new DBModel(DB_NAME, BOATS_TO_BOAT_LINEUPS_TABLE_NAME, BOATS_TO_BOAT_LINEUPS_FIELD_NAMES, BOATS_TO_BOAT_LINEUPS_FIELD_TYPES);
                theOne.mErgScoresTable = new DBModel(DB_NAME, ERG_SCORES_TABLE_NAME, ERG_SCORES_FIELD_NAMES, ERG_SCORES_FIELD_TYPES);
                theOne.mRowerErgScoresTable = new DBModel(DB_NAME, ROWER_ERG_SCORES_TABLE_NAME, ROWER_ERG_SCORES_FIELD_NAMES, ROWER_ERG_SCORES_FIELD_TYPES);
                theOne.mWorkoutsTable = new DBModel(DB_NAME, WORKOUTS_TABLE_NAME, WORKOUTS_FIELD_NAMES, WORKOUTS_FIELD_TYPES);
                theOne.mBoatWorkoutTable = new DBModel(DB_NAME, BOAT_WORKOUTS_TABLE_NAME, BOAT_WORKOUTS_FIELD_NAMES, BOAT_WORKOUTS_FIELD_TYPES);
                theOne.mPiecesTable = new DBModel(DB_NAME, PIECES_TABLE_NAME, PIECES_FIELD_NAMES, PIECES_FIELD_TYPES);
                theOne.mWorkoutToPiecesTable = new DBModel(DB_NAME, WORKOUT_TO_PIECES_TABLE_NAME, WORKOUT_TO_PIECES_FIELD_NAMES, WORKOUT_TO_PIECES_FIELD_TYPES);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return theOne;
	}

	public static Rower getRower(int ID)
    {
        for (Rower r : theOne.mRowers)
        {
            if (r.getID() == ID)
                return r;
        }

        return null;
    }

    public static Coxswain getCoxwain(int ID)
    {
        for (Coxswain c : theOne.mCoxswains)
        {
            if (c.getID() == ID)
                return c;
        }

        return null;
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

    public Lineup getActiveLineup() {
        return mActiveLineup;
    }

    public void setmctiveLineup(Lineup mActiveLineup) {
        Controller.mActiveLineup = mActiveLineup;
    }

    public ObservableList<Lineup> getLineups() {
        return theOne.mLineups;
    }

    public ObservableList<Boat> getBoats() {
        return theOne.mBoats;
    }

    public ObservableList<Coxswain> getCoxswains() {
        return theOne.mCoxswains;
    }

    public ObservableList<Rower> getRowers() {
        return theOne.mRowers;
    }
}