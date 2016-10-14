package com.gft.alpa.service.terminal;

import java.net.Socket;

import com.gft.alpha.utils.TCPUtil;

public class TerminalProtocol implements Runnable {
	
	private Socket sc;
	private boolean running;

	public TerminalProtocol(Socket sc) {
		super();
		this.sc = sc;
	}

	
	@Override
	public void run() {
		this.running = true;
		while(this.running){
			String input = TCPUtil.readSocket(sc);
			
		}
		// TODO Auto-generated method stub

	}

}
