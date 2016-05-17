package com.gaurav.hibernate.HibernateDemo7;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne
	@JoinTable(name="USER_VEHICLE_MAP", joinColumns=@JoinColumn(name="VEHICLE_ID"),inverseJoinColumns=@JoinColumn(name="USER_ID"))
	private UserDetails userDetails;
	
	public Vehicle(String vehicleName) {
		super();
		this.vehicleName = vehicleName;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
