package com.sevebadajoz.stroketiming.model;

public class Athlete {
	private String mName;
	private double mWeight;

	public Athlete(String name, double weight) {
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
