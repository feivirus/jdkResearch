package com.feivirus.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 常用支持操作filter(排除过滤),sort(排序),map(对元素转换形式或提取信息),collect(最后转换返回形式),
 * reduce,find,match,limit(截断限制),foreach(遍历),distinct,count,skip
 * @author feivirus
 *
 */
public class StreamLib {
	private List<Dish> inputDishes = Arrays.asList(new Dish(1d, "d1", DishType.FISH), 
			new Dish(2d, "d2", DishType.FISH),
			new Dish(3d, "d3", DishType.MEAT));
	
	/**
	 * 测试用例 {@link com.feivirus.stream.StreamLibTest.testLib()}
	 */
	public void testLib() {
		//1.filter
		System.out.println("filter");
		inputDishes.stream().filter(d -> d.getCalories() > 1)
					.forEach(System.out::println);
		
		//2.distinct
		System.out.println("testDistinct");
		inputDishes.stream().distinct().forEach(System.out::println);
		
		//3.limit
		System.out.println("limit");
		inputDishes.stream().limit(2).forEach(System.out::println);
		
		//4.skip
		System.out.println("skip");
		inputDishes.stream().skip(2).forEach(System.out::println);
		
		//5.map
		System.out.println("map");
		List<String> strList = Arrays.asList("123", "126", "787955");
		List<Integer> intList = strList.stream().map(String::length).collect(Collectors.toList());
		
		//6.flatmap
		List<String> wordList = Arrays.asList("hello", "world");
		List<String[]> result1 = wordList.stream().map(word -> word.split(""))
		.distinct()
		.collect(Collectors.toList());
		System.out.println(result1);
		
		List<String> result2 = wordList.stream()
				.map(w -> w.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList());
		System.out.println(result2);
		
		//7.match
		boolean bRet = inputDishes.stream().anyMatch(d -> d.getType() == DishType.MEAT);
		if (bRet) {
			System.out.println("菜中有肉");
		}
		bRet = inputDishes.stream().allMatch(d -> d.getCalories() > 2);
		if (bRet) {
			System.out.println("所有的菜热量都大于2");
		}
		
		//8.find
		Optional<Dish> dish = inputDishes.stream().filter(Dish::isMeat).findAny();
		System.out.println(dish.get());
		inputDishes.stream().filter(Dish::isFish).findFirst()
		.ifPresent(d -> System.out.println(d));
		
		//9.reduce
		int sum = intList.stream().reduce(0, (a, b) -> a + b);
		System.out.println("sum is " + sum);
		Optional<Integer> sum2 = intList.stream().reduce((a, b) -> a*b);
		System.out.println("sum2 is " + sum2);
		Optional<Integer> max = intList.stream().reduce(Integer::max);
		System.out.println("max is " + max);		
	}	
}
