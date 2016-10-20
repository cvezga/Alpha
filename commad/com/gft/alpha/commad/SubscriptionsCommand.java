package com.gft.alpha.commad;

import com.gft.alpha.Context;

public class SubscriptionsCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(String k : Context.subscriptionMap.keySet()){
			sb.append(k).append("\n");
		}
		return sb.toString();
	}

	@Override
	public String getCommandName() {
		return "subscriptions";
	}

	
	@Override
	public String getHelpText() {
		return "subscriptions: Shows current VM's subscription";
	}
}
