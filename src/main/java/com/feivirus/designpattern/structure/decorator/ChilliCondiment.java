package com.feivirus.designpattern.structure.decorator;

public class ChilliCondiment extends AbstractCondimentDecorator{
	
	public ChilliCondiment(Hamburger hamburger) {
		super(hamburger);
	}

	@Override
	public String getName() {
		return super.getName() + " 加辣椒";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 1.0;
	}
	
}
