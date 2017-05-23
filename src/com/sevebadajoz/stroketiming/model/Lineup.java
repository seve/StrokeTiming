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

    public Coxswain getCoxswain() {
        return mCoxswain;
    }

    public void setCoxswain(Coxswain coxswain) {
        mCoxswain = coxswain;
    }

    public Rower getStrokeSeat() {
        return mStrokeSeat;
    }

    public void setStrokeSeat(Rower strokeSeat) {
        mStrokeSeat = strokeSeat;
    }

    public Rower getSeatTwo() {
        return mSeatTwo;
    }

    public void setSeatTwo(Rower seatTwo) {
        mSeatTwo = seatTwo;
    }

    public Rower getSeatThree() {
        return mSeatThree;
    }

    public void setSeatThree(Rower seatThree) {
        mSeatThree = seatThree;
    }

    public Rower getSeatFour() {
        return mSeatFour;
    }

    public void setSeatFour(Rower seatFour) {
        mSeatFour = seatFour;
    }

    public Rower getSeatFive() {
        return mSeatFive;
    }

    public void setSeatFive(Rower seatFive) {
        mSeatFive = seatFive;
    }

    public Rower getSeatSix() {
        return mSeatSix;
    }

    public void setSeatSix(Rower seatSix) {
        mSeatSix = seatSix;
    }

    public Rower getSeatSeven() {
        return mSeatSeven;
    }

    public void setSeatSeven(Rower seatSeven) {
        mSeatSeven = seatSeven;
    }

    public Rower getBowSeat() {
        return mBowSeat;
    }

    public void setBowSeat(Rower bowSeat) {
        mBowSeat = bowSeat;
    }

    public String toString() {
		return "";
	}
}