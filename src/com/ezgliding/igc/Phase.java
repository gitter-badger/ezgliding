package com.ezgliding.igc;

public class Phase {

	public enum Type {
		MOTOR(0), THERMAL(1), STRAIGHT(2);

		int value;

		Type(int value) { this.value = value; }

		public int value() { return value; }
	}

	private int start;

	private int end;

	private Type type;

	private Stat stats;

	public Phase() { }

	public Phase(int start, int end, Type type, Stat stats) {
		this.start = start;
		this.end = end;
		this.type = type;
		this.stats = stats;
	}

	public int getStart() { return start; }

	public void setStart(int start) { this.start = start; }

	public int getEnd() { return end; }

	public void setEnd(int end) { this.end = end; }

	public Type getType() { return type; }

	public void setType(Type type) { this.type = type; }

	public Stat getStats() { return stats; }

}
