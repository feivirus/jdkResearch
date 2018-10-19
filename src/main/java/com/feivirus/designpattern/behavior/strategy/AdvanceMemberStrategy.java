package com.feivirus.designpattern.behavior.strategy;

public class AdvanceMemberStrategy implements MemberStrategy{
	public final static double ADVANCE_MEMBER_DISCOUNT = 0.8;

	public double calcPrice(double goodsPrice) {
		double result = goodsPrice * 0.8;
		System.out.println("高级会员折扣: " + result);
		return result;
	}

}
