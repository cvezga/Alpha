package com.gft.alpha.net.handler;

import com.gft.alpha.bo.EntitySeqBO;

public class SequencerService implements ProtocolHandler {

	private static final EntitySeqBO bo = new EntitySeqBO();
	
	@Override
	public String getProtocolIdentifier() {
		return "S-SEQUENCER-SERVICE";
	}

	@Override
	public String process(String data) {
		long entityId = bo.getNextEntityId();
		return getProtocolIdentifier()+":"+entityId+":;";
	}

}
