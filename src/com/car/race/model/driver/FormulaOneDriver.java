package com.car.race.model.driver;

import java.util.Iterator;
import java.util.List;

import com.car.race.model.car.RacingCar;
import com.car.race.util.Constants;

public class FormulaOneDriver implements IDrive {

	private RacingCar car;

	public FormulaOneDriver(RacingCar car2) {
		this.car = car2;
	}

	@Override
	public void accelerate() {
		float newSpeed = car.getCurrentSpeed() + (car.getAcceleration() * Constants.ASSESSMENT_INTERVAL);
		car.setCurrentSpeed(newSpeed);
	}

	@Override
	public void decelerate() {
		this.car.setCurrentSpeed(car.getCurrentSpeed() * car.getHandelingFactor());
	}

	@Override
	public void useNitro() {
		car.setNitroUsed(true);
		car.setCurrentSpeed(car.getCurrentSpeed() * 2 > car.getTopSpeed() ? car.getTopSpeed() : car.getCurrentSpeed() * 2);
	}

	public RacingCar getRacingCar() {
		return this.car;
	}

	public void setRacingCar(RacingCar car) {
		this.car = car;
	}
}
