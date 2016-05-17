package com.gaurav.hibernate.HibernateDemo4;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",
		joinColumns=@JoinColumn(name="USER_ID")
	)
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long") )
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	//private Set<Address> listOfAddresses = new HashSet<Address>();
	
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
	
	/*public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}*/
	
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName + "]";
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
}
