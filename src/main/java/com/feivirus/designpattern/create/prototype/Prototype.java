package com.feivirus.designpattern.create.prototype;

/**
 * 
 * @author feivirus
 * 参考链接:
 * http://www.cnblogs.com/java-my-life/archive/2012/04/11/2439387.html
 * 优点
 * 1. 方便拷贝
 * 2. 默认的object类的clone方法是浅拷贝.只拷贝基本类型，引用类型不拷贝
 * 缺点
 * 1. 每个类都要加一个clone方法.
 * 2. 含有循环结构或者不支持序列化的对象进行深拷贝，实现原型的深拷贝比较麻烦
 */
public class Prototype {
	public static void main(String[] args) {
		ComputerAbstractPrototype mac = new MacComputer();
		ComputerAbstractPrototype windows = new WindowsComputer();
		
		ComputerAbstractPrototype macCopy = (ComputerAbstractPrototype)mac.clone();
		
		System.out.println(mac.getKeyboard());
		System.out.println(macCopy.getKeyboard());
		
		MacComputerWithoutClone macWithoutClone = new MacComputerWithoutClone();
		//下面代码编译不过
		//MacComputerWithoutClone macWithoutCloneCopy = macWithoutClone.clone();
		System.out.println(macWithoutClone.getKeyboard());
		
	}
}
