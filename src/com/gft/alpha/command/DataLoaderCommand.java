package com.gft.alpha.command;

import com.gft.alpha.bo.Loader;

public class DataLoaderCommand implements Command {

	@Override
	public void run(String commandInstruction) {
		String[] tokens = commandInstruction.split(" ");
		
		String fileName = tokens[1];
		
		Loader loader = new Loader(null);
		loader.loadData(fileName);
	}

}
