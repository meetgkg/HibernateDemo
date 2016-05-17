package com.gaurav.hibernate.HibernateDemo9;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")
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
