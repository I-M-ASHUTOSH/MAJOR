package com.highradius.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private int categoryId;
	@Column(name="category_name")
	private String categoryName;
	@Column(name="description")
	private String description;
	
	
//	@OneToMany(mappedBy ="category", fetch= FetchType.EAGER)
//	private List<Products>products;
	
	
	public int getCategory_id() {
		return categoryId;
	}
	
	public void setCategory_id(int category_id) {
		this.categoryId = category_id;
	}
	public String getCategory_name() {
		return categoryName;
	}
	public void setCategory_name(String category_name) {
		this.categoryName = category_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Categories (int category_id,String category_name,String description ) {
		this.categoryId=category_id;
		this.categoryName=category_name;
		this.description=description;
	}
	
}
