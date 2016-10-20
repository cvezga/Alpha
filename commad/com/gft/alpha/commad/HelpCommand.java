package com.gft.alpha.commad;

public class HelpCommand implements AlphaCommand {
	
	private CommandManager mgr;

	public HelpCommand(CommandManager commandManager) {
		this.mgr = commandManager;
	}

	@Override
	public String run(String[] args) {
		return mgr.getAllCommandHelpTexts();
	}

	@Override
	public String getCommandName() {
		return "help";
	}
	
	@Override
	public String getHelpText() {
		return "help: Shows all command helps text";
	}

}
