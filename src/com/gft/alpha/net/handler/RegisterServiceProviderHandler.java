package com.gft.alpha.net.handler;

import java.util.ArrayList;
import java.util.List;

import com.gft.alpha.Context;
import com.gft.alpha.vo.ServiceProvider;

public class RegisterServiceProviderHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "REGISTER-SERVICE";
	}

	@Override
	public String process(String data) {
		String[] tkns = data.split(":");
		
		String protocol = tkns[0];
		String service = tkns[1];
		String ip = tkns[2];
		int port  = Integer.parseInt(tkns[3]);
		
		List<ServiceProvider> spList = Context.serviceProviderMap.get(service);
		if(spList==null){
			spList = new ArrayList<>();
			Context.serviceProviderMap.put(service, spList);
		}
		
		ServiceProvider sp  = new ServiceProvider(service, ip, port);
		
		if(!spList.contains(sp)){
			spList.add(sp);
			System.out.println("Registered service provider: "+sp.toString());
		}
		
		return "RegisterServiceProviderHandler: OK";
	}

}
