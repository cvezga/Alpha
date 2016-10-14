package com.gft.alpha.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPUtil {

	
	public static String readSocket(Socket sc){
		
		return readSocket(sc,";");
	}

	public static void writeSocket(Socket sc, String queryResponse) {
		try {
			sc.getOutputStream().write(queryResponse.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static String readSocket(Socket sc, String finalChar) {
		String cmdLine = "";
		StringBuffer sb = new StringBuffer();
		InputStream is;
		try {
			is = sc.getInputStream();
			byte[] buffer = new byte[512];
			int length;
			while((length=is.read(buffer))>0){
				sb.append(new String(buffer,0,length,"UTF-8"));
				if(sb.toString().indexOf(finalChar)>-1) break;
			}
			cmdLine = sb.toString();
			int idx = cmdLine.lastIndexOf(finalChar);
			cmdLine = cmdLine.substring(0, idx);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return cmdLine;
		
	}
	
}
