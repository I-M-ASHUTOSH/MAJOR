package com.highradius.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name ="products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	@Column(name="product_name")
	private String productName;
	
	@OneToOne
	@JoinColumn(name="supplier_id")
	public Suppliers supplier;
	
	@OneToOne
	@JoinColumn(name="category_id")
	public Categories category;
	
	@Column(name="unit")
	private int unit;
	@Column(name="price")
	private int price;
	

	public int getProduct_id() {
		return productId;
	}
	public void setProduct_id(int product_id) {
		this.productId = product_id;
	}
	public String getProduct_name() {
		return productName;
	}
	public void setProduct_name(String product_name) {
		this.productName = product_name;
	}
	public Suppliers getSupplier() {
		return supplier;
	}
	public void setSupplier(Suppliers supplier) {
		this.supplier = supplier;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
//	public Products(int product_id, String product_name, int supplier_id, int category_id, int unit, int price) {
//		super();
//		this.productId = product_id;
//		this.productName = product_name;
//		this.supplierId = supplier_id;
//		this.categoryId = category_id;
//		this.unit = unit;
//		this.price = price;
//	}
	
	

}
