package com.gaurav.hibernate.HibernateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * To illustrate column example
 * Also try @Column on field as well as Getter
 */

@Entity(name="USER_DETAILS")
public class UserDetails2 {
	@Id
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USER_NAME")
	private String userName;
	
	public UserDetails2(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	
	public UserDetails2() {
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
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName + "]";
	}
	
}
