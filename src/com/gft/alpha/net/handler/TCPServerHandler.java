package com.gft.alpha.net.handler;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.gft.alpha.utils.TCPUtil;

public class TCPServerHandler implements Runnable {
	
	private static Map<String, ProtocolHandler> phMap = new HashMap<>();
	static {
		register(new MonitorResponseProtocolHandler());
		register(new MonitorQueryServiceHandler());
		register(new QueryServiceHandler());
		register(new RegisterServiceProviderHandler());
		register(new PulseServiceHandler());
		register(new EntitySeqHandler());
		
		
	}
	
	private static void register(ProtocolHandler ph) {
		phMap.put(ph.getProtocolIdentifier(), ph);
		
	}
	
	private Socket sc;
	
 
	public TCPServerHandler(Socket sc) {
		this.sc = sc;
	}



	



	@Override
	public void run() {
		
		String data = TCPUtil.readSocket(sc);
		
		System.out.println(data);
		
		int idx = data.indexOf(":");
		
		String protocol = data.substring(0,idx);
		
		ProtocolHandler ph = phMap.get(protocol);
		if(ph==null){
			System.out.println("TCPServerHandler: Protocol not supported: "+protocol);
		}else{
		
			String outconme = ph.process(data);
			
		    TCPUtil.writeSocket(sc, outconme);
		}
		try {
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
