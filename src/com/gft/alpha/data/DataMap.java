package com.gft.alpha.data;

import java.util.HashMap;
import java.util.Map;

public class DataMap {
	
	private static Map<Long,Source> sourceMap = new HashMap<>();

	public static synchronized void save(Source source) {
		long id = sourceMap.size()+1;
		source.setId(id);
		sourceMap.put(id, source);
	}

	public static String getSourceAsString(String sourceName) {
		Source source = sourceMap.get(sourceName);
		if(source!=null){
			return source.asString();
		}
		return null;
	}
	

}
