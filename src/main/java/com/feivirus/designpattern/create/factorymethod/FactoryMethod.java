package com.feivirus.designpattern.create.factorymethod;

/**
 * 工厂方法是每个工厂生产相同的产品。抽象工厂是每个工厂生产不同的产品
 * 把静态工厂模式中的工厂拆分成两层,抽象工厂层 + 具体的工厂子类层.工厂方法和抽象工厂模式是把工厂拆分出两层
 * @author feivirus
 * 优点
 * 1.新增产品只需要新增具体的产品类和具体工厂类
 * 缺点
 * 1.每次新增产品需要新增两个类，一个产品类，一个工厂类
 * 2.一个工厂只能创建一个产品
 */
public class FactoryMethod {
	public static void main(String[] args) {
		VideoFactory videoFactory = new MovieFactory();
		Video video = videoFactory.createVideo();
		System.out.println(video.play());
		
		videoFactory = new AnimationFactory();
		video = videoFactory.createVideo();
		System.out.println(video.play());
	}
}
