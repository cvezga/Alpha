package com.gft.alpha.net.handler;

import com.gft.alpha.Context;
import com.gft.alpha.vo.VirtualMachine;

public class MonitorResponseProtocolHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "monitor-response";
	}

	@Override
	public String process(String data) {
		String[] tokens = data.split(":");
		
		if(!getProtocolIdentifier().equals(tokens[0])){
			throw new RuntimeException("Wrong protocol handler passed to "+data+" in "+getProtocolIdentifier()+" handler");
		}
		
		String name = tokens[1];
		String ip = tokens[2];
		
		VirtualMachine vm = new VirtualMachine(name,  ip);
		
		if(!Context.vmList.contains(vm)){
			Context.vmList.add(vm);
			System.out.println("Monitor register VM: "+vm.getName());
		}
		
		return "OK";
	}

}
