package com.feivirus.designpattern.create.abstractfactory;

import com.feivirus.designpattern.create.abstractfactory.AbstractProduct;
import com.feivirus.designpattern.create.abstractfactory.BMWCar;
import com.feivirus.designpattern.create.abstractfactory.Battery;
import com.feivirus.designpattern.create.abstractfactory.Car;
import com.feivirus.designpattern.create.abstractfactory.LithiumBattery;

public class BMWCarAbstractFactory extends CarAbstractFactory{

	@Override
	public AbstractProduct createCar() {
		return new BMWCar();
	}

	@Override
	public AbstractProduct createBattery() {
		return new LithiumBattery();
	}
	
}
