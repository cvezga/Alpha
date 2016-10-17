package com.gft.alpa.service.terminal;

import java.io.IOException;
import java.net.Socket;

import com.gft.alpha.Context;
import com.gft.alpha.commad.CommandManager;
import com.gft.alpha.commad.ExitCommand;
import com.gft.alpha.utils.TCPUtil;

public class TerminalProtocol implements Runnable {
	
	private Socket sc;
	private boolean running;
	
	private CommandManager cmdMgr;

	public TerminalProtocol(Socket sc) {
		super();
		this.sc = sc;
		this.cmdMgr = CommandManager.getInstance();
	}

	
	@Override
	public void run() {
		this.running = true;
		System.out.println("Terminal connected....");
		TCPUtil.writeSocket(sc, "\nConnected to VM: "+Context.getString("vmname"));
		while(this.running){
			TCPUtil.writeSocket(sc, "\nCommand?: ");
			String input = TCPUtil.readSocket(sc,"\r\n");
			
			String[] args = input.split(" ");
			String cmd = args[0];
			
			String outcome = cmdMgr.runCommand(cmd, args);
			
			if(ExitCommand.EXIT_MESSAGE.equals(outcome)){
				break;
			}
			
			TCPUtil.writeSocket(sc, outcome);
			 
			
		}
		
		
		
		try {
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.running = false;
	}

}
