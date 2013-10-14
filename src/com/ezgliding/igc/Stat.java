package com.ezgliding.igc;

public class Stat {

	private int time;

	private int altitude;

	private double distance;

	private int heading;

	public Stat() { }

	public Stat(int time, int altitude, double distance, int heading) { 
		this.time = time;
		this.altitude = altitude;
		this.distance = distance;
		this.heading = heading;
	}

	public int getTime() { return time; }
	
	public void setTime(int time) { this.time = time; }

	public int getAltitude() { return altitude; }

	public void setAltitude(int altitude) { this.altitude = altitude; }

	public double getDistance() { return distance; }

	public void setDistance(double distance) { this.distance = distance; }

	public int getHeading() { return heading; }

	public void setHeading(int heading) { this.heading = heading; }

	public float getVario() { return (float)altitude / time; }

	public float getNetVario() { return -1; } // TODO:

	public double getAirSpeed() { return distance / time; }

	@Override
	public Stat clone() {
		return new Stat(time, altitude, distance, heading);
	}

	@Override
	public String toString() {
		return "{" + getTime() + "," + getAltitude() + "," + getVario()
			 + "," + getNetVario() + "," + getAirSpeed() + "," + getDistance() + "}";
	}
}
