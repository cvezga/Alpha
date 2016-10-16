package com.gft.alpha.commad;

import com.gft.alpha.Context;
import com.gft.alpha.vo.QueryService;

public class QueryServiceCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		String cmd = args[0];
		String source = args[1];
		String queryHandlerClass = args[2];
		QueryService qs = new QueryService(source, queryHandlerClass);
		Context.qsMap.put(source, qs);
		Context.sourceList.add(source);
		System.out.println("Query Service Source "+source+" registered");
		return "Query Service Source "+source+" registered";
	}

	@Override
	public String getCommandName() {
		return "query-service";
	}

}
