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
		System.out.println(data);
		String[] tkns = data.split(":");
		
		String protocol = tkns[0];
		String service = tkns[1];
		String ip = tkns[2];
		int port = Integer.parseInt(tkns[3]);
		
		//if(!Context.subscriptionMap.keySet().contains(service)){
		TCPUtil.send(ip, port, "REGISTER-SERVICE:"+service+":"+Context.ip+":"+Context.port+";");
		//}
		
		return "Register service response sent to "+ip+":"+port;
	}

}
