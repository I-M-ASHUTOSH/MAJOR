package com.highradius.managerImpl;

import java.util.List;

import com.highradius.dao.CustomersDao;
import com.highradius.dao.EmployeesDao;
import com.highradius.manager.ManagerCustomers;
import com.highradius.pojo.Customers;

public class ManagerImplCustomers implements ManagerCustomers  {

	
	public CustomersDao customerdao;
	
	public CustomersDao getCustomerdao() {
		return customerdao;
	}

	public void setCustomerdao(CustomersDao customerdao) {
		this.customerdao = customerdao;
	}
	
	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerdao.getAllCustomers();
		
	}

	@Override
	public List<Customers> getCustomersById(int id) {
		// TODO Auto-generated method stub
		
		return customerdao.getCustomersById(id);
		
		
	}

	@Override
	public List<Customers> getCustomersByCountry(String Country) {
		// TODO Auto-generated method stub
		return customerdao.getCustomersByCountry(Country);
			
	}
	
	public int deleteCustomersById(int id) {
		return customerdao.deleteCustomersById(id);
	}

	public int insertSingleCustomer(Customers customer) {
		System.out.println("he");
		System.out.println(customer.getContactName());
		
		return customerdao.insertSingleCustomer(customer);
	}
	
	public int insertMultipleCustomer(List<Customers> customers_list) {
		return customerdao.insertMultipleCustomer(customers_list);
	}
	
	public int updateCustomer(int customerId,String customerName,String contactName,String country ,String address ,String city,int postalCode,int isdelete) {
		return customerdao.updateCustomer(customerId,customerName,contactName,country ,address ,city,postalCode,isdelete);
	}
}
