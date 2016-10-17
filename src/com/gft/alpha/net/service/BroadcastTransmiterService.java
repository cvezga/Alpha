package com.gft.alpha.net.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.gft.alpha.Context;

public class BroadcastTransmiterService implements AlphaService {

	private String broadcastIp;
	private int portStart;
	private int portEnd;
	private long interval;
	private String message;

	/**
	private static void getip() {
		String ip;
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface iface = interfaces.nextElement();
				// filters out 127.0.0.1 and inactive interfaces
				if (iface.isLoopback() || !iface.isUp())
					continue;

				Enumeration<InetAddress> addresses = iface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress addr = addresses.nextElement();
					ip = addr.getHostAddress();
					System.out.println(iface.getDisplayName() + " " + ip);
				}
			}
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}
	}**/

	@Override
	public void run() {
		InetAddress sendAddress;
		try {

			//getip();

			sendAddress = InetAddress.getByName(broadcastIp);

			while (!isServiceProviderRegistered()) {
				for (int p = portStart; p <= portEnd; p++) {
					DatagramSocket dsock = new DatagramSocket();
					byte[] send = this.message.getBytes("UTF-8");
					DatagramPacket data = new DatagramPacket(send, send.length, sendAddress, p);
					dsock.send(data);
					System.out.println("Broadcasting "+this.message+" to "+p);
					sleep(1000);
					dsock.close();
				}

				sleep(interval);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Ended boardcast for "+message);

	}

	private boolean isServiceProviderRegistered() {
		String[] args = this.message.split(":");
		String service = args[1];
		
		return Context.serviceProviderMap.keySet().contains(service);
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void init(String[] args) {
	 
		broadcastIp = args[2];
		portStart = Integer.parseInt(args[3]);
		portEnd = Integer.parseInt(args[4]);
		interval = Integer.parseInt(args[5]);
		message = args[6];
	}

}
