package com.gft.alpha.vo;

public class VirtualMachine {

	private String name;
	private String ip;

	public VirtualMachine(String name, String ip) {
		super();
		this.name = name;
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof VirtualMachine)) return false;
		VirtualMachine vm = (VirtualMachine)obj;
		return this.name.equals(vm.getName());
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
