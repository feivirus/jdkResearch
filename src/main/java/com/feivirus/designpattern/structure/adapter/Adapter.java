package com.feivirus.designpattern.structure.adapter;

/**
 * 
 * @author feivirus
 * 参考链接
 * https://www.ibm.com/developerworks/cn/java/j-lo-adapter-pattern/
 * https://www.cnblogs.com/V1haoge/p/6479118.html
 * 场景:
 * 1.用于解决两个已有的接口不兼容问题，被适配的类是一个黑盒子，常用于现有系统与第三方产品功能集成
 * 2.讲客户类的请求转化为适配者相应接口的调用,别名为wrapper包装器.
 * 3.分为类适配器模式和对象适配器模式.对象适配器是适配器中含有对适配者的对象的引用，如本例子。
 * 类适配器是适配器和适配者(自己的接口或者已有的接口)之间是继承或实现关系.
 * 4.适配器可以做单向或者双向适配器，同时实现适配者和适配目标的两个接口,但使用较少
 * 5.缺省适配器模式中，当不需要实现目标接口的所有方法时，可以设计一个抽象类而不是接口实现目标接口，
 * 对不想实现的接口提供一个空方法作为默认实现。该抽象类的子类选择性的覆盖父类中的某些方法实现需求
 */
public class Adapter {
	public static void main(String[] args) {
		Log fileLog = new Log();		
		LogFileApi logFileApi = new LogFileImpl();
		
		LogDBApi logDBApi = new LogAdapter(logFileApi);
		logDBApi.createLog(fileLog);
		
	}
}
