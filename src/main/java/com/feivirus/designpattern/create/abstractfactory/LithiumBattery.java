package com.feivirus.designpattern.create.abstractfactory;

/**
 * 锂电池
 * @author feivirus
 *
 */
public class LithiumBattery extends Battery{

	@Override
	public String getName() {
		return "I am 锂电池,剩余电量 " + this.batteryPower;
	}
	
}
