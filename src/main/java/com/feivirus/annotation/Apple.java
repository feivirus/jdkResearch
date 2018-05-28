package com.feivirus.annotation;

import com.feivirus.annotation.FruitColor.Color;

public class Apple {
	@FruitName("appleFeivirus")
	private String appleName;
	
	@FruitColor(fruitColor = Color.RED)
	private String appleColor;
	
	@FruitProvider(id = 1, name = "红富士", address = "红富士大厦")
	private String appleProvider;

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}
}
