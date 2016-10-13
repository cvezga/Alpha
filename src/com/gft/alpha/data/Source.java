package com.gft.alpha.data;

import java.util.HashMap;
import java.util.Map;

public class Source {
	
	private long id;

	private String name;
	
	private Map<String, EntityDataType> edtMap;
	
	

	public Source(String name) {
		super();
		this.name = name;
		this.edtMap = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, EntityDataType> getEdtMap() {
		return edtMap;
	}

	public void setEdtMap(Map<String, EntityDataType> edtMap) {
		this.edtMap = edtMap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addEDT(EntityDataType edt) {
		edt.setId(EntitySequencer.getNextEntityId());
		this.edtMap.put(edt.getName(),edt);
		
	}

	public String asString() {
		StringBuilder sb = new StringBuilder();
		sb.append("sourceName:").append(this.name);
		for(EntityDataType edt : this.edtMap.values()){
			sb.append(edt.asString());
		}
		return sb.toString();
	}

	
	
	
}
