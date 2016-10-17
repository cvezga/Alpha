package com.gft.alpha.vo;

public class ServiceProvider {

	private String servece;
	private String host;
	private int port;
	
	public ServiceProvider(String servece, String host, int port) {
		super();
		this.servece = servece;
		this.host = host;
		this.port = port;
	}

	public String getServece() {
		return servece;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof ServiceProvider)) return false;
		return toString().equals(((ServiceProvider)obj).toString());
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return this.servece+":"+this.host+":"+this.port;
	}
}
