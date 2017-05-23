package com.sevebadajoz.stroketiming.model;

import java.text.DecimalFormat;

public abstract class Piece {
    protected double mSeconds;
    protected int mMeters;

    public Piece(double seconds, int meters) {
        mSeconds = seconds;
        mMeters = meters;
    }

    public Piece(String time, int meters) {
        mSeconds = stringToSeconds(time);
        mMeters = meters;
    }

    public static String secondsToString(double seconds) {
        DecimalFormat twoDP = new DecimalFormat("0.#");
        String ret = Integer.toString((int) seconds / 60);
        ret += ":";

        ret += twoDP.format(seconds % 60);
        return ret;
    }

    public static double stringToSeconds(String str) {
        str = str.trim();
        double seconds, minutes;
        seconds = Double.parseDouble(str.substring(str.indexOf(":") + 1));
        seconds += Double.parseDouble(str.substring(0, str.indexOf(":"))) * 60;
        return seconds;
    }

    public double getSeconds() {
        return mSeconds;
    }

    public void setSeconds(double seconds) {
        mSeconds = seconds;
    }

    public int getMeters() {
        return mMeters;
    }

    public void setMeters(int meters) {
        mMeters = meters;
    }

    public String getSplit() {
        double splitSeconds = mSeconds / 4;
        return secondsToString(splitSeconds);
    }
}
