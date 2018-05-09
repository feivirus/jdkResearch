package com.feivirus.designpattern.create.abstractfactory;

import com.feivirus.designpattern.create.abstractfactory.AbstractProduct;
import com.feivirus.designpattern.create.abstractfactory.Battery;
import com.feivirus.designpattern.create.abstractfactory.Car;

public abstract class CarAbstractFactory {
	public abstract AbstractProduct createCar();
	
	public abstract AbstractProduct createBattery();
}
