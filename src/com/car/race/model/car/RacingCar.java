package com.car.race.model.car;

public class RacingCar extends Car {
	private boolean isNitroUsed;
	private int teamNumber;
	private int timeTaken;
	public RacingCar(float topSpeed, float acceleration, float handelingFactor, int teamNumber, float currentDistanceCovered) {	
		this.topSpeed = (18/5)*topSpeed;	// convert to m/sec
		this.acceleration = acceleration;	// in m/sec^2
		this.handelingFactor = handelingFactor;
		this.teamNumber = teamNumber;
		this.currentDistanceCovered = currentDistanceCovered;
	}
	public boolean isNitroUsed() {
		return isNitroUsed;
	}
	public void setNitroUsed(boolean isNitroUsed) {
		this.isNitroUsed = isNitroUsed;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public int getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}
}
