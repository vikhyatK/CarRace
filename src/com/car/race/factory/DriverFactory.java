package com.car.race.factory;

import com.car.race.model.car.Car;
import com.car.race.model.car.RacingCar;
import com.car.race.model.driver.FormulaOneDriver;

public class DriverFactory {

	public static FormulaOneDriver createFormulaOneDriver(Car car){
		return new FormulaOneDriver((RacingCar)car);
	}
}
