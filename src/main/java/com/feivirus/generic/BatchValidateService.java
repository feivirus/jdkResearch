package com.feivirus.generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * 
 * @author feivirus
 *
 */
public class BatchValidateService {
	public <R, T>  R execute(Map<Integer , List<T>> map, Function<String, R> callback) {
		boolean falg = isSizeEqual(map);
		return callback.apply("");
	}
	
	public <T>boolean isSizeEqual(Map<Integer, List<T>> map) {
		if (map == null) {
			return false;
		}
		
		Set<Integer> sizeList = new HashSet<Integer>();
		Iterator<Map.Entry<Integer, List<T>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, List<T>> entry = iterator.next();
			List<T> value = entry.getValue();
			if (null != value && 0 != value.size()) {
				sizeList.add(value.size());
			}
		}
		if (sizeList.isEmpty() || sizeList.size() > 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String [] args) {
		BatchValidateService batchvalidateService = new BatchValidateService();
		
		
		//batchvalidateService.execute(map, callback)
	}
}
