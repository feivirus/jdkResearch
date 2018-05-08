package com.feivirus.designpattern.create.abstractfactory;

import com.feivirus.designpattern.domain.Battery;
import com.feivirus.designpattern.domain.Car;

public abstract class CarAbstractFactory {
	public abstract Car createCar();
	
	public abstract Battery createBattery();
}
