package com.feivirus.designpattern.behavior.strategy;

public class PrimaryMemberStrategy implements MemberStrategy{

	public double calcPrice(double goodsPrice) {
		System.out.println("初级会员没有折扣");
		return goodsPrice;
	}

}
