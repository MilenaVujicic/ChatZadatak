package model;

import java.net.InetAddress;

public class Host {

	private String alias;
	private InetAddress address;

	public Host(String alias, InetAddress address) {
		super();
		this.alias = alias;
		this.address = address;
	}

	public Host() {
		super();
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public InetAddress getAddress() {
		return address;
	}

	public void setAddress(InetAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Host [alias=" + alias + ", address=" + address + "]";
	}
	
	
	
}
