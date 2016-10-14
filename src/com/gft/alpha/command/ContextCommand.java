package com.gft.alpha.command;

import java.lang.reflect.Field;


public class ContextCommand implements Command {

	@Override
	public void run(String commandInstruction) {
		String[] cmd = commandInstruction.split(" ");
		String fieldName = cmd[1];
		String value = cmd[2];
		switch(fieldName){
		case "ip": Context.ip = Integer.parseInt(value); break;
		case "vname": Context.vname = value; break;
		}
		
	}

	@Override
	public String getCommandNamme() {
		// TODO Auto-generated method stub
		return "set";
	}

}
