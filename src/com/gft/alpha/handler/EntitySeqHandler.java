package com.gft.alpha.handler;

import com.gft.alpha.bo.EntitySeqBO;
import com.gft.alpha.net.ProtocolHandler;

public class EntitySeqHandler implements ProtocolHandler {
	
	private EntitySeqBO bo;

	public EntitySeqHandler() {
		super();
		this.bo = new EntitySeqBO();
	}



	@Override
	public String getProtocolIdentifier() {
		return "entity-seq";
	}



	@Override
	public String process(String data) {
		long nextEntityId = bo.getNextEntityId();
		return String.valueOf(nextEntityId);
	}

}
