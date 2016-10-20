package com.gft.alpha.commad;

public class MemoryCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		StringBuilder sb = new StringBuilder();

		int mb = 1024 * 1024;

		// Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();

		sb.append("##### Heap utilization statistics [MB] #####\n");

		// Print used memory
		sb.append("Used Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / mb).append(" MB\n");

		// Print free memory
		sb.append("Free Memory: " + runtime.freeMemory() / mb).append(" MB\n");

		// Print total available memory
		sb.append("Total Memory: " + runtime.totalMemory() / mb).append(" MB\n");

		// Print Maximum available memory
		sb.append("Max Memory: " + runtime.maxMemory() / mb).append(" MB\n");
		return sb.toString();
	}

	@Override
	public String getCommandName() {
		return "memory";
	}
	
	@Override
	public String getHelpText() {
		return "memory: Show JVM memory statistics";
	}
}
