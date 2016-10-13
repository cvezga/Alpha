package com.gft.alpha.service;

import java.io.IOException;
import java.net.Socket;

import com.gft.alpha.data.DataMap;
import com.gft.alpha.utils.TCPUtil;

public class QueryHandler implements Runnable {
	
	private Socket sc;
	
 
	public QueryHandler(Socket sc) {
		this.sc = sc;
	}



	@Override
	public void run() {
		
		String queryRequest = TCPUtil.readSocket(sc);
		
		int idx = queryRequest.indexOf(":");
		
		String sourceName = queryRequest.substring(idx+1);
		
		String queryResponse = DataMap.getSourceAsString(sourceName);
		
		TCPUtil.writeSocket(sc, queryResponse);
		
		try {
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
