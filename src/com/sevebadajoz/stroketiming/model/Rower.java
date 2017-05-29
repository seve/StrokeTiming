package com.sevebadajoz.stroketiming.model;

public class Rower extends Athlete {
    protected ErgPiece mErgPiece;
    protected int mInches;
    protected String mSide;

    public Rower(int ID, String name, double weight, ErgPiece ergPiece, int inches) {
        super(ID, name, weight);
        mErgPiece = ergPiece;
        mInches = inches;
    }

    public Rower(int ID, String name, double weight, int inches) {
        super(ID, name, weight);
        mInches = inches;
    }

    public ErgPiece getErgPiece() {
        return mErgPiece;
    }

    public void setErgPiece(ErgPiece ergPiece) {
        mErgPiece = ergPiece;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public int getInches() {
        return mInches;
    }

    public void setInches(int inches) {
        mInches = inches;
    }

    public String getSide() {
        return mSide;
    }

    public void setSide(String side) {
        mSide = side;
    }
}
