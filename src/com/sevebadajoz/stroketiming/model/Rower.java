package com.sevebadajoz.stroketiming.model;

public class Rower extends Athlete {
    protected ErgPiece mErgPiece;
    protected int mInches;
    protected String mSide;

    public Rower(int ID, String name, double weight, ErgPiece ergPiece, int inches, String side) {
        super(ID, name, weight);
        mErgPiece = ergPiece;
        mInches = inches;
        mSide = side;
    }

    public Rower(int ID, String name, double weight, int inches, String side) {
        super(ID, name, weight);
        mInches = inches;
        mSide = side;
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
