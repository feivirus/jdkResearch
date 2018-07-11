package com.feivirus.generic;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MapContainer {
	private Map<Class<?>,  Object> mapContainer = new HashMap<Class<?>, Object>();

	public <T> T getContainerObject(Class<T> clazz) {
		return clazz.cast(mapContainer.get(clazz));
	}

	public <T> void setContainerObject(Class<T> clazz, T t) {
		mapContainer.put(clazz, t);
	}
	
	public static void main(String[] args) {
		MapContainer mapContainer = new MapContainer();
		
		mapContainer.setContainerObject(String.class, "Java");
		mapContainer.setContainerObject(Integer.class, 110);
		
		String strValue = mapContainer.getContainerObject(String.class);
		int intValue = mapContainer.getContainerObject(Integer.class);
		System.out.println(strValue + "     " + intValue);
	}
}
