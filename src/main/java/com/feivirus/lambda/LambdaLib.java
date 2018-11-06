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
	 * 布尔表达式
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
	 *  消费一个对象
	 */
	public void testConsumer() {
		List<Integer> intList = Arrays.asList(1, 2, 3);
		
		intList.stream().forEach((Integer i) -> System.out.println(i));
	}
	
	/**
	 * 3.function apply
	 * 从一个对象中选择/提取
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
	 */
	public void testSupplier() {
		
	}
	
	/**
	 * 5.unaryOperator identity
	 * 合并两个值
	 */
	public void testUnaryOperator() {
		
	}
	
	/**
	 * 6.callable call
	 */
	public void testCallable() {
		
	}
	
	/**
	 * 7. Comparator 
	 * 比较两个对象
	 */
	public void testComparator() {
		
	}
}
