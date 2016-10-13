package com.gft.alpha.router;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	private String vmip;

	public SocketClient(String ip) {
		this.vmip = ip;
	}

	public String getSourceData(String sourceName) {
		
		String response = null;
		
		try {
			Socket sc = new Socket(vmip, 5000);
			sc.getOutputStream().write(("query:"+sourceName+";").getBytes());
			
			byte[] buffer = new byte[512];
			
			StringBuilder sb = new StringBuilder();
			
			int len;
			while((len=sc.getInputStream().read(buffer))>0){
				sb.append(new String(buffer,0,len,"UTF-8"));
				if(sb.indexOf(";")>-1) break;
			}
			
			sc.close();
			
			response = sb.toString();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return response;
	}

}
