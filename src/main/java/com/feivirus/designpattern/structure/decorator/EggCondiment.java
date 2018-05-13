package com.feivirus.designpattern.structure.decorator;

/**
 * 汉堡里面的鸡蛋配料
 * @author feivirus
 *
 */
public class EggCondiment extends AbstractCondimentDecorator {
		
	public EggCondiment(Hamburger hamburger) {
		super(hamburger);
	}

	@Override
	public String getName() {
		return super.getName() + " 加鸡蛋";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 1.0;
	}
	
}
