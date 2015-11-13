package com.schmonz.trend;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	public static double TOLERANCE = 0.0000000000001;

	public Double computeTrend(Object... list) {
		if (null == list) {
			return null;
		} else if (1 == list.length) {
			return 0.0;
		} else {
			double sum = 0.0;
			List<List<Double>> pairs = generatePairs(list);
			for (List<Double> pair : pairs) {
				sum += computePairValue(pair.get(0), pair.get(1));
			}
			return sum;
		}
	}

	public Double computeTrend() {
		return computeTrend(null);
	}

	public List<List<Double>> generatePairs(Object... list) {
		List<List<Double>> pairs = new ArrayList<List<Double>>();

		Double previousListItem = null;
		for (Object listItem : list) {
			Double currentListItem = forcePossibleIntegerToDouble(listItem);
			if (null != previousListItem) {
				List<Double> thisPair = new ArrayList<Double>();
				thisPair.add(previousListItem);
				thisPair.add(currentListItem);
				pairs.add(thisPair);
			}
			previousListItem = currentListItem;
		}

		return pairs;
	}

	public Double forcePossibleIntegerToDouble(Object possibleInteger) {
		Double definitelyDouble = 0.0;

		if (possibleInteger instanceof Integer) {
			definitelyDouble += (Integer) possibleInteger;
		} else if (possibleInteger instanceof Double) {
			definitelyDouble += (Double) possibleInteger;
		} else {
			throw new NumberFormatException("unknown type");
		}

		return definitelyDouble;
	}

	public double computePairValue(double p1, double p2) {
		if (0 == p1 && p2 > 0) {
			return 1.0;
		} else if (Math.abs(p1 - p2) < TOLERANCE) {
			return 0.0;
		} else {
			return (p2 - p1) / p1;
		}
	}
}