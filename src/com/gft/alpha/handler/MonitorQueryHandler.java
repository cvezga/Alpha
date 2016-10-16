package com.gft.alpha.handler;

import com.gft.alpha.Context;
import com.gft.alpha.net.ProtocolHandler;
import com.gft.alpha.vo.VirtualMachine;

public class MonitorQueryHandler  implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "monitor-query";
	}

	@Override
	public String process(String data) {
		StringBuilder sb = new StringBuilder();
		for(VirtualMachine vm : Context.vmList){
			sb.append(vm.getName()).append(":").append(vm.getIp()).append("\n");
		}
		return sb.toString();
	}

}
