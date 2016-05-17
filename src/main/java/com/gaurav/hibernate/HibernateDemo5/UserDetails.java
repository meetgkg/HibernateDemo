package com.gaurav.hibernate.HibernateDemo5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	
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
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName + "]";
	}

}
