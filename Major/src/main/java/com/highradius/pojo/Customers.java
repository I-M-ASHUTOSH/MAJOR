package com.highradius.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="contact_name")
	private String contactName;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="postal_code")
	private int postalCode;
	@Column(name="country")
	private String country;
	@Column(name="isdelete")
	private int isdelete;
	
//	@OneToMany(mappedBy="customer")
//	private List<Orders>orders;
//	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	

	public Customers(String country,String city,int postal_code,String address , String contact_name,String customer_name,int customer_id,int isdelete) {
		this.address=address;
		this.city=city;
		this.contactName=contact_name;
		this.country=country;
		this.customerId=customer_id;
		this.customerName=customer_name;
		this.postalCode=postal_code;
		this.isdelete=isdelete;
	}
	public Customers() {
		
	}
}
