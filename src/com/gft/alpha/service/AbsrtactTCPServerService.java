package com.gft.alpha.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.gft.alpha.net.TCPRunnable;

public abstract class AbsrtactTCPServerService implements AlphaService {

	
	@Override
	public void run() {

		ServerSocket ssc;
		try {
			ssc = new ServerSocket(getPort());
			while (true) {
				try {

					Socket sc = ssc.accept();
					
					TCPRunnable r = getRunnable();
					
					r.setSocket(sc);

					Thread t = new Thread(r);
					t.start();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}


	abstract  TCPRunnable getRunnable();
	
	abstract  int getPort();

}
