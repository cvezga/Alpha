package com.gft.alpha.commad;

public interface AlphaCommand {
	
	String run(String[] args);
	
	String getCommandName();

}
