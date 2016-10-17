package com.gft.alpha.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EntityDataType {
	
	private long id;
	
	private String name;
	
	private Map<String, String> tagMap;

	
	
	
	public EntityDataType(String name) {
		super();
		this.name = name;
		this.tagMap = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getTagMap() {
		return tagMap;
	}

	public void setTagMap(Map<String, String> tagMap) {
		this.tagMap = tagMap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object asString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\tentityId:").append(this.id).append(", edt: ").append(this.name).append("\n");
		for(Entry<String,String> entry : this.tagMap.entrySet()){
			sb.append("\t\t"+entry.getKey()).append(":").append(entry.getValue()).append("\n");
		}
		return sb.toString();
	}
	
	

}
