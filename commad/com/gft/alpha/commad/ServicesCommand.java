package com.gft.alpha.commad;

import com.gft.alpha.Context;

public class ServicesCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(String k : Context.providedServiceMap.keySet()){
			sb.append(k).append("\n");
		}
		return sb.toString();
	}

	@Override
	public String getCommandName() {
		return "services";
	}

}
