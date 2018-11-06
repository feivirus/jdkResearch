package com.feivirus.lambda;

import java.util.concurrent.Callable;
import com.feivirus.lambda.reason.Apple;
import com.feivirus.lambda.reason.Apple.ApplePredicate;

/**
 * 函数式编程,lambda表达式
 * @author feivirus
 * 
 * 1.lambda的产生原因见 {@link com.feivirus.lambda.reason.Apple} 类
 * 2.lambda的匿名方法->匿名类->自动产生策略模式的接口实现类
 *  {@link com.feivirus.lambda.reason.AppleTest.testFilterApples()}
 * 3.函数式接口:只定义一个抽象方法的接口,即便有很多默认方法.这个抽象方法的签名称为函数描述符.
 * 4.常用lambda的函数式接口库参考{@link com.feivirus.lambda.LambdaLib}
 */
public class Lambda {
	
	/**
	 * 函数式接口
	 * 测试用例
	 * 
	 */
	public void functionalInterface() {
		Runnable r1 = () -> System.out.println("Hello World r1");
		
		Runnable r2 = new Runnable() {
			public void run() {
				System.out.println("Hello World r2");
			}
		};
		
		process(r1);
		process(r2);
		process(() -> System.out.println("Hello World anonymous function"));
		
	}
	
	public static void process(Runnable r) {
		r.run();
	}
	
	@FunctionalInterface
	public interface IStringLength {
		int length(String s);
	}
	
	@FunctionalInterface
	public interface Adder {
		void add(int x, int y);
	}
	
	public void execute(Runnable r) {
		r.run();
	}
	
	public Callable<String> fetch() {
		return () -> "Tricky example;-)";
	}
	
	/**
	 * lambda例子
	 */
	public void lambdaSample() {
		IStringLength iStringLength = (String s) -> s.length();
		
		Adder iAdd = (int x, int y) -> {
			System.out.println("result: ");
			System.out.println(x + y);
		};
		iAdd.add(1, 2);
		
		ApplePredicate applePredicate = (Apple a) -> a.getWeight() > 150;
		
		execute(() -> {});		
	}
	
}
