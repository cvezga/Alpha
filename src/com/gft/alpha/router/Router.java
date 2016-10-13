package com.gft.alpha.router;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class Router {
	
	private static Map<String, String> sourceMap = new HashMap<>();
	
	
	public static synchronized void registerSrouce(String source, String ip){
		System.out.println("Registring: "+source+" ip: "+ip);
		sourceMap.put(source,  ip);
	}

	public void broadcast() {

		InetAddress sendAddress;
		try {
			sendAddress = InetAddress.getByName("127.0.0.1");
			DatagramSocket dsock = new DatagramSocket(5001);
			byte[] send = "Hello World".getBytes("UTF-8");
			DatagramPacket data = new DatagramPacket(send, send.length, sendAddress, 5001);
			dsock.send(data);
			dsock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Router r = new Router();
		
		r.broadcast();
	}

	public static String getSourceIp(String sourceName) {
		return sourceMap.get(sourceName);
	}

}
