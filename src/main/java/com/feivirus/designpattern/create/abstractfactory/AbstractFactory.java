package com.feivirus.designpattern.create.abstractfactory;

import com.feivirus.designpattern.create.abstractfactory.AbstractProduct;
import com.feivirus.designpattern.create.abstractfactory.Battery;
import com.feivirus.designpattern.create.abstractfactory.Car;

/**
 * 假设奔驰盛产硫酸电池，宝马盛产锂电池
 * @author feivirus
 * 优点:
 * 1.把具体产品的创建延迟到具体子类工厂中。
 * 缺点:
 * 1.如果需要添加新产品，需要修改抽象工厂CarAbstractFactory，添加新产品创建方法，此时
 * 需要修改左右子类，违背了开发-封闭原则
 */
public class AbstractFactory {
	public static void main(String[] args) {		
		CarAbstractFactory carAbstractFactory = new BenzCarAbstractFactory();
		AbstractProduct car = carAbstractFactory.createCar();
		System.out.println(car.getName());
		AbstractProduct battery = carAbstractFactory.createBattery();
		System.out.println(battery.getName());
		
		carAbstractFactory = new BMWCarAbstractFactory();
		car = carAbstractFactory.createCar();
		System.out.println(car.getName());
		battery = carAbstractFactory.createBattery();
		System.out.println(battery.getName());
	}
}
