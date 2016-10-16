package com.gft.alpha.net.handler;

import com.gft.alpha.bo.EntitySeqBO;

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
