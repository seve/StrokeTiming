package com.sevebadajoz.stroketiming.model;

public class Athlete {
	protected String mName;
	protected double mWeight;

	protected Athlete(String name, double weight) {
		mName = name;
		mWeight = weight;
	}
	double getWeight() {
		return mWeight;
	}
	String getName() {
		return mName;
	}

}
