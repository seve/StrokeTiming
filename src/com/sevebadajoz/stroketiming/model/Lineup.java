package com.sevebadajoz.stroketiming.model;

import java.util.ArrayList;

public class Lineup {
	final int mID;
	final Rower[] mRowers;
	final Coxswain mCoxswain;
	final Boat mBoat;
	ArrayList<Practice> mPractices;

	public Lineup(int ID, Coxswain coxswain, Rower[] rowers, ArrayList<Practice> practices, Boat boat) {
		mID = ID;
		mRowers = rowers;
		mCoxswain = coxswain;
		mPractices = practices;
		mBoat = boat;
	}

	public Rower[] getRowers() {
		return mRowers;
	}

	public Coxswain getCoxswain() {
		return mCoxswain;
	}

	public ArrayList<Practice> getPractices() {
		return mPractices;
	}

	public void setPractices(ArrayList<Practice> practices) {
		mPractices = practices;
	}

	public Boat getBoat() {
		return mBoat;
	}

    public int getID() {
        return mID;
    }

	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append(mBoat).append(", Stroke: ").append(mRowers[0].getName());
		for (int i = 1; i < mRowers.length; i++) {
			ret.append(", ").append(mRowers[i].getName());
		}
		return ret.toString();
	}
}
