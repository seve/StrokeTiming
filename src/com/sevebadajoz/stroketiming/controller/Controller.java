package com.sevebadajoz.stroketiming.controller;

import com.sevebadajoz.stroketiming.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
	private static final String DB_NAME = "stroke_timing.db";

	private static final String BOATS_TABLE_NAME = "boats";
	private static final String[] BOATS_FIELD_NAMES = {"id", "name", "seats", "weight", "make"};
	private static final String[] BOATS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "TEXT"};

    private static final String LINEUPS_TABLE_NAME = "lineups";
    private static final String[] LINEUPS_FIELD_NAMES = {"id", "coxswain_id", "stroke_seat_id", "seat_two_id", "seat_three_id",
            "seat_four_id", "seat_five_id", "seat_six_id", "seat_seven_id", "bow_seat_id"};
    private static final String[] LINEUPS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER",
            "INTEGER", "INTEGER", "INTEGER", "INTEGER"};

    private static final String BOATS_TO_LINEUPS_TABLE_NAME = "boats_to_lineups";
    private static final String[] BOATS_TO_LINEUPS_FIELD_NAMES = {"boat_id", "boat_lineup_id"};
    private static final String[] BOATS_TO_LINEUPS_FIELD_TYPES = {"INTEGER", "INTEGER"};

	private static final String ROWERS_TABLE_NAME = "rowers";
	private static final String[] ROWERS_FIELD_NAMES = {"id", "name", "weight", "inches"};
	private static final String[] ROWERS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "REAL", "INTEGER"};

    private static final String ERG_PIECES_TABLE_NAME = "erg_pieces";
    private static final String[] ERG_PIECES_FIELD_NAMES = {"id", "seconds", "meters", "weight"};
    private static final String[] ERG_PIECES_FIELD_TYPES = {"INTEGER PRIMARY KEY", "REAL", "INTEGER", "REAL"};

    private static final String ROWER_ERG_PIECES_TABLE_NAME = "rower_erg_pieces";
    private static final String[] ROWER_ERG_PIECES_FIELD_NAMES = {"rower_id", "erg_piece_id"};
    private static final String[] ROWER_ERG_PIECES_FIELD_TYPES = {"INTEGER", "INTEGER"};

	private static final String COXSWAINS_TABLE_NAME = "coxswains";
	private static final String[] COXSWAINS_FIELD_NAMES = {"id", "name", "weight"};
	private static final String[] COXSWAINS_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "REAL"};

    private static final String PRACTICES_TABLE_NAME = "practices";
    private static final String[] PRACTICES_FIELD_NAMES = {"id", "date", "comments"};
    private static final String[] PRACTICES_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "TEXT"};

    private static final String BOAT_PRACTICES_TABLE_NAME = "boat_practices";
    private static final String[] BOAT_PRACTICES_FIELD_NAMES = {"boat_id", "practice_id"};
    private static final String[] BOAT_PRACTICES_FIELD_TYPES = {"INTEGER", "INTEGER"};

    private static final String PIECES_TABLE_NAME = "pieces";
	private static final String[] PIECES_FIELD_NAMES = {"id", "type", "meters", "time", "comments"};
	private static final String[] PIECES_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "REAL", "TEXT"};

    private static final String PRACTICE_TO_PIECES_TABLE_NAME = "practice_to_pieces";
    private static final String[] PRACTICE_TO_PIECES_FIELD_NAMES = {"practice_id", "pieces_id"};
    private static final String[] PRACTICE_TO_PIECES_FIELD_TYPES = {"INTEGER", "INTEGER"};

    private static Controller theOne;

    private static Lineup mActiveLineup;

    private DBModel mBoatsTable;
    private DBModel mLineupsTable;
    private DBModel mBoatsToBoatLineupsTable;
    private DBModel mRowersTable;
    private DBModel mErgPiecesTable;
    private DBModel mRowerErgPiecesTable;
    private DBModel mCoxswainsTable;
    private DBModel mPracticesTable;
    private DBModel mBoatPracticeTable;
    private DBModel mPiecesTable;
    private DBModel mPracticeToPiecesTable;

    private ObservableList<Lineup> mLineups;
    private ObservableList<Boat> mBoats;
    private ObservableList<Coxswain> mCoxswains;
    private ObservableList<Rower> mRowers;
    private ObservableList<Practice> mPractices;
    private ObservableList<Piece> mPieces;

    private Controller() {
    }

    public static Controller getInstance() {
        if (theOne == null) {

            theOne = new Controller();

            theOne.mLineups = FXCollections.observableArrayList();
            theOne.mBoats = FXCollections.observableArrayList();
            theOne.mCoxswains = FXCollections.observableArrayList();
            theOne.mRowers = FXCollections.observableArrayList();
            theOne.mPractices = FXCollections.observableArrayList();

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


                theOne.mLineupsTable = new DBModel(DB_NAME, LINEUPS_TABLE_NAME, LINEUPS_FIELD_NAMES, LINEUPS_FIELD_TYPES);
                rs = theOne.mLineupsTable.getAllRecords();

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

                    theOne.mLineups.add(new Lineup(ID, getCoxswain(coxswainID), rowers, null, null));
                }

                theOne.mBoatsToBoatLineupsTable = new DBModel(DB_NAME, BOATS_TO_LINEUPS_TABLE_NAME, BOATS_TO_LINEUPS_FIELD_NAMES, BOATS_TO_LINEUPS_FIELD_TYPES);
                theOne.mErgPiecesTable = new DBModel(DB_NAME, ERG_PIECES_TABLE_NAME, ERG_PIECES_FIELD_NAMES, ERG_PIECES_FIELD_TYPES);
                theOne.mRowerErgPiecesTable = new DBModel(DB_NAME, ROWER_ERG_PIECES_TABLE_NAME, ROWER_ERG_PIECES_FIELD_NAMES, ROWER_ERG_PIECES_FIELD_TYPES);
                theOne.mPracticesTable = new DBModel(DB_NAME, PRACTICES_TABLE_NAME, PRACTICES_FIELD_NAMES, PRACTICES_FIELD_TYPES);
                theOne.mBoatPracticeTable = new DBModel(DB_NAME, BOAT_PRACTICES_TABLE_NAME, BOAT_PRACTICES_FIELD_NAMES, BOAT_PRACTICES_FIELD_TYPES);
                theOne.mPiecesTable = new DBModel(DB_NAME, PIECES_TABLE_NAME, PIECES_FIELD_NAMES, PIECES_FIELD_TYPES);
                theOne.mPracticeToPiecesTable = new DBModel(DB_NAME, PRACTICE_TO_PIECES_TABLE_NAME, PRACTICE_TO_PIECES_FIELD_NAMES, PRACTICE_TO_PIECES_FIELD_TYPES);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return theOne;
	}

	public static Boat getBoat(int ID)
    {
        for (Boat b : theOne.mBoats)
        {
            if (b.getID() == ID)
                return b;
        }

        return null;
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

    public static Coxswain getCoxswain(int ID)
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

    public boolean addNewLineup(Rower[] rowers, Coxswain coxswain, Boat boat) {
        String[] values = new String[LINEUPS_FIELD_NAMES.length - 1];
        values[0] = Integer.toString(coxswain.getID());
        for (int i = 1; i < values.length; i++) {
            values[i] = Integer.toString(rowers[i].getID());
        }
        try {
            mLineupsTable.createRecord(Arrays.copyOfRange(LINEUPS_FIELD_NAMES, 1, LINEUPS_FIELD_NAMES.length), values);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addNewBoat(String name, int seats, int weight, String make) {
        String[] values = new String[BOATS_FIELD_NAMES.length - 1];
        values[0] = name;
        values[1] = Integer.toString(seats);
        values[2] = Integer.toString(weight);
        values[3] = make;
        try {
            mBoatsTable.createRecord(Arrays.copyOfRange(BOATS_FIELD_NAMES, 1, BOATS_FIELD_NAMES.length), values);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addNewCoxswain(String name, Double weight) {
        String[] values = new String[COXSWAINS_FIELD_NAMES.length - 1];
        values[0] = name;
        values[1] = weight.toString();
        try {
            mCoxswainsTable.createRecord(Arrays.copyOfRange(COXSWAINS_FIELD_NAMES, 1, COXSWAINS_FIELD_NAMES.length), values);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addNewRower(String name, double weight, int inches) {
        String[] values = new String[ROWERS_FIELD_NAMES.length - 1];
        values[0] = name;
        values[1] = Double.toString(weight);
        values[2] = Integer.toString(inches);
        try {
            mRowersTable.createRecord(Arrays.copyOfRange(ROWERS_FIELD_NAMES, 1, ROWERS_FIELD_NAMES.length), values);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Lineup getActiveLineup() {
        return mActiveLineup;
    }

    public void setActiveLineup(Lineup mActiveLineup) {
        Controller.mActiveLineup = mActiveLineup;
    }

    public ObservableList<Lineup> getLineups() {
        return theOne.mLineups;
    }

    public ObservableList<Boat> getBoats() {
        try {
            for (ArrayList<String> strings : mBoatsTable.getAllRecords()) {
                mBoats.add(new Boat(Integer.parseInt(strings.get(0)), strings.get(1), Integer.parseInt(strings.get(2)), Integer.parseInt(strings.get(3)), strings.get(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theOne.mBoats;
    }

    public ObservableList<Coxswain> getCoxswains() {
        return theOne.mCoxswains;
    }

    public ObservableList<Rower> getRowers() {
        return theOne.mRowers;
    }

    public ObservableList<Practice> getPractices() {
        theOne.mPractices.setAll(theOne.getActiveLineup().getPractices());
        return theOne.mPractices;
    }

    public ObservableList<Piece> getPieces() {
        return mPieces;
    }

    public void setPieces(ObservableList<Piece> pieces) {
        mPieces = pieces;
    }
}