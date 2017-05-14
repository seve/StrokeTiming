package com.sevebadajoz.stroketiming.model;

public class Rower extends Athlete {
    protected ErgScore mErgScore;
    protected int mInches;

    public Rower(String name, double weight, ErgScore ergScore, int inches) {
        super(name, weight);
        mErgScore = ergScore;
        mInches = inches;
    }

    public ErgScore getErgScore() {
        return mErgScore;
    }

    public void setErgScore(ErgScore ergScore) {
        mErgScore = ergScore;
    }

    public int getInches() {
        return mInches;
    }

    public void setInches(int inches) {
        mInches = inches;
    }
}