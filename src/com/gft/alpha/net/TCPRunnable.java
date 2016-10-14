package com.gft.alpha.net;

import java.net.Socket;

public interface TCPRunnable extends Runnable {

	void setSocket(Socket sc);
	
}
