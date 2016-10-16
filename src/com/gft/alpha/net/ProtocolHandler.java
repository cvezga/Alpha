package com.gft.alpha.net;


public interface ProtocolHandler {

	String getProtocolIdentifier();
	
	String process(String data);
}
