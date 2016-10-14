package com.gft.alpha.commad;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
	
	private Map<String, AlphaCommand> commandMap;
	
	public CommandManager(){
		this.commandMap = new HashMap<>();
		
		register(new DateCommand());
		register(new DataLoaderCommand());
		register(new ImportCommand(this));
		register(new ContextCommand());
		register(new StartCommand());
		register(new RegisterCommand());
		
	}

	private void register(AlphaCommand cmd) {
		this.commandMap.put(cmd.getCommandName(), cmd);		
	}

	public String runCommand(String cmdName, String[] args){
		AlphaCommand cmd = this.commandMap.get(cmdName);
		if(cmd!=null){
			return cmd.run(args);
		}else{
			System.out.println("ERROR: unknown command "+cmdName);
		}
		
		return "ERROR: unknown command "+cmdName;
		
	}
	
	
}
