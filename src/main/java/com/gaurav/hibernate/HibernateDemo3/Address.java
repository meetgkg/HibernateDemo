package com.gaurav.hibernate.HibernateDemo3;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="STREET")
	private String street;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="PIN_CODE")
	private String pinCode;
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	public Address(String street, String city, String state, String pinCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	public Address() {
		super();
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
