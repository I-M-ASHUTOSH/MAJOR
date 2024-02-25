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
@Table(name="suppliers")

public class Suppliers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private int supplierId;
	@Column(name = "supplier_name")
	private String supplierName;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "postal_code")
	private int postalCode;
	@Column(name = "country")
	private String country;
	@Column(name = "phone")
	private int phone;
	
	
//	@OneToMany(mappedBy = "supplier")
//	private List<Products> products;
	
	public int getSupplier_id() {
		return supplierId;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplierId = supplier_id;
	}
	public String getSupplier_name() {
		return supplierName;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplierName = supplier_name;
	}
	public String getContact_name() {
		return contactName;
	}
	public void setContact_name(String contact_name) {
		this.contactName = contact_name;
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
	public int getPostal_code() {
		return postalCode;
	}
	public void setPostal_code(int postal_code) {
		this.postalCode = postal_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	public Suppliers(int supplier_id, String supplier_name, String contact_name, String address, String city,
			int postal_code, String country, int phone) {
		super();
		this.supplierId = supplier_id;
		this.supplierName = supplier_name;
		this.contactName = contact_name;
		this.address = address;
		this.city = city;
		this.postalCode = postal_code;
		this.country = country;
		this.phone = phone;
	}

	
	
}
