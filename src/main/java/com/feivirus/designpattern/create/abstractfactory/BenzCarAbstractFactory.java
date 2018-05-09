package com.feivirus.designpattern.create.abstractfactory;

import com.feivirus.designpattern.create.abstractfactory.AbstractProduct;
import com.feivirus.designpattern.create.abstractfactory.AcidBattery;
import com.feivirus.designpattern.create.abstractfactory.Battery;
import com.feivirus.designpattern.create.abstractfactory.BenzCar;
import com.feivirus.designpattern.create.abstractfactory.Car;

public class BenzCarAbstractFactory extends CarAbstractFactory{

	@Override
	public AbstractProduct createCar() {
		return new BenzCar();
	}

	@Override
	public AbstractProduct createBattery() {
		return new AcidBattery();
	}
	
}
