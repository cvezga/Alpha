package com.gft.alpha.command;

public interface Command {
	
	String getCommandNamme();

	 void run(String commandInstruction);

}
