package com.gft.alpha.router;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RouterTCPServer implements Runnable {

	@Override
	public void run() {

		try {
			ServerSocket serverSocket = new ServerSocket(5002);
			
			while(true){
				Socket sc = serverSocket.accept();
				
				new RouterTCPProtocol(sc).procees();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
