package com.gft.alpha.commad;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCommand implements AlphaCommand {
	
	private static final String COMMAND_NAME = "date";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");

	@Override
	public String run(String[] args) {
		return sdf.format(new Date());
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
