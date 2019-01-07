package com.feivirus.statemachine.util;

import java.lang.reflect.Constructor;

public class ReflectionUtil {
	
	public static <T> Constructor<T> getConstructor(Class<T> type, Class<?>[] paramTypes) {
		try {
			Constructor<T> constructor = type.getDeclaredConstructor(paramTypes);
			return constructor;
		} catch (NoSuchMethodException exception) {
			
		}
		return null;
	}
}
