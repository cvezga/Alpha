package com.gft.alpha.net.handler;

import com.gft.alpha.Context;
import com.gft.alpha.utils.TCPUtil;

public class SubcriptionResponseProtocolHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "SUBSCRIBE";
	}

	@Override
	public String process(String data) {
		String[] tkns = data.split(":");
		
		String protocol = tkns[0];
		String service = tkns[1];
		String ip = tkns[2];
		int port = Integer.parseInt(tkns[3]);
		
		if(Context.providedServiceMap.keySet().contains(service)){
		   TCPUtil.send(ip, port, "REGISTER-SERVICE:"+service+":"+Context.getString("ip")+":"+Context.getString("port")+";");
		   System.out.println("Sent provided service "+service+"  to "+ip+":"+port);
		}
		
		return "OK";
	}

}
