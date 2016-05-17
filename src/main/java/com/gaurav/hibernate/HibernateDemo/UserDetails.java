package com.gaurav.hibernate.HibernateDemo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	private int id;
	@Basic
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	private String address;
	@Transient
	private String description;
	
	public UserDetails(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	
	public UserDetails(int id, String userName, Date joinedDate, String address, String description) {
		super();
		this.id = id;
		this.userName = userName;
		this.joinedDate = joinedDate;
		this.address = address;
		this.description = description;
	}


	public UserDetails() {
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

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName + ", joinedDate=" + joinedDate + ", address="
				+ address + ", description=" + description + "]";
	}
	
}
