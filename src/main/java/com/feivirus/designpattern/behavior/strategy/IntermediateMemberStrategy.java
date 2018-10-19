package com.feivirus.designpattern.behavior.strategy;

public class IntermediateMemberStrategy implements MemberStrategy{
	public final static double INTERMEDIATE_MEMBER_DISCOUNT = 0.9;

	public double calcPrice(double goodsPrice) {
		double result = goodsPrice * INTERMEDIATE_MEMBER_DISCOUNT;
		System.out.println("中级会员打八折: " + result);
		return result;
	}

}
