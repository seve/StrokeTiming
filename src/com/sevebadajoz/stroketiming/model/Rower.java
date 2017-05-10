package com.sevebadajoz.stroketiming.model;

public class Rower extends Athlete {
	ErgScore mErgScore;
	int mPosition;
	protected Rower(String name, double weight, ErgScore ergScore) {
		super(name, weight);
		mErgScore = ergScore;
	}
}