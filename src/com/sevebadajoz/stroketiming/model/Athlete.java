package com.sevebadajoz.stroketiming.model;

import com.sevebadajoz.stroketiming.controller.Controller;

import java.text.DecimalFormat;

public class Athlete {
	protected String mName;
	protected double mWeight;
	protected final int mID;

	protected Athlete(int ID, String name, double weight) {
		mID = ID;
		mName = name;
		mWeight = weight;
	}
	public int getID() {return mID;}
	public double getWeight() {
		return mWeight;
	}
	public void setWeight(double weight) {
		mWeight = weight;
	}
	public String getName() {
		return Controller.getInstance().capitalizeString(mName);
	}

	public void setName(String name) {
		mName = name;
	}

    public String toString() {
        DecimalFormat oneDP = new DecimalFormat("#.0");
        return Controller.getInstance().capitalizeString(mName) + ", Weight: " + oneDP.format(mWeight);
    }
}
