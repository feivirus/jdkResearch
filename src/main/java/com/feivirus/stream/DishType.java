package com.feivirus.stream;

public enum DishType {	
	MEAT(1, "肉"),
	FISH(2, "鱼"),
	MILK(3, "奶"),
	EGG(4, "蛋");
	
	private Integer value;
	
	private String  name;
	
	DishType(Integer value, String name) {
		this.name  = name;
		this.value = value;
	}
	
}
