package com.gft.alpha.commad;

import com.gft.alpha.data.DataMap;

public class ShowDataCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		String data = DataMap.getDataAsString();
		return data;
	}

	@Override
	public String getCommandName() {
		return "show-data";
	}
	
	@Override
	public String getHelpText() {
		return "show-data: Shows VM data";
	}

}
