package com.gaurav.hibernate.HibernateDemo10;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle{
	public FourWheeler(String vehicleName, String steeringWheel) {
		super(vehicleName);
		this.steeringWheel = steeringWheel;
	}
	
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
