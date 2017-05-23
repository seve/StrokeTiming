package com.sevebadajoz.stroketiming.model;

public class Rower extends Athlete {
    //protected ErgPiece mErgPiece;
    protected int mInches;
    protected String mSide;
    private int mID;


    public Rower(int iD, String name, double weight, int inches) {
        super(iD, name, weight);
        mInches = inches;
    }

    //public ErgPiece getErgPiece() {
    //    return mErgPiece;
    //}

    //public void setErgPiece(ErgPiece ergPiece) {
    //   mErgPiece = ergPiece;
    //}

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
