package com.feivirus.stream;

import lombok.Data;

@Data
public class Dish {
	private Double calories;
	
	private String name;
	
	private DishType type;
	
	private DISHCOLOR color;
	
	public Dish(Double calories, String name, DishType type) {
		this.calories = calories;
		this.name = name;
		this.type = type;
		this.color = DISHCOLOR.YELLOW;
	}
	
	public Double getCalories() {
		//System.out.println("get Calories " + calories);
		return calories;
	}
	
	public String getName() {
		//System.out.println("get name " + name);
		return name;
	}
	
	public boolean isMeat() {
		if (type == DishType.MEAT) {
			return true;
		}
		return false;
	}
	
	public boolean isFish() {
		if (type == DishType.FISH) {
			return true;
		}
		return false;
	}
	
	public enum DISHCOLOR {RED, BLUE, YELLOW};
	public enum CaloricLevel {DIET, NORMAL, FAT};
}
