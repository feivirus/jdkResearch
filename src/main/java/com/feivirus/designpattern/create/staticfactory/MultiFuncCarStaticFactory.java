package com.feivirus.designpattern.create.staticfactory;

import java.util.concurrent.Executors;

import com.feivirus.designpattern.domain.BMWCar;
import com.feivirus.designpattern.domain.BenzCar;
import com.feivirus.designpattern.domain.Car;

/**
 * 
 * @author feivirus
 * 
 */
public class MultiFuncCarStaticFactory {
	//Executor线程池使用这种方式
	private Executors executors;
	
	public static Car createBMW() {
		return new BMWCar();
	}
	
	public static Car createBenzCar() {
		return new BenzCar();
	}
}
