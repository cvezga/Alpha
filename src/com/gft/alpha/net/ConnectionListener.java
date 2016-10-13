package com.gft.alpha.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ConnectionListener implements Runnable{

	@Override
	public void run() {
		
		try {
			DatagramSocket socket = new DatagramSocket(5001, InetAddress.getByName("0.0.0.0"));
			DatagramPacket data = new DatagramPacket( new byte[512], 512);
			socket.receive(data);
			System.out.println( new String( data.getData(), "UTF-8" ) );
			socket.close();
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

	public static void main(String[] args) {
		ConnectionListener cl = new ConnectionListener();
		
		cl.run();
	}
}
