package com.gaurav.hibernate.HibernateDemo9;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE")
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
