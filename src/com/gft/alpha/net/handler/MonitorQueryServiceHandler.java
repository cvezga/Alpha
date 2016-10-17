package com.gft.alpha.net.handler;

import java.util.List;

import com.gft.alpha.Context;
import com.gft.alpha.utils.TCPUtil;
import com.gft.alpha.vo.ServiceProvider;

public class MonitorQueryServiceHandler  implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "Q-MONITOR-SERVICE";
	}

	@Override
	public String process(String data) {
		StringBuilder sb = new StringBuilder();
		
		
		for(String pulseData : Context.pulseMap.values()){
				
				sb.append(pulseData).append("\n");
		}
		
		sb.append(";");
		
		return sb.toString();
	}

}
