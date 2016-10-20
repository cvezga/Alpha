package com.gft.alpha.commad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {
	
	private static CommandManager instance;
	
	private Map<String, AlphaCommand> commandMap;
	
	public CommandManager(){
		this.commandMap = new HashMap<>();
		
		register(new DateCommand());
		register(new DataLoaderCommand());
		register(new ImportCommand(this));
		register(new ContextCommand());
		register(new StartCommand());
		register(new RegisterCommand());
		register(new ProvideServiceCommand());
		register(new ExitCommand());
		register(new ShowDataCommand());
		register(new ServicesCommand());
		register(new SubscriptionsCommand());
		register(new MemoryCommand());
		register(new GCCommand());
		register(new HelpCommand(this));
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

	public static CommandManager getInstance() {
		if(instance==null){
			instance = new CommandManager();
		}
		return instance;
	}

	public String getAllCommandHelpTexts() {
		StringBuilder sb = new StringBuilder();
		
		List<String> keys = new ArrayList(commandMap.keySet());
		
		Collections.sort(keys);
		for(String cmdName : keys){
			AlphaCommand cmd = commandMap.get(cmdName);
			sb.append("- ").append(cmd.getHelpText()).append("\n");
		}
		
		return sb.toString();
	}
	
	
}
