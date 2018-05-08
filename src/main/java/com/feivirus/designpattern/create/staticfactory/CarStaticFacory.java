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
    
    /**
     * 调用的都是无参的构造方法，不好，为了工厂而工厂.
     * @param classObj
     * @return
     */
    public static <T extends Car>T createCar(Class<T> classObj) {
    	T result = null;
    	try {
			result = (T)Class.forName(classObj.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
}
