package com.car.race.client;

import java.util.ArrayList;
import java.util.List;

import com.car.race.exceptions.RaceException;
import com.car.race.factory.CarFactory;
import com.car.race.factory.DriverFactory;
import com.car.race.model.car.Car;
import com.car.race.model.driver.FormulaOneDriver;
import com.car.race.util.RaceUtil;

public class Race {

	private List<FormulaOneDriver> formulaOneDrivers;
	private int numberOfTeams;
	private int lengthOfTrackInKM;
	private List<FormulaOneDriver> raceFinishingFormulaOneDrivers;

	public static void main(String[] args) throws Exception {
		Race race = new Race();
		race.validateInput(args);
		race.prepareRaceInfra();
		race.startRace();
		System.out.println("RACE FINISH");
		race.displayResults(race.raceFinishingFormulaOneDrivers);
	}

	private void startRace() throws InterruptedException {
		while(!formulaOneDrivers.isEmpty()) {
			RaceUtil.calculateDistances(formulaOneDrivers);
			RaceUtil.gatherRaceFinishers(formulaOneDrivers, raceFinishingFormulaOneDrivers, lengthOfTrackInKM);
			if(formulaOneDrivers.isEmpty()) return;
			RaceUtil.calculateSpeeds(formulaOneDrivers);
			Thread.sleep(2000);
		}
	}

	private void prepareRaceInfra() {
		formulaOneDrivers = new ArrayList<>();
		for(int i = 1; i <= numberOfTeams; i++){
			Car car = CarFactory.createRacingCar(numberOfTeams, i, lengthOfTrackInKM);
			FormulaOneDriver formulaOneDriver = DriverFactory.createFormulaOneDriver(car);
			formulaOneDrivers.add(formulaOneDriver);
		}
		raceFinishingFormulaOneDrivers = new ArrayList<>();
	}

	private void validateInput(String[] args) throws Exception {
		if (args.length != 2) {
			throw new RaceException("Usage -- Race <total_number_of_teams> <length_of_track_in_kilo_meters>");
		}
		try {
			numberOfTeams = Integer.parseInt(args[0]);
			if (numberOfTeams > 20 || numberOfTeams < 2) {
				throw new RaceException("Total number of teams cannot be more than 20 or less than 2");
			}
			lengthOfTrackInKM = Integer.parseInt(args[1])*1000;
			if (lengthOfTrackInKM > 100000 || lengthOfTrackInKM < 10000) {
				throw new RaceException("Track length cannot be more than 100 or less than 10");
			}
		} catch (Exception e) {
			throw new RaceException("Please only use digits as input");
		}
	}

	private void displayResults(List<FormulaOneDriver> drivers) {
		int i = 1;
		for(FormulaOneDriver driver : drivers) {
			System.out.println("-------------------------Race Results------------------------");
			System.out.println("Car position : " + i++);
			System.out.println("Car team number : " + driver.getRacingCar().getTeamNumber());
			System.out.println("Car top speed : " + driver.getRacingCar().getTopSpeed());
			System.out.println("Car acceleration : " + driver.getRacingCar().getAcceleration());
			System.out.println("Car current speed : " + driver.getRacingCar().getCurrentSpeed());
			System.out.println("Has car used nitro : " + driver.getRacingCar().isNitroUsed());
		}
		System.out.println("--------------------------------------------------------------");
	}
}
