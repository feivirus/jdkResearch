package com.feivirus.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
 * 5.lambda其实类似c++的函数指针
 * 6.具体使用步骤参考Lambda.lambdaSteps()方法
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
	 * 测试用例
	 * {@link com.feivirus.lambda.LambdaTest.testConstructAppleWithIntegerList()}
	 * @param valueList
	 * @param funcApple
	 * @return
	 */
	public List<Apple> constructAppleWithIntegerList(List<Integer> valueList, 
			Function<Integer, Apple> funcApple) {
		List<Apple> result = new ArrayList<>();
		
		for(Integer e : valueList) {
			Apple apple = funcApple.apply(e);
			result.add(apple);
		}
		return result;
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
		
		//谓词复合
		Predicate<Apple> predicate = (Apple a) -> a.getColor().equals("red");
		predicate.or((Apple a) -> a.getWeight() > 100);
		predicate.and((Apple a) -> a.getColor().equals("blue"));
		
		//函数复合
		Function<Integer, Integer> adder = (Integer i) -> i + 1;
		Function<Integer, Integer> multiplier = (Integer i) -> i * 2;
		Function<Integer, Integer> result1 = adder.andThen(multiplier);
		Function<Integer, Integer> result2 = adder.compose(multiplier);
		System.out.println(result1.apply(1));
		System.out.println(result2.apply(1));
		
		
		execute(() -> {});	
		
		int port = 187;
		
		Runnable runnable = () -> {System.out.println(port);};
		
		//lambda方法引用
		List<Apple> inventory = Arrays.asList(new Apple("green", 100));
		inventory.sort(Comparator.comparing(Apple::getWeight));
		inventory.sort(Comparator.comparing((Apple a) -> a.getWeight()));
		
		List<String> strList = Arrays.asList("1", "2", "3");
		strList.sort((String s1, String s2) -> s1.compareToIgnoreCase(s2));
		strList.sort(String::compareToIgnoreCase);
		
		Function<String, Integer> intParseFunc = Integer::parseInt; 
		
		//通过lambda 调用构造函数
		//!!!这地方居然编译过了，而且运行正常, Supplier的接口应该是参数为空，返回对象的
		Supplier<Apple> supplierApple = () -> new Apple("red", 100);
		Apple a1 = supplierApple.get();
		System.out.println(a1.getColor());
		
		Supplier<Apple> supplierApple2 = Apple::new;
		Apple a2 = supplierApple2.get();
		
		Function<Integer, Apple> functionApple1 = (Integer i) -> new Apple(i);
		Apple a3 = functionApple1.apply(20);
		
		Function<Integer, Apple> functionApple2 = Apple::new;
		Apple a4 = functionApple2.apply(30);
	}
	
	/**
	 * 构造lambda的步骤
	 * 前提知道有个void sort(Comparator<? super E> c) 接口
	 */
	public void lambdaSteps() {
		List<Apple> inventory = new ArrayList<>();
		
		//1.传递实现类
		inventory.sort(new AppleComparator());
		
		//2.使用匿名类
		inventory.sort(new Comparator<Apple> () {

			@Override
			public int compare(Apple o1, Apple o2) {				
				return o1.getWeight().compareTo(o2.getWeight());
			}			
		});
		
		//3.使用lambda表达式
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		inventory.sort(Comparator.comparing((a1) -> a1.getWeight()));
		
		//4.使用方法引用
		inventory.sort(Comparator.comparing(Apple::getWeight));
	}
	
	public static class AppleComparator implements Comparator<Apple> {
		@Override
		public int compare(Apple o1, Apple o2) {			
			return o1.getWeight().compareTo(o2.getWeight());
		}		
	}
	
}
