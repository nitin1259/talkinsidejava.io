/**
 * 
 */
package com.eci.fromtojson;

/**
 * @author nsingh
 *
 */
public class Port {
	
	private String portrack;

    private String portname;

    private String porttype;

    private String portdevicename;

    private String portshelf;

	public String getPortrack() {
		return portrack;
	}

	public void setPortrack(String portrack) {
		this.portrack = portrack;
	}

	public String getPortname() {
		return portname;
	}

	public void setPortname(String portname) {
		this.portname = portname;
	}

	public String getPorttype() {
		return porttype;
	}

	public void setPorttype(String porttype) {
		this.porttype = porttype;
	}

	public String getPortdevicename() {
		return portdevicename;
	}

	public void setPortdevicename(String portdevicename) {
		this.portdevicename = portdevicename;
	}

	public String getPortshelf() {
		return portshelf;
	}

	public void setPortshelf(String portshelf) {
		this.portshelf = portshelf;
	}

	public Port(String portrack, String portname, String porttype,
			String portdevicename, String portshelf) {
		super();
		this.portrack = portrack;
		this.portname = portname;
		this.porttype = porttype;
		this.portdevicename = portdevicename;
		this.portshelf = portshelf;
	}

	@Override
	public String toString() {
		return "Port [portrack=" + portrack + ", portname=" + portname
				+ ", porttype=" + porttype + ", portdevicename="
				+ portdevicename + ", portshelf=" + portshelf + "]";
	}

}
