package com.feivirus.designpattern.create.normalfactory;

import com.feivirus.designpattern.domain.BMWCar;
import com.feivirus.designpattern.domain.Car;

public class BMWCarNormalFactory extends CarNormalFactory{

	@Override
	public Car createCar() {		
		return new BMWCar();
	}
	
}
