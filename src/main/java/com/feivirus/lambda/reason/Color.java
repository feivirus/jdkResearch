package com.feivirus.lambda.reason;

import org.apache.commons.lang.StringUtils;

public enum Color {
	GREEN("green"),
	
	RED("red");
		
	private String name;
	
	private Color() {
		
	}
	
	private Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
	
	public static Color getColorByName(String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		
		for(Color color : Color.values()) {
			if (color.getName().equals(name)) {
				return color;
			}
		}
		return null;
	}
}
