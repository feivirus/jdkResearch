package com.feivirus.designpattern.create.staticfactory;

import com.feivirus.designpattern.domain.BMWCar;
import com.feivirus.designpattern.domain.Car;

public class CarStaticFacory {
    public static Car createCar(String carType) {
        Car car = null;
        
        if (carType.equals("bmw")) {
            car = new BMWCar();
        }
        return car;
    }
}
