package com.feivirus.designpattern.structure.decorator;

/**
 * 装饰器模式
 * @author feivirus
 * 场景：
 * 1.像在墙上刷油漆，动态给对象，比如汉堡添加职责。比直接生成汉堡的子类更灵活。
 *     汉堡可以是一个抽象类，或者接口。
 *  2.继承和装饰模式的对比：如果用继承实现原来功能的扩展，如果拓展功能多，会生成很多子类，增加系统复杂性。
 *     而且继承是编译时确定的，静态的，必须编码阶段预见拓展这些功能
 */
public class Decorator {
	public static void main(String[] args) {
		Hamburger hamburger = new ChickenBurger();
		System.out.println(hamburger.getName() +" "+ hamburger.getPrice());
		
		EggCondiment eggCondiment = new EggCondiment(hamburger);
		System.out.println(eggCondiment.getName() +" "+ eggCondiment.getPrice());

		ChilliCondiment chilliCondiment = new ChilliCondiment(hamburger);
		System.out.println(chilliCondiment.getName() +" "+ chilliCondiment.getPrice());
		
		ChilliCondiment chilliEggCondiment = new ChilliCondiment(eggCondiment);
		System.out.println(chilliEggCondiment.getName() +" "+ chilliEggCondiment.getPrice());
	}
}
