package com.gaurav.hibernate.HibernateDemo10;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{
	public TwoWheeler(String vehicleName, String steeringHandle) {
		super(vehicleName);
		this.steeringHandle = steeringHandle;
	}
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
}
