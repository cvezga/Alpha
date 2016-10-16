package com.gft.alpha.commad;

import com.gft.alpha.Context;


public class ContextCommand implements AlphaCommand {

	
	
	@Override
	public String run(String[] args) {
		String fieldName = args[1];
		String value = args[2];
		System.out.println("Setting context var "+fieldName+" to "+value);
		switch(fieldName){
		case "ip": Context.ip = value; break;
		case "vmname": Context.vmname = value; break;
		default:
		   System.out.println("Field name "+fieldName+" is not supported in Context");
		}
		return null;
	}

	@Override
	public String getCommandName() {
		return "set";
	}

}
