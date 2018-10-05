/**
 * 
 */
package com.airtel.test;

/**
 * @author nsingh
 *
 */
public class Address {

	private String houseNo;
	private String address1;
	private String address2;
	
	
	public Address(String houseNo, String address1, String address2) {
		super();
		this.houseNo = houseNo;
		this.address1 = address1;
		this.address2 = address2;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	
}
