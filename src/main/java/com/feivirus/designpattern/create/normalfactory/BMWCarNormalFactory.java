package com.feivirus.designpattern.create.normalfactory;

import com.feivirus.designpattern.create.normalfactory.BMWCar;
import com.feivirus.designpattern.create.normalfactory.Car;

public class BMWCarNormalFactory extends CarNormalFactory{

	@Override
	public Car createCar() {		
		return new BMWCar();
	}
	
}
