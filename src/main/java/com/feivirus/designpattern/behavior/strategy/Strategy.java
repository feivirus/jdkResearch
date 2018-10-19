package com.feivirus.designpattern.behavior.strategy;

/**
 * 策略模式
 * @author feivirus
 * 针对一组算法，将每一个算法封装到具有共同接口的独立的具体算法类中.
 * 多个具体类实现一个共同接口,相同行为的不同实现,lambda表达式的本质
 */
public class Strategy {
	public static void main(String[] args) {
		MemberStrategy strategy = new AdvanceMemberStrategy();
		Goods goods = new Goods(strategy);
		double price = goods.quote(500);
		System.out.println("商品折扣后价格 " + price);
	}
}
