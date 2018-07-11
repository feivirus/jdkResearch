package com.feivirus.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public abstract class TypeReference<T> {
	
	private Type type;
	
	private volatile Constructor<?> constructor;
	
	protected TypeReference() {
		
	}
	
}
