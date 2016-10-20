package com.gft.alpha.commad;

import com.gft.alpha.bo.Loader;

public class DataLoaderCommand implements AlphaCommand {

	

	@Override
	public String run(String[] args) {
	
		String fileName = args[1];

		Loader loader = new Loader(null);
		loader.loadData(fileName);
		
		return null;
	}

	@Override
	public String getCommandName() {
		return "load";
	}
	
	@Override
	public String getHelpText() {
		return "load: Load data into VM";
	}

}
