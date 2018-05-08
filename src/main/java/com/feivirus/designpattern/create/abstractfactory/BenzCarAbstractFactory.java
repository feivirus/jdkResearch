package com.feivirus.designpattern.create.abstractfactory;

import com.feivirus.designpattern.domain.AcidBattery;
import com.feivirus.designpattern.domain.Battery;
import com.feivirus.designpattern.domain.BenzCar;
import com.feivirus.designpattern.domain.Car;

public class BenzCarAbstractFactory extends CarAbstractFactory{

	@Override
	public Car createCar() {
		return new BenzCar();
	}

	@Override
	public Battery createBattery() {
		return new AcidBattery();
	}
	
}
