package com.feivirus.designpattern.create.normalfactory;

import com.feivirus.designpattern.domain.Car;

/**
 * 把静态工厂模式中的工厂拆分成两层,抽象工厂层 + 具体的工厂子类层
 * 缺点:
 * 1.每次增加一个产品都要同时增加一个工厂类，不如多方法工厂模式方便
 * @author feivirus
 *
 */
public class NormalFactory {
	public static void main(String[] args) {
		CarNormalFactory carAbstractFactory = new BMWCarNormalFactory();
		Car bmwCar = carAbstractFactory.createCar();
		
		System.out.println(bmwCar.getName());		
	}
}
