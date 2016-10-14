package com.gft.alpha.commad;

import com.gft.alpha.Context;

public class RegisterCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
	
		String alias = args[1];
		String className = args[2];
		Context.servicesMap.put(alias, className);
		String outcome = "Service "+className+" registered with as alias: "+alias;
		System.out.println(outcome);
		return outcome;
	}

	@Override
	public String getCommandName() {
		return "register";
	}

}
