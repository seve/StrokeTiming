package com.sevebadajoz.stroketiming.model;

import java.util.ArrayList;

public class Lineup {

	int mID;
	Coxswain mCoxswain;
	Rower mStrokeSeat;
	Rower mSeatTwo;
	Rower mSeatThree;
	Rower mSeatFour;
	Rower mSeatFive;
	Rower mSeatSix;
	Rower mSeatSeven;
	Rower mBowSeat;

	public Lineup(int ID, Coxswain coxswain, Rower strokeSeat, Rower seatTwo, Rower seatThree, Rower seatFour, Rower seatFive, Rower seatSix, Rower seatSeven, Rower bowSeat) {
		mID = ID;
		mCoxswain = coxswain;
		mStrokeSeat = strokeSeat;
		mSeatTwo = seatTwo;
		mSeatThree = seatThree;
		mSeatFour = seatFour;
		mSeatFive = seatFive;
		mSeatSix = seatSix;
		mSeatSeven = seatSeven;
		mBowSeat = bowSeat;
	}

	public int getID() {
		return mID;
	}

	public void setID(int ID) {
		mID = ID;
	}



	public String toString() {
		return "";
	}
}