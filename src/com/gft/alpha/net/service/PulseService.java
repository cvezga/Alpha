package com.gft.alpha.net.service;

import com.gft.alpha.Context;
import com.gft.alpha.utils.TCPUtil;

public class PulseService implements AlphaService {

	private long sleepTime;
	
	@Override
	public void run() {
		
		while(true){
		
			TCPUtil.sendToService("S-PULSE-SERVICE","S-PULSE-SERVICE:"+Context.getString("vmname")+":"+Context.getString("ip")+":"+Context.getString("port"));
			
			sleep(sleepTime);
		}
		
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(String[] args) {
		this.sleepTime = Long.parseLong(args[2]);
		
	}

}
