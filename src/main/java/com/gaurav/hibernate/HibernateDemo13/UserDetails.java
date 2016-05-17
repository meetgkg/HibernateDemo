package com.gaurav.hibernate.HibernateDemo13;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where id = ? ")
@NamedNativeQuery(name = "UserDetails.byName", query = "SELECT * FROM USER_DETAILS WHERE USERNAME = ? ", resultClass=UserDetails.class)
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	
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
