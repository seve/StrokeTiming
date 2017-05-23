package com.sevebadajoz.stroketiming.model;

public class Rower extends Athlete {
    protected ErgPiece mErgPiece;
    protected int mInches;

    public Rower(String name, double weight, ErgPiece ergPiece, int inches) {
        super(name, weight);
        mErgPiece = ergPiece;
        mInches = inches;
    }

    public ErgPiece getErgPiece() {
        return mErgPiece;
    }

    public void setErgPiece(ErgPiece ergPiece) {
        mErgPiece = ergPiece;
    }

    public int getInches() {
        return mInches;
    }

    public void setInches(int inches) {
        mInches = inches;
    }
}