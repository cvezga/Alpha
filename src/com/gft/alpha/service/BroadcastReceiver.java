package com.gft.alpha.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.gft.alpha.Context;

public class BroadcastReceiver implements AlphaService {
	
	private int port;

	@Override
	public void run() {
		
		try {
			DatagramSocket socket = new DatagramSocket(this.port, InetAddress.getByName("0.0.0.0"));
			DatagramPacket data = new DatagramPacket( new byte[512], 512);
			socket.receive(data);
			
			String dataString = new String( data.getData(), "UTF-8" );
			
			
			socket.close();
			
			processData(dataString);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	private void processData(String dataString) {
		String[] args = dataString.split(":");
		
		String masterIp = args[0];
		int masterPort = Integer.parseInt(args[1]);
		
		Context.masterIp = masterIp;
		Context.masterPort = masterPort;
		
		System.out.println("Master node set at: "+masterIp+":"+masterPort);
		
	}

	@Override
	public void init(String[] args) {
		String xport = args[2];
		this.port = Integer.parseInt(xport);
		
	}

}
