package com.gaurav.hibernate.HibernateDemo3;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="HOME_STREET")),
		@AttributeOverride(name="city",column=@Column(name="HOME_CITY")),
		@AttributeOverride(name="state",column=@Column(name="HOME_STATE")),
		@AttributeOverride(name="pinCode",column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	public UserDetails(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	
	public UserDetails() {
	}
	
	public UserDetails(String userName) {
		this.userName = userName;
	}
	
	public UserDetails(String userName, Address homeAddress, Address officeAddress) {
		super();
		this.userName = userName;
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName + "]";
	}
	
}
