package com.gft.alpha.net.handler;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;

import com.gft.alpha.Context;
import com.gft.alpha.utils.TCPUtil;
import com.sun.javafx.collections.SortableList;

public class SubcriptionRequestProtocolHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "subcription-request";
	}

	@Override
	public String process(String data) {
		String[] tkns = data.split(":");
		
		String protocol = tkns[0];
		String sourceRequested = tkns[1];
		String ip = tkns[2];
		int port = Integer.parseInt(tkns[3]);
		
		if(Context.sourceList.contains(sourceRequested)){
			TCPUtil.send(ip, port, "subcription:"+sourceRequested+":"+Context.ip+":"+Context.port);
		}
		
		return null;
	}

}
