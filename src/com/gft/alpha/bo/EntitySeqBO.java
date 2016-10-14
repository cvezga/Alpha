package com.gft.alpha.bo;

public class EntitySeqBO {
	
	private static long entityId = 0;
	
	public synchronized long getNextEntityId(){
		return ++entityId;
	}

}
