package com.feivirus.lambda.reason;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		Apple.filterApples(inventory, Apple::isGreenApple);
		Apple.filterApples(inventory, Apple::isHeavyApple);
		
		//lambda简写,匿名函数
		Apple.filterApples(inventory, (Apple a) -> Color.GREEN.getName().equals(a.getColor()));
		Apple.filterApples(inventory, (Apple a) -> a.getWeight() < Apple.STANDARD_APPLE_WEIGHT || 
				Color.GREEN.getName().equals(a.getColor()));
		
		//调用lambda库
		//filter(inventory, (Apple a) -> a.getWeight() > STANDARD_APPLE_WEIGHT);
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
