package com.highradius.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "orderdetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_detail_id")
	public int orderDetailsId;
	
	@OneToOne
	@JoinColumn(name= "order_id")
	public Orders order;
	
	@OneToOne
	@JoinColumn(name="product_id")
	public Products product;
	
	@Column(name="quantity")
	public int quantity;
	
	@Column(columnDefinition="int default 0")
	public int isdelete;
	public int getOrder_detail_id() {
		return orderDetailsId;
	}
	public void setOrder_detail_id(int order_detail_id) {
		this.orderDetailsId = order_detail_id;
	}
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
//	public OrderDetails(int order_details_id,Orders order,Products product,int quantity,int isdelete) {
//		this.orderDetailsId=order_details_id;
////		this.product_id=product_id;
////		this.order_id=order_id;
//		this.order=order;
//		this.product=product;
//		this.quantity=quantity;
//		this.isdelete=isdelete;
//	}
//	public OrderDetails() {
//		
//	}
	
	
	

}
