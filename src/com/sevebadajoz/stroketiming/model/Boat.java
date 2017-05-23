package com.sevebadajoz.stroketiming.model;

import com.sevebadajoz.stroketiming.controller.Controller;

public class Boat {
    protected String mName;
    protected int mSeats;
    protected int mWeight;
    protected String mMake;

    public Boat(String name, int seats, String make) {
        mName = name;
        mSeats = seats;
        mMake = make;
    }

    public Boat(String name, int seats, int weight, String make) {
        this(name, seats, make);
        mMake = make;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getSeats() {
        return mSeats;
    }

    public void setSeats(int seats) {
        mSeats = seats;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        mWeight = weight;
    }

    public String getMake() {
        return mMake;
    }

    public void setMake(String make) {
        mMake = make;
    }

    public String toString() {
        return Controller.getInstance().capitalizeString(mName);
    }
}
