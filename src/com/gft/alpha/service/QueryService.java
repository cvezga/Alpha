package com.gft.alpha.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class QueryService implements AlphaService {

	private int port;

	@Override
	public void run() {

		ServerSocket ssc;
		try {
			ssc = new ServerSocket(this.port);
			while (true) {
				try {

					Socket sc = ssc.accept();

					Thread t = new Thread(new QueryHandler(sc));
					t.start();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void init(String[] args) {
		String xport = args[2];
		this.port = Integer.parseInt(xport);

	}

}
