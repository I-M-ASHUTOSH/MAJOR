package com.highradius.dao;

import java.util.List;

import com.highradius.pojo.Customers;


public interface CustomersDao {
	
	public List<Customers> getAllCustomers();
	public List<Customers> getCustomersById(int id);
	public List<Customers> getCustomersByCountry(String country);
	public int deleteCustomersById(int id);
	public int insertSingleCustomer(Customers customer);
	public int insertMultipleCustomer(List<Customers>customers_list);
	public int updateCustomer(int customerId,String customerName,String contactName,String country ,String address ,String city,int postalCode,int isdeleter);
}
