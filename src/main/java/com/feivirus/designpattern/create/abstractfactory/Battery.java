package com.feivirus.designpattern.create.abstractfactory;

public abstract class Battery extends AbstractProduct{
	protected Double batteryPower = 0d;

	@Override
	public abstract String getName();	
	
}
