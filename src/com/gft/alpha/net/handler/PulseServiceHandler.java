package com.gft.alpha.net.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gft.alpha.Context;

public class PulseServiceHandler  implements ProtocolHandler {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH;mm;ss.sss");
	
	@Override
	public String getProtocolIdentifier() {
		return "S-PULSE-SERVICE";
	}

	@Override
	public String process(String data) {
		String[] args = data.split(":");
		String protocol = args[0];
		String vmname = args[1];
		String vmip = args[2];
		String vmport = args[3];
		String time = sdf.format(new Date());
		Context.pulseMap.put(vmname, vmname+":"+vmip+":"+vmport+":"+time);
		return "ok";
	}

}
