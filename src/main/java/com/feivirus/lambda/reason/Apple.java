package com.feivirus.lambda.reason;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import lombok.Data;

@Data
public class Apple {
	private String color;
	
	private Integer weight;
	
	public final static Integer STANDARD_APPLE_WEIGHT = 150;
	
	public Apple (String color, Integer weight) {
		this.color = color;
		this.weight = weight;
	}
	
	/**
	 * before java 8
	 * 选出苹果中颜色为绿色的
	 * 如果需要选出重量大于150的苹果，需要改下面的if判断，重新写方法。
	 * @param inventory
	 * @return
	 * 第一种写法
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
	
	/**
	 * 第二种写法
	 * @param inventory
	 * @param color
	 * @param weight
	 * @return
	 */
	public static List<Apple> filterApples(List<Apple> inventory, String color, int weight){
		List<Apple> result = new ArrayList<Apple>();
		
		for(Apple apple : inventory) {
			if (Color.GREEN.getName().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * 第三种写法，基于策略模式
	 * 行为参数化 
	 *
	 */
	public interface ApplePredicate{
		boolean test(Apple apple);
	}
	
	public static class AppleColorPredicate implements ApplePredicate {

		@Override
		public boolean test(Apple apple) {
			return apple.getColor().equals(Color.GREEN.getName());
		}
		
	}
	
	public static class AppleWeightPredicate implements ApplePredicate {

		@Override
		public boolean test(Apple apple) {
			return apple.getWeight() > STANDARD_APPLE_WEIGHT;
		}
		
	}
	
	/**
	 * 测试用例
	 * {@link com.feivirus.lambda.reason.AppleTest.testFilterApplesWithStrategy()}
	 * @param inventory
	 * @param applePredicate
	 * @return
	 */
	public static List<Apple> filterApplesWithStrategy(List<Apple> inventory, ApplePredicate applePredicate) {
		List<Apple> result = new ArrayList<Apple>();
		
		for(Apple apple : inventory) {
			if (applePredicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * after java 8
	 * 基于lambda表达式
	 * @param apple
	 * @return
	 */
	public static boolean isGreenApple(Apple apple) {
		return Color.GREEN.getName().equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > STANDARD_APPLE_WEIGHT;
	}
	
	public interface Predicate<T> {
		boolean test(T t);
	}
	
	/**
	 * 测试用例
	 * {@link com.feivirus.lambda.reason.AppleTest.testFilterApples()}
	 * @param inventory
	 * @param p
	 * @return
	 */
	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<Apple>();
		
		for(Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
