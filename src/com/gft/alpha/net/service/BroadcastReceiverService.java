package com.gft.alpha.net.service;

import java.util.HashMap;
import java.util.Map;

import com.gft.alpha.Context;
import com.gft.alpha.net.handler.ProtocolHandler;
import com.gft.alpha.net.handler.SubcriptionResponseProtocolHandler;
import com.gft.alpha.net.udp.UDPBroadcastReceiver;


public class BroadcastReceiverService implements AlphaService {
	
	private static Map<String, ProtocolHandler> protocolMap = new HashMap<>();
	static {
		//register(new MonitorProtocolHandler());
		register(new SubcriptionResponseProtocolHandler());
	}

	
	private static void register(ProtocolHandler ph) {
		protocolMap.put(ph.getProtocolIdentifier(), ph);
		
	}
	private int port;

	@Override
	public void run() {

		while(true){
			UDPBroadcastReceiver udpr = new UDPBroadcastReceiver(this.port, 512);
			
			String data = udpr.receiveData();
			
			processData(data);
			
			sleep(100);
		}
	}



	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void processData(String data) {
		String[] args = data.split(":");
		
		String protocolId = args[0];
		
		ProtocolHandler ph = protocolMap.get(protocolId);
		
		if(ph!=null){
			String outcome = ph.process(data);
			System.out.println(outcome);
		}else{
			System.out.println("BroadcastReceiverService: Protocol "+protocolId+" not supported");
		}
	
		
	}

	@Override
	public void init(String[] args) {
		 
		this.port = Context.getInteger("port");
		
	}

}
