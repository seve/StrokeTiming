package com.sevebadajoz.stroketiming.model;

import com.sevebadajoz.stroketiming.controller.Controller;

import java.text.DecimalFormat;

public class Athlete {
	protected int mID;
	protected String mName;
	protected double mWeight;

	protected Athlete(int ID, String name, double weight) {
		mID = ID;
		mName = name;
		mWeight = weight;
	}
	public int getID() {return mID;}
	public double getWeight() {
		return mWeight;
	}
	public String getName() {
		return mName;
	}

    public String toString() {
        DecimalFormat oneDP = new DecimalFormat("#.0");
        return Controller.getInstance().capitalizeString(mName) + ", Weight: " + oneDP.format(mWeight);
    }
}
