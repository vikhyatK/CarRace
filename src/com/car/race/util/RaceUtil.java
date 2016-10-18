package com.car.race.util;

import java.util.Collections;
import java.util.List;

import com.car.race.model.car.RacingCar;
import com.car.race.model.driver.FormulaOneDriver;

public class RaceUtil {

	public static void sortCarsOnPosition(List<FormulaOneDriver> drivers) {
		Collections.sort(drivers, (a, b) -> Math
				.round((a.getRacingCar().getCurrentDistanceCovered() - b.getRacingCar().getCurrentDistanceCovered())));
	}

	public static void calculateDistances(List<FormulaOneDriver> formulaOneDrivers) {
		for (FormulaOneDriver formulaOneDriver : formulaOneDrivers) {
			// s = ut + (1/2) at^2
			RacingCar car = formulaOneDriver.getRacingCar();
			car.setCurrentDistanceCovered(car.getCurrentDistanceCovered() + (car.getCurrentSpeed()
					* Constants.ASSESSMENT_INTERVAL
					+ (car.getAcceleration() * Constants.ASSESSMENT_INTERVAL * Constants.ASSESSMENT_INTERVAL) / 2));
			formulaOneDriver.setRacingCar(car);
		}
		sortCarsOnPosition(formulaOneDrivers);
	}

	public static void calculateSpeeds(List<FormulaOneDriver> formulaOneDrivers) {
		//accelerate
		for (FormulaOneDriver formulaOneDriver : formulaOneDrivers) {
			formulaOneDriver.accelerate();
		}
		//decelerate
		for (int i = 0; i < formulaOneDrivers.size() - 1; i++) {
			float vicinity = Math.abs(formulaOneDrivers.get(i + 1).getRacingCar().getCurrentDistanceCovered()
					- formulaOneDrivers.get(i + 1).getRacingCar().getCurrentDistanceCovered());
			if (vicinity < 10.0) {
				formulaOneDrivers.get(i).decelerate();
			}
		}
		//useNitro
		if(!formulaOneDrivers.get(0).getRacingCar().isNitroUsed()) {
			formulaOneDrivers.get(0).useNitro();
		}
	}
	
	public static void gatherRaceFinishers(List<FormulaOneDriver> formulaOneDrivers,
			List<FormulaOneDriver> raceFinishingFormulaOneDrivers, int lengthOfTrackInKM) {
		for(int i = 0; i < formulaOneDrivers.size(); i++) {
			FormulaOneDriver formulaOneDriver = formulaOneDrivers.get(i);
			if(formulaOneDriver.getRacingCar().getCurrentDistanceCovered() >= lengthOfTrackInKM) {
				raceFinishingFormulaOneDrivers.add(formulaOneDriver);
				formulaOneDrivers.remove(i);
			}
		}
	}
}
