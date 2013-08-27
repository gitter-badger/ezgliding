package com.ezgliding.igc;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Candidate implements Comparable<Candidate> {
	
	ArrayList<RectangleSet> rectangles;

	boolean isFinal;

	public Candidate() {
		this(null);
	}

	public Candidate(ArrayList<RectangleSet> inputRectangles) {
		this.rectangles = new ArrayList<RectangleSet>();

		isFinal = true;
		if (inputRectangles != null)
			this.rectangles.addAll(inputRectangles);
	}

	public double max() { //TODO: this should take the chosen point into account
		double max = 0.0;
		for (int i=0; i<rectangles.size()-1; i++)
			max += rectangles.get(i).maxDistance(rectangles.get(i+1));
		return max;
	}

	public double min() { //TODO: this should take the chosen point into account
		double min = 0;
		for (int i=0; i<rectangles.size()-1; i++)
			min += rectangles.get(i).minDistance(rectangles.get(i+1));
		return min;
	}

	public boolean isFinal() {
		return isFinal;			
	}

	public List<RectangleSet> getRectangles() {
		return rectangles;
	}

	public void add(RectangleSet rSet) {
		if (rSet == null) return;
		rectangles.add(rSet);
	}

	@Override
	public int compareTo(Candidate other) {
		double diff = max() - other.max();
		if (diff == 0) return 0;
		else if (diff > 0) return 1;
		return -1;
	}

	@Override
	public boolean equals(Object other) {
		if (compareTo((Candidate)other) == 0) return true;
		return false;
	}

	@Override
	public Candidate clone() {
		return new Candidate(this.rectangles);
	}

	@Override
	public String toString() { 
		return rectangles.size() + "";
	}
}

