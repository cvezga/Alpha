package com.gft.alpha.data;

import java.util.HashMap;
import java.util.Map;

public class DataMap {
	
	private static Map<Long, Source> sourceMap = new HashMap<>();

	public static synchronized void save(Source source) {
		long id = sourceMap.size()+1;
		source.setId(id);
		sourceMap.put(id, source);
		System.out.println("saved: "+source.asString());
	}

	public static String getSourceAsString(String sourceName) {
		Source source = sourceMap.get(sourceName);
		if(source!=null){
			return source.asString();
		}
		return null;
	}

	public static String getDataAsString() {
		StringBuilder sb = new StringBuilder();
		for(Source s : sourceMap.values()){
			sb.append(s.asString()).append("\n");
		}
		return sb.toString();
	}
	

}
