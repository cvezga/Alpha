package com.gft.alpha.bo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.gft.alpha.Context;
import com.gft.alpha.data.DataMap;
import com.gft.alpha.data.EntityDataType;
import com.gft.alpha.data.Source;

public class Loader {

	private String[] LEVELS = {"Source","EntityType","Tag"};
	
	private Context ctx;
	
	private Source source;

	private EntityDataType edt;
	
	public Loader(Context ctx) {
		super();
		this.ctx = ctx;
	} 
	
	
	public void loadData(String dataFile){
		
		System.out.println("Loading data "+dataFile);
		
		try (Stream<String> stream = Files.lines(Paths.get(dataFile))) {

			stream.forEach( line -> process(line) );

		} catch (IOException e) {
			e.printStackTrace();
		}

		if(this.source!=null){
			DataMap.save(this.source);
		}
		
	}


	private Object process(String line) {
		line = line.trim();
		if(line.length()==0) return null;
		
		int level = getLineLevel(line);
		
		switch(level){
		case 0: processSource(line); break;
		case 1: processEDT(line); break;
		case 2: processTag(line); break;
		default: System.out.println("Level not supported. "+level);
		}
		
		
		
		return null;
	}


	private void processSource(String line) {
		if(this.source!=null){
			DataMap.save(this.source);
		}
		String name = line.trim();
		source = new Source(name);
		
		
	}


	private void processEDT(String line) {
		String name = line.replaceAll(">", "").trim();
		
		this.edt = new EntityDataType(name);
		this.source.addEDT(edt);
		
	}


	private void processTag(String line) {
		line = line.replaceAll(">", "").trim();
		int idx = line.indexOf(":");
		String field = line.substring(0, idx);
		String value = line.substring(idx+1).trim();
		
		this.edt.getTagMap().put(field, value);
		
	}


	private int getLineLevel(String line) {
		int level = 0;
		
		int idx=-1;
		while(true){
			idx = line.indexOf(">",idx+1);
			if(idx>-1){
				level++;
			}else{
				break;
			}
		}

		return level;
	}
	
}
