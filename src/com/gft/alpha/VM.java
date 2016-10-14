package com.gft.alpha;

import com.gft.alpha.commad.CommandManager;
import com.gft.alpha.commad.CommandProcesor;

public class VM {

	
	
	public static void main(String[] args) {
		
		if(args.length!=1){
			System.err.println("Invalid parameters");
			System.err.println("Usage: java -jar vm <command file name>");
			System.exit(1);
		}
		
		CommandManager cmdMng = new CommandManager();
		CommandProcesor cmdP  = new CommandProcesor(cmdMng);
		
		cmdP.processCommandFile(args[0]);
		
		
		loop();
	}

	private static void loop() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
