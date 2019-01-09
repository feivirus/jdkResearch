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
	
	public static <T> T newInstance(Constructor<T> constructor) {
		return newInstance(null, constructor, null);
	}
	
	public static <T> T newInstance(Constructor<T> constructor, Object[] args) {
		return newInstance(null, constructor, args);
	}
	
	public static <T> T newInstance(Class<T> clazz, Constructor<T> constructor, Object[] args) {
		if ((clazz == null) && (constructor == null)) {
			throw new IllegalArgumentException("cannot new instance without clazz and constructor");
		}
		if (constructor == null) {
			constructor = getConstructor(clazz, (Class[])null);
		}
		
		boolean oldAccessible = constructor.isAccessible();
		try {
			if (!oldAccessible) {
				constructor.setAccessible(true);
			}
			return constructor.newInstance(args);
		} catch (Exception ex) {
			
		} finally {
			constructor.setAccessible(oldAccessible);
		}
		return null;
	}
}
