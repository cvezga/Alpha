package com.gft.alpha.service;

import java.net.Socket;

import com.gft.alpha.bo.EntitySeqBO;
import com.gft.alpha.net.TCPRunnable;
import com.gft.alpha.utils.TCPUtil;

public class EntitySeqHandler implements TCPRunnable {
	
	private EntitySeqBO bo;
    private Socket sc;	
	

	public EntitySeqHandler() {
		super();
		this.bo = new EntitySeqBO();
	}



	public EntitySeqHandler(String[] args) {
		// TODO Auto-generated constructor stub
	}



	@Override
	public void run() {
		while(true){
			String request = TCPUtil.readSocket(sc);
			long nextEntityId = bo.getNextEntityId();
			TCPUtil.writeSocket(sc, String.valueOf(nextEntityId));
		}
	}



	@Override
	public void setSocket(Socket sc) {
		this.sc = sc;
		
	}

}
