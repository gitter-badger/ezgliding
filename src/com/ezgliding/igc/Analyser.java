package com.ezgliding.igc;

import java.util.ArrayList;

public class Analyser {

	private Flight flight;

	private ArrayList<Phase> phases;

	public Analyser(Flight flight) {
		this.flight = flight;
		this.phases = new ArrayList<Phase>();
	}

	public int getGlidingStart() { return 0; }

	public int getGlidingEnd() { return flight.fixes().size() - 1; }

	public ArrayList<Phase> getPhases() { return phases; }

	protected void update(Phase phase, Fix fix) {

	}

	protected Stat getStat(Fix fix1, Fix fix2) {
		return null; //TODO:
	}

	protected void analyse() {

	}
}
