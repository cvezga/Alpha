package com.gft.alpha.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Source {
	
	private long id;

	private String name;
	
	private List<EntityDataType> edtList;
	
	

	public Source(String name) {
		super();
		this.name = name;
		this.edtList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EntityDataType> getEdtList() {
		return edtList;
	}

	public void setEdtList(List<EntityDataType> edtList) {
		this.edtList = edtList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addEDT(EntityDataType edt) {
		edt.setId(EntitySequencer.getNextEntityId());
		this.edtList.add(edt);
		
	}

	public String asString() {
		StringBuilder sb = new StringBuilder();
		sb.append("entityId:").append(this.id).append(", sourceName:").append(this.name).append("\n");
		for(EntityDataType edt : this.edtList){
			sb.append(edt.asString()).append("\n");
		}
		return sb.toString();
	}

	
	
	
}
