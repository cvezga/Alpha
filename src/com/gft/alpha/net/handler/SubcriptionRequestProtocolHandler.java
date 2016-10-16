package com.gft.alpha.net.handler;

import com.gft.alpha.Context;
import com.gft.alpha.utils.TCPUtil;

public class SubcriptionRequestProtocolHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "subcription-request";
	}

	@Override
	public String process(String data) {
		System.out.println(data);
		String[] tkns = data.split(":");
		
		String protocol = tkns[0];
		String sourceRequested = tkns[1];
		String ip = tkns[2];
		int port = Integer.parseInt(tkns[3]);
		
		if(Context.sourceList.contains(sourceRequested)){
			TCPUtil.send(ip, port, "subcription:"+sourceRequested+":"+Context.ip+":"+Context.port);
		}
		
		return null;
	}

}
