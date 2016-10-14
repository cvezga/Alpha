package com.gft.alpha.commad;

public class ImportCommand implements AlphaCommand {
	
	private CommandProcesor cmdP;

	public ImportCommand(CommandManager commandManager) {
		this.cmdP = new CommandProcesor(commandManager);
	}





	@Override
	public String run(String[] args) {
	
		String fileName = args[1];
		
	    cmdP.processCommandFile(fileName);
		 
		return "Imported  "+fileName;
	}



	

	@Override
	public String getCommandName() {
		return "import";
	}

}
