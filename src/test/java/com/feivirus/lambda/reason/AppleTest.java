package com.feivirus.lambda.reason;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Comparator.*;
import org.junit.Assert;
import org.junit.Test;

public class AppleTest {
	@Test
	public void testFilterApplesWithStrategy() {
		List<Apple> inventory = Arrays.asList(new Apple("green", 100), 
				new Apple("red", 200),
				new Apple("blue", 300));
		
		List<Apple> greenApples = Apple.filterApplesWithStrategy(inventory, new Apple.AppleColorPredicate());
		Assert.assertTrue( greenApples.size() > 0); 
		
	}
	
	@Test
	public void testFilterApples() {
		List<Apple> inventory = new ArrayList<Apple>();
		
		//我觉得经历了 方法->类->自动产生策略模式的接口实现类 转换
		Apple.filterApples(inventory, Apple::isGreenApple);
		Apple.filterApples(inventory, Apple::isHeavyApple);
		
		//lambda简写,匿名函数
		//我觉得经历了 匿名方法->匿名类->自动产生策略模式的接口实现类  转换
		Apple.filterApples(inventory, (Apple a) -> Color.GREEN.getName().equals(a.getColor()));
		Apple.filterApples(inventory, (Apple a) -> a.getWeight() < Apple.STANDARD_APPLE_WEIGHT || 
				Color.GREEN.getName().equals(a.getColor()));
		
		Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		inventory.sort(byWeight);

		//lambda方法引用
		inventory.sort(Comparator.comparing(Apple::getWeight));
	}
	
	@Test
	public void testFilter() {
		List<Apple> inventory = new ArrayList<>();
		
		Apple.filter(inventory, Apple::isGreenApple);		
		Apple.filter(inventory, (Apple a) -> a.getWeight() > Apple.STANDARD_APPLE_WEIGHT);
		
		List<Integer> intList = Arrays.asList(new Integer(1), 
				new Integer(2),
				new Integer(3));
		
		List<Integer> result = Apple.filter(intList, (Integer i) -> i % 2 == 0);
		Assert.assertTrue(result.size() > 0);
	}
	
	/**
	 * 使用stream， stream侧重于计算. lambda侧重于筛选过滤
	 */
	@Test
	public void testStream() {
		List<Apple> inventory = new ArrayList<Apple>();
		
		List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > Apple.STANDARD_APPLE_WEIGHT)
				.collect(toList());
	}	
}
