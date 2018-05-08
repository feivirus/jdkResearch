package com.feivirus.designpattern.domain;

/**
 * 锂电池
 * @author feivirus
 *
 */
public class LithiumBattery extends Battery{

	@Override
	public String getPower() {
		return "I am 锂电池,剩余电量 " + this.batteryPower;
	}
	
}
