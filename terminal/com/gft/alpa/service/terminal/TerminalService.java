package com.gft.alpa.service.terminal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.gft.alpha.Context;
import com.gft.alpha.net.service.AlphaService;

public class TerminalService implements AlphaService {

	private int port;
	private boolean running;

	@Override
	public void init(String[] args) {
		this.port = Context.getInteger("terminalPort");

	}

	@Override
	public void run() {
		this.running = true;

		ServerSocket ssc;
		try {
			ssc = new ServerSocket(this.port);
			System.out.println("Terminal service listening to port "+this.port);
			while (this.running) {

				try {

					Socket sc = ssc.accept();
					Thread t = new Thread(new TerminalProtocol(sc));
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

}
