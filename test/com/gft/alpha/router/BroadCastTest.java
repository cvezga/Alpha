
package com.gft.alpha.router;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class BroadCastTest {

	public static void main(String[] args) {

		InetAddress sendAddress;
		try {

			getip();
			
			sendAddress = InetAddress.getByName("10.0.2.255");
			DatagramSocket dsock = new DatagramSocket(5001);
			byte[] send = "Alpha-ACK".getBytes("UTF-8");
			DatagramPacket data = new DatagramPacket(send, send.length, sendAddress, 5001);
			dsock.send(data);
			dsock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("DOne");

	}
	
	private static void getip(){
		 String ip;
		    try {
		        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		        while (interfaces.hasMoreElements()) {
		            NetworkInterface iface = interfaces.nextElement();
		            // filters out 127.0.0.1 and inactive interfaces
		            if (iface.isLoopback() || !iface.isUp())
		                continue;

		            Enumeration<InetAddress> addresses = iface.getInetAddresses();
		            while(addresses.hasMoreElements()) {
		                InetAddress addr = addresses.nextElement();
		                ip = addr.getHostAddress();
		                System.out.println(iface.getDisplayName() + " " + ip);
		            }
		        }
		    } catch (SocketException e) {
		        throw new RuntimeException(e);
		    }
	}

}
