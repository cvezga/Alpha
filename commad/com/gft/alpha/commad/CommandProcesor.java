package com.gft.alpha.commad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CommandProcesor {
	
	private CommandManager cmdMng;

	public CommandProcesor(CommandManager commandManager) {
		this.cmdMng= commandManager;
	}

	public void processCommandFile(String fileName) {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(line -> processCommand(line));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Object processCommand(String line) {
		line = line.trim();
		if (line.length() == 0 || line.startsWith("#"))
			return null;
		String[] args = line.split(" ");
		String cmd = args[0];
		cmdMng.runCommand(cmd, args);
		return null;
	}

}
