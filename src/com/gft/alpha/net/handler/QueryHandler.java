package com.gft.alpha.net.handler;

import com.gft.alpha.data.DataMap;

public class QueryHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "query";
	}

	@Override
	public String process(String data) {

		int idx = data.indexOf(":");

		String sourceName = data.substring(idx + 1);

		String queryResponse = DataMap.getSourceAsString(sourceName);

		return queryResponse;
	}

}
