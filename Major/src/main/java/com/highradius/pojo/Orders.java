package com.highradius.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int order_id;

	@OneToOne
	@JoinColumn(name="customer_id")
	public Customers customer;
	
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	public Employees getEmployee() {
		return employee;
	}
	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	public Shippers getShipper() {
		return shipper;
	}
	public void setShipper(Shippers shipper) {
		this.shipper = shipper;
	}


	@OneToOne
	@JoinColumn(name="employee_id")
	public Employees employee;
	
	@OneToOne
	@JoinColumn(name="shipper_id")
	public Shippers shipper;
	
	@Column(columnDefinition="int default 0")
	private int isdelete;
	
//	private int customer_id;
//	private int employee_id;
//	private int shipper_id;

	@Column(name = "order_date")
	private String order_date;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}
	
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	
	
//	public Orders() {
//		
//	}
//	public Orders(int order_id, Customers customer, Employees employee, Shippers shipper, String order_date,int isdelete) {
//		super();
//		this.order_id = order_id;
//		this.customer = customer;
//		this.employee = employee;
//		this.shipper = shipper;
//		this.order_date = order_date;
//		this.isdelete=isdelete;
//	}

}
