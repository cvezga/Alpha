package com.gft.alpha.commad;

public class ExitCommand implements AlphaCommand {
	
	public static final String EXIT_MESSAGE = "-=*Exit.Teminal.Service*=-";

	@Override
	public String run(String[] args) {
		return EXIT_MESSAGE;
	}

	@Override
	public String getCommandName() {
		return "exit";
	}

}
