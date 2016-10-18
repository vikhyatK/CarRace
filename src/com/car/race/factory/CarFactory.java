package com.car.race.factory;

import com.car.race.model.car.Car;
import com.car.race.model.car.RacingCar;

public class CarFactory {
	public static Car createRacingCar(int totalCars, int teamNumber, int lengthOfTrack){
		return new RacingCar(150 + (10 * teamNumber), 2 * teamNumber, 0.8f, teamNumber, lengthOfTrack*1000 + (200 * (totalCars - teamNumber)));
	}
}
