package com.gft.alpha.command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CommandManager {
	
	private static Map<String, Command> commandMap = new HashMap<>();
	static {
		commandMap.put("vmname", new VmNameCommand());
		commandMap.put("load", new DataLoaderCommand());
	}
	
	public void runCommand(String command, String commandInstruction){
		
		Command cmd = commandMap.get(command);
		if(cmd!=null){
			cmd.run(commandInstruction);
		}else{
			System.out.println("Error: No command processor found for: "+command);
		}
	}
	
	public void processCommandFile(String fileName){
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach( line -> processCommand(line) );

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Object processCommand(String line) {
		line=line.trim();
		if(line.length()==0) return null;
		String[] data = line.split(" ");
		String cmd = data[0];
		runCommand(cmd, line);
		return null;
	}

}
