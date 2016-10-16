package com.gft.alpha.net.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.gft.alpha.net.handler.TCPServerHandler;

public class TCPServerService implements AlphaService {

	
	private int port;
	
	@Override
	public void run() {

		ServerSocket ssc;
		try {
			ssc = new ServerSocket(this.port);
			while (true) {
				try {

					Socket sc = ssc.accept();
					
					TCPServerHandler h = new TCPServerHandler(sc);
					
					Thread t = new Thread(h);
					t.start();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}



	@Override
	public void init(String[] args) {
		this.port = Integer.parseInt(args[2]);
		
	}

}
