package com.gft.alpha.net;

import com.gft.alpha.Context;
import com.gft.alpha.utils.TCPUtil;

public class MonitorProtocolHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "monitor";
	}

	@Override
	public String process(String data) {
		String[] tokens = data.split(":");
		
		if(!getProtocolIdentifier().equals(tokens[0])){
			throw new RuntimeException("Wrong protocol handler passed to "+data+" in "+getProtocolIdentifier()+" handler");
		}
		
		String ip = tokens[1];
		int port = Integer.parseInt(tokens[2]);
		
		TCPUtil.send(ip,port,"monitor-response:"+Context.vmname+":"+Context.ip);
		
		return "OK";
	}

}
