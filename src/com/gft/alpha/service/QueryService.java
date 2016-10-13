package com.gft.alpha.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class QueryService implements Runnable {

	@Override
	public void run() {

         while(true){
        	 try {
				ServerSocket ssc = new ServerSocket(5000);
				
				Socket sc = ssc.accept();
				
				Thread t = new Thread(new QueryHandler(sc));
				t.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
		
	}

}
