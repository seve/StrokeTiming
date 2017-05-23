package com.sevebadajoz.stroketiming.model;

import java.util.ArrayList;

public class Lineup {

	//"id", "coxswain_id", "stroke_seat_id", "seat_two_id", "seat_three_id",
	//		"seat_four_id", "seat_five_id", "seat_six_id", "seat_seven_id", "bow_seat_id"

	int mID;
	int mCoxswainID;
	int mStrokeSeatID;
	int mSeatTwoID;
	int mSeatThreeID;
	int mSeatFourID;
	int mSeatFiveID;
	int mSeatSixID;
	int mSeatSevenID;
	int mBowSeatID;

	public Lineup(int ID, int coxswainID, int strokeSeatID, int seatTwoID, int seatThreeID, int seatFourID, int seatFiveID, int seatSixID, int seatSevenID, int bowSeatID) {
		mID = ID;
		mCoxswainID = coxswainID;
		mStrokeSeatID = strokeSeatID;
		mSeatTwoID = seatTwoID;
		mSeatThreeID = seatThreeID;
		mSeatFourID = seatFourID;
		mSeatFiveID = seatFiveID;
		mSeatSixID = seatSixID;
		mSeatSevenID = seatSevenID;
		mBowSeatID = bowSeatID;
	}

	public int getID() {
		return mID;
	}

	public void setID(int ID) {
		mID = ID;
	}

	public int getStrokeSeatID() {
		return mStrokeSeatID;
	}

	public void setStrokeSeatID(int strokeSeatID) {
		mStrokeSeatID = strokeSeatID;
	}

	public int getSeatTwoID() {
		return mSeatTwoID;
	}

	public void setSeatTwoID(int seatTwoID) {
		mSeatTwoID = seatTwoID;
	}

	public int getSeatThreeID() {
		return mSeatThreeID;
	}

	public void setSeatThreeID(int seatThreeID) {
		mSeatThreeID = seatThreeID;
	}

	public int getSeatFourID() {
		return mSeatFourID;
	}

	public void setSeatFourID(int seatFourID) {
		mSeatFourID = seatFourID;
	}

	public int getSeatFiveID() {
		return mSeatFiveID;
	}

	public void setSeatFiveID(int seatFiveID) {
		mSeatFiveID = seatFiveID;
	}

	public int getSeatSixID() {
		return mSeatSixID;
	}

	public void setSeatSixID(int seatSixID) {
		mSeatSixID = seatSixID;
	}

	public int getSeatSevenID() {
		return mSeatSevenID;
	}

	public void setSeatSevenID(int seatSevenID) {
		mSeatSevenID = seatSevenID;
	}

	public int getBowSeatID() {
		return mBowSeatID;
	}

	public void setBowSeatID(int bowSeatID) {
		mBowSeatID = bowSeatID;
	}

	public String toString() {
		return "";
	}
}