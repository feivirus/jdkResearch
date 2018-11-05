package com.feivirus.lambda.reason;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import lombok.Data;

@Data
public class Apple {
	private String color;
	
	private Integer weight;
	
	private final static Integer STANDARD_APPLE_WEIGHT = 150;
	
	/**
	 * before java 8
	 * 如果需要选出重量大于150的苹果，需要改下面的if判断，重新写方法。
	 * @param inventory
	 * @return
	 */
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<Apple>();
		
		for(Apple apple : inventory) {
			if (Color.GREEN.getName().equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static boolean isGreenApple(Apple apple) {
		return Color.GREEN.getName().equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > STANDARD_APPLE_WEIGHT;
	}
	
	public interface Predicate<T> {
		boolean test(T t);
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<Apple>();
		
		for(Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * after java 8
	 * 基于lambda表达式
	 */
	public void testPredicate() {
		List<Apple> inventory = new ArrayList<Apple>();
		
		filterApples(inventory, Apple::isGreenApple);
		filterApples(inventory, Apple::isHeavyApple);
		
		//lambda简写,匿名函数
		filterApples(inventory, (Apple a) -> Color.GREEN.getName().equals(a.getColor()));
		filterApples(inventory, (Apple a) -> a.getWeight() < STANDARD_APPLE_WEIGHT || 
				Color.GREEN.getName().equals(a.getColor()));
		
		//调用lambda库
		//filter(inventory, (Apple a) -> a.getWeight() > STANDARD_APPLE_WEIGHT);
	}
	
	/**
	 * 使用stream， stream侧重于计算. lambda侧重于筛选过滤
	 */
	public void testStream() {
		List<Apple> inventory = new ArrayList<Apple>();
		
		List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > STANDARD_APPLE_WEIGHT)
				.collect(toList());
	}
	
}
