package com.highradius.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shippers")
public class Shippers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shipper_id")
	private int shipperId;
	@Column(name="shipper_name")
	private String shipperName;
	@Column(name="phone")
	private int phone;
	
	
	public int getShipper_id() {
		return shipperId;
	}
	public void setShipper_id(int shipper_id) {
		this.shipperId = shipper_id;
	}
	public String getShipper_name() {
		return shipperName;
	}
	public void setShipper_name(String shipper_name) {
		this.shipperName = shipper_name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public Shippers(int shipper_id, String shipper_name, int phone) {
		super();
		this.shipperId = shipper_id;
		this.shipperName = shipper_name;
		this.phone = phone;
	}
	public Shippers() {
		
	}
	
	

}
