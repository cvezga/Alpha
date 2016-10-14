package com.gft.alpha.service;

import com.gft.alpha.bo.EntitySeqBO;
import com.gft.alpha.net.TCPRunnable;

public class EnitytSeqService extends AbsrtactTCPServerService {

	private int port;
	private String[] args;

	
	


	@Override
	public void init(String[] args) {
		String xport = args[2];
		this.port = Integer.parseInt(xport);
		this.args = args;
	}

	@Override
	TCPRunnable getRunnable() {
		EntitySeqHandler h = new EntitySeqHandler(args);
		return h;
	}

	@Override
	int getPort() {
		return this.port;
	}

}
