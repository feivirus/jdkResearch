package com.feivirus.designpattern.structure.decorator;

/**
 * 调料装饰类，不断的往汉堡上加调料，加装饰，要继承汉堡类，方便引用汉堡本身的方法
 * @author feivirus
 *
 */
public abstract class AbstractCondimentDecorator implements Hamburger {
	private Hamburger hamburger;

	public AbstractCondimentDecorator(Hamburger hamburger) {
		this.hamburger = hamburger;
	}
	
	public String getName() {
		return hamburger.getName();
	}

	public double getPrice() {
		return hamburger.getPrice();
	}
}
