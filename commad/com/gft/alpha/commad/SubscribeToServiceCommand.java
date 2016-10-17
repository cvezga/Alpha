package com.gft.alpha.commad;

public class SubscribeToServiceCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		String serviceName = args[1];
		
		return null;
	}

	@Override
	public String getCommandName() {
		return "subscribe-to-service";
	}

}
