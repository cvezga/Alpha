package com.gft.alpha.net.handler;


public interface ProtocolHandler {

	String getProtocolIdentifier();
	
	String process(String data);
}
