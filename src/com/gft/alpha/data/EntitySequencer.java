package com.gft.alpha.data;

public class EntitySequencer {
	
	private static long entityId=1000;
	
	public static synchronized long getNextEntityId(){
		return EntitySequencer.entityId++;
	}

}
