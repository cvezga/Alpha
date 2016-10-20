package com.gft.alpha.commad;

public class GCCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		System.gc();
		return "System.gc() has been called";
	}

	@Override
	public String getCommandName() {
		return "gc";
	}

	@Override
	public String getHelpText() {
		return "gc: Calls System.gc() Gabage Collector";
	}
}
