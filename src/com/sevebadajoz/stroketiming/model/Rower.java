package com.sevebadajoz.stroketiming.model;

public class Rower extends Athlete {
    //protected ErgPiece mErgPiece;
    protected int mInches;

    public Rower(int ID, String name, double weight, int inches) {
        super(ID, name, weight);
        //mErgPiece = ergPiece;
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
}