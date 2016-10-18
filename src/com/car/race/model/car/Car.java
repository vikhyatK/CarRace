package com.car.race.model.car;

public abstract class Car {

	protected float topSpeed;
	protected float acceleration;
	protected float handelingFactor;
	protected float currentSpeed;
	protected float currentDistanceCovered;

	public float getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(float topSpeed) {
		this.topSpeed = topSpeed;
	}
	public float getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}
	public float getHandelingFactor() {
		return handelingFactor;
	}
	public void setHandelingFactor(float handelingFactor) {
		this.handelingFactor = handelingFactor;
	}
	public float getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(float currentSpeed) {
		if (currentSpeed < topSpeed) {
			this.currentSpeed = currentSpeed;
		} else {
			this.currentSpeed = topSpeed;
		}
	}
	public float getCurrentDistanceCovered() {
		return currentDistanceCovered;
	}
	public void setCurrentDistanceCovered(float currentDistanceCovered) {
		this.currentDistanceCovered = currentDistanceCovered;
	}
	
}
