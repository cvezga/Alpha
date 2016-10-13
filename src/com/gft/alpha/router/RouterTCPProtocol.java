package com.gft.alpha.router;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RouterTCPProtocol {
	
	private Socket sc;

	public RouterTCPProtocol(Socket sc) {
		this.sc = sc;
	}

	public void procees() {
		try {
			StringBuffer sb = new StringBuffer();
			InputStream is = sc.getInputStream();
			byte[] buffer = new byte[512];
			int length;
			while((length=is.read(buffer))>0){
				sb.append(new String(buffer,0,length,"UTF-8"));
				if(sb.toString().indexOf(";")>-1) break;
			}
			sc.close();
			
			process(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void process(String info) {
		info = info.replace(";", "");
		
		if(info.startsWith("register:")){
			register(info);
		}else
		if(info.startsWith("query:")){
			query(info);
		}	
		
	}

	private void query(String info) {
		info = info.substring(info.indexOf(":"+1));
		
		Query q = new Query(info);
		
		String response = q.run();
		
		try {
			this.sc.getOutputStream().write((response+";").getBytes());
			this.sc.getOutputStream().flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void register(String info) {
		String[] data = info.split(",");
		String ip = data[0];
		for(int i=1; i<data.length; i++){
			Router.registerSrouce(data[i], ip);
		}
		
	}

}
