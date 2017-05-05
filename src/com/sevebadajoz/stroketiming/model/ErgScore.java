package com.sevebadajoz.stroketiming.model;

public class ErgScore {
	private double mSeconds;
	private int mMeters;
	private double mWeight;
	private double mWeightFactor;

	public ErgScore(double seconds, int meters) {
		mSeconds = seconds;
		mMeters = meters;
	}
	public ErgScore(double seconds, int meters, double weight) {
		this(seconds, meters);
		mWeight = weight;
		mWeightFactor = Math.pow((mWeight / 270), .222);
	}
	public ErgScore(String time, int meters) {
		mSeconds = stringToSeconds(time);
		mMeters = meters;
	}
	public ErgScore(String time, int meters, double weight) {
		mSeconds = stringToSeconds(time);
		mMeters = meters;
		mWeight = weight;
		mWeightFactor = Math.pow((mWeight / 270), .222);
	}
	public double getWeightAdjustedSeconds() {
		return  mWeightFactor * mSeconds;
	}
	public int getWeightAdjustedDistance() {
		return (int)(mMeters / mWeightFactor + .5);
	}
	public String secondsToString() {
		String ret = Integer.toString((int)mSeconds / 60);
		ret += ":";
		ret += Integer.toString((int)mSeconds % 60);
		return ret;
	}
	public int stringToSeconds(String str) {
		str = str.trim();
		int seconds, minutes;
		seconds = Integer.parseInt(str.substring(str.indexOf(":")), 10);
		seconds += Integer.parseInt(str.substring(0, str.indexOf(":")), 10) * 60;
		return seconds;
	}


}
