package com.feivirus.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author feivirus
 *
 */
public class LambdaLib {
	/**
	 * 1.predicate filter
	 * 一个参数，返回布尔值
	 */
	public void testPredicate() {
		Predicate<String> p = (String s) -> !s.isEmpty();
		List<String> stringList = Arrays.asList("1", "2", "3");
		List<String> result = filter(stringList, p);
		
		//jdk 的filter方法
		List<String> result2 = stringList.stream().filter(p)
				.collect(Collectors.toList());
		
		//基本类型的装箱/拆箱操作
		//无自动装箱操作
		IntPredicate evenNumbers = (int i) -> i % 2 == 0;
		System.out.println(evenNumbers.test(19));
	}
	
	public static <T> List<T> filter(List<T> inventory, Predicate<T> obj) {
		List<T> result = new ArrayList<>();
		
		for(T t : inventory) {
			if (obj.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	/**
	 * 2.consumer accept
	 *  一个参数，无返回值
	 */
	public void testConsumer() {
		List<Integer> intList = Arrays.asList(1, 2, 3);
		
		intList.stream().forEach((Integer i) -> System.out.println(i));
	}
	
	/**
	 * 3.function apply
	 * 从一个对象中选择/提取
	 *
	 * 一个参数，一个返回值
	 */
	public void testFunction() {
		List<String> strList = Arrays.asList("lambda", "in", "action");
		List<Integer> result = strList.stream().map((String s) -> s.length())
				.collect(Collectors.toList());
		System.out.println(result);
	}
	
	/**
	 * 4.supplier get
	 * 创建对象
	 * 无参数，一个返回值.不能抛异常.Callable可以抛异常.
	 */
	public void testSupplier() {
		
	}
	
	/**
	 * 5.unaryOperator identity
	 * 合并两个值
	 * 继承自Function,一个参数，一个返回值，参数和返回值的类型相同.
	 */
	public void testUnaryOperator() {
		
	}
	
	/**
	 * 6.callable call
	 * 无参，一个返回值,可以抛出一个异常.Supplier不能抛异常
	 */
	public void testCallable() {
		
	}
	
	/**
	 * 7. Comparator 
	 * 比较两个对象
	 * 一个参数，返回bool值
	 */
	public void testComparator() {
		
	}
}
