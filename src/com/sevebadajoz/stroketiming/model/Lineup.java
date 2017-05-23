package com.sevebadajoz.stroketiming.model;

import java.util.ArrayList;

public class Lineup {

	int mID;
	Coxswain mCoxswain;
	Rower[] mRowers;

	public Lineup(int ID, Coxswain coxswain, Rower[] rowers) {
		mID = ID;
		mCoxswain = coxswain;
		mRowers = rowers;
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

    public String toString() {
		return "";
	}
}