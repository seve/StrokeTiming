package com.sevebadajoz.stroketiming.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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

	public static String secondsToString(double seconds) {
		DecimalFormat twoDP = new DecimalFormat("0.#");
		String ret = Integer.toString((int)seconds / 60);
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
	public String getSplit() {
		double splitSeconds = mSeconds / 4;
		return secondsToString(splitSeconds);
	}

}
