package com.feivirus.annotation;

import java.io.File;
import java.lang.reflect.Field;

public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz) {
		String fruitNamePrefix = "水果名称: ";
		String fruitColorPrefix = "水果颜色: ";
		String fruitProviderPrefix = "水果供应商: ";
		
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = (FruitName)field.getAnnotation(FruitName.class);
				fruitNamePrefix  = fruitNamePrefix + fruitName.value();
				System.out.println(fruitNamePrefix);
			}
			if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = (FruitColor)field.getAnnotation(FruitColor.class);
				fruitColorPrefix = fruitColorPrefix + fruitColor.fruitColor().toString();
				System.out.println(fruitColorPrefix);
			}
			if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = (FruitProvider)field.getAnnotation(FruitProvider.class);
				fruitProviderPrefix = fruitProviderPrefix + fruitProvider.address();
				System.out.println(fruitProviderPrefix);
			}
		}
	}
}
