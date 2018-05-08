package com.feivirus.designpattern.domain;

/**
 * 硫酸/铅酸电池
 * @author feivirus
 *
 */
public class AcidBattery extends Battery{

	@Override
	public String getPower() {
		return "酸类电池电量 " + this.batteryPower;
	}
	
}
