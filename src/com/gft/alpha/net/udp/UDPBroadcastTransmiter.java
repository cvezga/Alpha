package com.gft.alpha.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPBroadcastTransmiter {
	
	private String broadcastIp;
	private int portStart;
	private int portEnd;
	private String message;

	
	public UDPBroadcastTransmiter(String broadcastIp, int portStart, int portEnd, String message) {
		super();
		this.broadcastIp = broadcastIp;
		this.portStart = portStart;
		this.portEnd = portEnd;
		this.message = message;
	}

	
	public void TransmitData() {
		InetAddress sendAddress;
		try {

			sendAddress = InetAddress.getByName(broadcastIp);

			for (int p = portStart; p <= portEnd; p++) {
				DatagramSocket dsock = new DatagramSocket();
				byte[] send = this.message.getBytes("UTF-8");
				DatagramPacket data = new DatagramPacket(send, send.length, sendAddress, p);
				dsock.send(data);
				dsock.close();
				sleep(100);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	

}
