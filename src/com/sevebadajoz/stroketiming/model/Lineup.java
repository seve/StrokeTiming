package com.sevebadajoz.stroketiming.model;

import java.util.ArrayList;

public class Lineup {
	Rower[] mRowers;
	Coxswain mCoxswain;
	ArrayList<Practice> mPractices;
	Boat mBoat;

	public Lineup(Rower[] rowers, Coxswain coxswain, Boat boat) {
		mRowers = rowers;
		mCoxswain = coxswain;
		mBoat = boat;
	}

	public Lineup(Rower[] rowers, Coxswain coxswain, ArrayList<Practice> practices, Boat boat) {
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

	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append(mBoat).append(", Stroke: ").append(mRowers[0]);
		for (int i = 1; i < mRowers.length; i++) {
			ret.append(", ").append(mRowers[i]);
		}
		return ret.toString();
	}
}
