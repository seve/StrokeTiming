package com.sevebadajoz.stroketiming.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static com.sevebadajoz.stroketiming.model.ErgScore.secondsToString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ErgScoreTest {
	ErgScore myScore;
	ErgScore weightScore;
	@BeforeEach
	void setUp() {
		myScore = new ErgScore("6:48.7", 2000);
		weightScore = new ErgScore("6:48.7", 2000, 170.5);
	}

	@AfterEach
	void tearDown() {

	}

	@Test
	void getWeightAdjustedSeconds() {
		DecimalFormat twoDP = new DecimalFormat("#.0");
		double seconds = weightScore.getWeightAdjustedSeconds();
		String formatSeconds = twoDP.format(seconds);
//		System.out.println("Before format: " + seconds + ", after format: " + formatSeconds);
		assertEquals("369.0", formatSeconds);
	}

	@Test
	void getWeightAdjustedDistance() {
		assertEquals(2215, weightScore.getWeightAdjustedDistance());
	}

	@Test
	void secondsToString() {
		System.out.println("Seconds: " + myScore.getSeconds());
		System.out.println("String: " + ErgScore.secondsToString(myScore.getSeconds()));
		assertEquals("6:48.7", ErgScore.secondsToString(myScore.getSeconds()));
	}

	@Test
	void stringToSeconds() {
		assertEquals(408.7, ErgScore.stringToSeconds("6:48.7"));
	}

}