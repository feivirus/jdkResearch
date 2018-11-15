package com.feivirus.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hamcrest.Condition.Step;

/**
 * 流式编程
 * @author feivirus
 * 1.遍历数据集的高级迭代器,透明的并行处理
 * 2.常用支持操作filter(排除过滤),sort(排序),map(对元素转换形式或提取信息),collect(最后转换返回形式),
 *   reduce,find,match,limit(截断限制),foreach(遍历),distinct,count,skip
 * 3.集合与流。 就像顺序播放DVD与流媒体。集合会把所有元素加载内存。流式延迟处理的集合，需要计算时才加载.
 * 4.有点类似builder模式,数据源->中间操作链(filter)->终端操作(collect)
 * 5.流特化,避免装箱拆箱,mapToInt
 * 6.常用的收集器count,maxBy,summingDouble,joining,averagingDouble,toList,toSet,toCollection
 * 7.多级分组，分区
 */
public class StreamProgram {
	public final static Integer STAND_CALORY = 140;
	
	private List<Dish> inputDishes = Arrays.asList(new Dish(1d, "d1", DishType.FISH), 
			new Dish(2d, "d2", DishType.FISH),
			new Dish(3d, "d3", DishType.MEAT));
	
	/**	 
	 * 业务需求:
	 * 输入: Dish的列表
	 * 输出:
	 * 1.选择卡路里低于140的食物
	 * 2.根据热量的卡路里进行排序
	 * 3.返回名称列表
	 * {@link com.feivirus.stream.StreamTest.testHistory()}
	 * 4.流和迭代器一样只能被消费一次
	 */
	public List<String> history() {		
		/**
		 * before java 8
		 */				
		List<Dish> lowCaloricDishes = new ArrayList<>();
		
		//1.选择卡路里低于140的食物
		for(Dish dish : inputDishes) {
			if (dish.getCalories() < 140) {
				lowCaloricDishes.add(dish);
			}
		}
		
		//2.根据热量的卡路里进行排序
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish o1, Dish o2) {
				// TODO Auto-generated method stub
				return o1.getCalories().compareTo(o2.getCalories());
			}
		});
		
		//3.返回名称列表
		List<String> nameList = new ArrayList<>();
		
		for(Dish dish : lowCaloricDishes) {
			nameList.add(dish.getName());
		}	
		
		
		/**
		 * after java 8
		 */
		nameList = inputDishes.stream()
				.filter((Dish d) -> d.getCalories() < 140)
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList());	
		System.out.println("遍历查看值");		
		nameList = inputDishes.stream()
				.filter((Dish d) -> { System.out.println(d.getName());
					return d.getCalories() < 140;
				})
				.map(d -> {
					System.out.println(d.getName());
					return d.getName();
				})
				.limit(3)
				.collect(Collectors.toList());
		return nameList;		
	}
	
	public void streamSample() {
		Map<DishType, List<Dish>> dishesMap = inputDishes.stream()
				.collect(Collectors.groupingBy(Dish::getType));
		
		List<String> strList = Arrays.asList("java8", "in", "action");
		java.util.stream.Stream<String> strStream = strList.stream();
		try {
			strStream.forEach(System.out::println);
			
			//消费两次测试
			strStream.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		//流特化,避免装箱拆箱
		double calories = inputDishes.stream().mapToDouble(Dish::getCalories).sum();
		OptionalDouble maxCalories = inputDishes.stream().mapToDouble(Dish::getCalories)
				.max();		
	}
	
	public void createStream() {
		//数值流
		IntStream evenNumbers = IntStream.rangeClosed(1, 100)
				.filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.count());
		
		//值创建
		Stream<String> strStream = Stream.of("java", "test", "hello");
		strStream.map(String::toUpperCase).forEach(System.out::println);
		
		//数组流
		int[] numbers = {1, 2, 3, 4, 5};
		System.out.println(Arrays.stream(numbers).sum());
		
		//函数流,无限流
		Stream.iterate(0, n -> n + 2)
			  .limit(10)
			  .forEach(System.out::println);
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
	}
	
	/**
	 * 创建收集器
	 */
	public void createCollector() {
		//1.计数
		long countDish = inputDishes.stream().collect(Collectors.counting());
			 countDish = inputDishes.stream().count();
		System.out.println("countDish " + countDish);
		
		//2.最大
		Comparator<Dish> dishComparator = Comparator.comparingDouble(Dish::getCalories);
		Optional<Dish> mostCalory = inputDishes.stream().collect(Collectors.maxBy(dishComparator));
		System.out.println("max " + mostCalory.get());
		
		//3.汇总求和
		Double total = inputDishes.stream().collect(Collectors.summingDouble(Dish::getCalories));
		System.out.println("total " + total);
		
		//4.汇总平均数
		Double average = inputDishes.stream().collect(Collectors.averagingDouble(Dish::getCalories));
		System.out.println("average " + average);
		
		//5.连接字串
		String menu = inputDishes.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println("join " + menu);
	}
	
	/**
	 * 创建分组
	 */
	public void createGroup() {
		//分组
		Map<Dish.CaloricLevel, List<Dish>> dishGroup = inputDishes.stream().collect(Collectors.groupingBy(dish -> {
			if (dish.getCalories() <= 400) {
				return Dish.CaloricLevel.DIET;
			} else if (dish.getCalories() <= 700) {
				return Dish.CaloricLevel.NORMAL;
			} else {
				return Dish.CaloricLevel.FAT;
			}
		}));
		
		//多级分组,先按照类型，再按照热量等级
		Map<DishType, Map<Dish.CaloricLevel, List<Dish>>> dishGroupLevel = inputDishes.stream().collect(Collectors.groupingBy(Dish::getType, 
			Collectors.groupingBy(dish -> {
				if (dish.getCalories() <= 400) {
					return Dish.CaloricLevel.DIET;
				} else if (dish.getCalories() <= 700) {
					return Dish.CaloricLevel.NORMAL;
				} else {
					return Dish.CaloricLevel.FAT;
				}
			})
		));
	}
	
	/**
	 * 分区
	 */
	public void createPartition() {
		Map<Boolean, List<Dish>> partitionedDish = inputDishes.stream().collect(Collectors.partitioningBy(Dish::isMeat));
		List<Dish> meatDishList = inputDishes.stream().filter(Dish::isMeat).collect(Collectors.toList());
		System.out.println(partitionedDish);
	}
}
