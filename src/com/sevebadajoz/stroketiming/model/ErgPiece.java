package com.sevebadajoz.stroketiming.model;

import java.text.DecimalFormat;

public class ErgPiece extends Piece {
    private double mWeight;
	private double mWeightFactor;

	public ErgPiece(double seconds, int meters) {
		super(seconds, meters);
	}

	public ErgPiece(String time, int meters) {
		super(time, meters);
	}

	public ErgPiece(double seconds, int meters, double weight) {
        super(seconds, meters);
        mWeight = weight;
		mWeightFactor = Math.pow((mWeight / 270), .222);
	}

	public ErgPiece(String time, int meters, double weight) {
        super(time, meters);
        mWeight = weight;
		mWeightFactor = Math.pow((mWeight / 270), .222);
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

	public double getWeightAdjustedSeconds() {
		return  mWeightFactor * mSeconds;
	}

    public int getWeightAdjustedDistance() {
		return (int)(mMeters / mWeightFactor + .5);
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

	public double getWeight() {
		return mWeight;
	}

	public void setWeight(double weight) {
		mWeight = weight;
	}

	public double getWeightFactor() {
		return mWeightFactor;
	}

	public void setWeightFactor(double weightFactor) {
		mWeightFactor = weightFactor;
	}

	public String getSplit() {
        double splitSeconds = mSeconds / (mMeters / 500);
        return secondsToString(splitSeconds);
	}

	public String toString() {
		return "Time: " + secondsToString(mSeconds) + ", Distance: " + mMeters + " meters";
	}
}