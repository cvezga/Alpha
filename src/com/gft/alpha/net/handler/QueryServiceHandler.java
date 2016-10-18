package com.gft.alpha.net.handler;

import com.gft.alpha.data.DataMap;

public class QueryServiceHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "query-request";
	}

	@Override
	public String process(String data) {
		String outcome = null;
		
		String[] args = data.split(":");
		
		
		String source = args[1];
		
		outcome = DataMap.getDataAsString();
		
		System.out.println(outcome);
		
		return outcome+";";
	}

}
