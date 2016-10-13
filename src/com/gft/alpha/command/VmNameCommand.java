package com.gft.alpha.command;

import com.gft.alpha.Context;

public class VmNameCommand implements Command {

	@Override
	public void run(String commandInstruction) {
		String vmname = commandInstruction.split(" ")[1];
		Context.vmname = vmname;
		System.out.println("VM-NAME: "+vmname);
	}

}
