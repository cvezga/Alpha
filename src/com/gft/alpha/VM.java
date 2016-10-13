package com.gft.alpha;

import com.gft.alpha.command.CommandManager;

public class VM {

	
	
	public static void main(String[] args) {
		
		if(args.length!=1){
			System.err.println("Invalid parameters");
			System.err.println("Usage: java -jar vm <command file name>");
			System.exit(1);
		}
		
		CommandManager cmdMgr = new CommandManager();
		
		cmdMgr.processCommandFile(args[0]);
		
	}
}
