package com.feivirus.designpattern.create.abstractfactory;

import com.feivirus.designpattern.domain.BMWCar;
import com.feivirus.designpattern.domain.Battery;
import com.feivirus.designpattern.domain.Car;
import com.feivirus.designpattern.domain.LithiumBattery;

public class BMWCarAbstractFactory extends CarAbstractFactory{

	@Override
	public Car createCar() {
		return new BMWCar();
	}

	@Override
	public Battery createBattery() {
		return new LithiumBattery();
	}
	
}
