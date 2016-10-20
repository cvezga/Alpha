package com.gft.alpha.commad;

import com.gft.alpha.Context;
import com.gft.alpha.vo.QueryService;

public class ProvideServiceCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		String cmd = args[0];
		String source = args[1];
		String queryHandlerClass = args[2];
		QueryService qs = new QueryService(source, queryHandlerClass);
		Context.providedServiceMap.put(source, qs);
		Context.sourceList.add(source);
		System.out.println("Service registered: "+source);
		return "Service registered "+source;
	}

	@Override
	public String getCommandName() {
		return "provide-service";
	}
	
	@Override
	public String getHelpText() {
		return "provide-service: Provide a VM Service";
	}

}
