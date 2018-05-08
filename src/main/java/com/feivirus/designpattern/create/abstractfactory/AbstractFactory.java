package com.feivirus.designpattern.create.abstractfactory;

import com.feivirus.designpattern.domain.Battery;
import com.feivirus.designpattern.domain.Car;

/**
 * 假设奔驰盛产硫酸电池，宝马盛产锂电池
 * @author feivirus
 *
 */
public class AbstractFactory {
	public static void main(String[] args) {		
		CarAbstractFactory carAbstractFactory = new BenzCarAbstractFactory();
		Car car = carAbstractFactory.createCar();
		System.out.println(car.getName());
		Battery battery = carAbstractFactory.createBattery();
		System.out.println(battery.getPower());
		
		carAbstractFactory = new BMWCarAbstractFactory();
		car = carAbstractFactory.createCar();
		System.out.println(car.getName());
		battery = carAbstractFactory.createBattery();
		System.out.println(battery.getPower());
	}
}
