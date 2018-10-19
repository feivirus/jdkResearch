package com.feivirus.designpattern.behavior.strategy;

public class Goods {
	private MemberStrategy memberStrategy;
	
	public Goods(MemberStrategy memberStrategy) {
		this.memberStrategy = memberStrategy;
	}
	
	public double quote(double oldPrice) {
		return memberStrategy.calcPrice(oldPrice);
	}
}
