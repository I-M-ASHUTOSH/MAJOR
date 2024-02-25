package com.highradius.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.highradius.manager.ManagerCustomers;
import com.highradius.manager.ManagerEmployees;
import com.highradius.pojo.Customers;

public class CustomersAction {

	public ManagerCustomers managerDao;					//no getters and setters
	public List<Customers>customers_list;                      
	public Customers customer;
	public String message;                            //message to be returned after successfully performing CRUD operations     //only getters
	public int id;										//only setters
	public String country;
	
	
	public List<Customers> getCustomers_list() {
		return customers_list;
	}

	public void setCustomers_list(List<Customers> customers_list) {
		this.customers_list = customers_list;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public String getMessage() {
		return message;
	}

	
	public void setid(int id) {
		this.id = id;
	}
	public int getid() {
		return id;
	}

	

	public void setCountry(String country) {
		this.country = country;
	}

	public String readAllCustomers() {
		System.out.println("he");
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			managerDao=(ManagerCustomers) context.getBean("CustomerManagerDaoImpl");
			String msg="error";
			message="cannot read!!!";
			try {
				customers_list= managerDao.getAllCustomers();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			if(customers_list!=null) {
				msg="success";
				message="read successfull";
			}
			
			
			return msg;
		
	}
	
	public String readCustomersById() {
		System.out.println(id);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao=(ManagerCustomers) context.getBean("CustomerManagerDaoImpl");
		String msg="error";
		message="cannot read!!!";
		try {
//			System.out.println("helo"+id);
			customers_list= managerDao.getCustomersById(id);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("heloo"+customers_list.size());
		if(customers_list!=null) {
			msg="success";
			message="read successfull";
		}
		
		((ConfigurableApplicationContext) context).close();
		return msg;
	
	}
	
public String readCustomersByCountry() {
		System.out.println(country);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao=(ManagerCustomers) context.getBean("CustomerManagerDaoImpl");
		String msg="error";
		message="cannot read!!!";
		try {
//			System.out.println("helo"+id);
			customers_list= managerDao.getCustomersByCountry(country);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(customers_list!=null) {
			msg="success";
			message="read successfull";
		}
		
		((ConfigurableApplicationContext) context).close();
		return msg;
	
	}

	
public String deleteCustomersById() {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	managerDao=(ManagerCustomers) context.getBean("CustomerManagerDaoImpl");
	String msg="error";
	message="cannot delete!!!";
	int result=0;
	try {
//		System.out.println("helo"+id);
		result= managerDao.deleteCustomersById(id);
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	if(result==0) {
		msg="success";
		message="delete successfull";
	}
	
	((ConfigurableApplicationContext) context).close();
	return msg;
}


public String insertSingleCustomer() {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	managerDao=(ManagerCustomers) context.getBean("CustomerManagerDaoImpl");
	String msg="error";
	message="cannot insert!!!";
	int result=0;
	try {
		System.out.println("helo"+customer.getContactName());
		result= managerDao.insertSingleCustomer(customer);
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	if(result>0) {
		msg="success";
		message="insert successfull";
	}
	
	((ConfigurableApplicationContext) context).close();
	return msg;
}


public String insertMultipleCustomer() {
	System.out.println("bhbafv");
	ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
	managerDao=(ManagerCustomers) context.getBean("CustomerManagerDaoImpl");
	//String msg="error";
//	message="cannot read!!!";
	String s="ALREADY_PRESENT";
	message="cannot add!";
	int result=0;
	System.out.println(customers_list.get(0).getContactName());
	System.out.println(customers_list.get(0).getCustomerName());
	System.out.println(customers_list.get(0).getPostalCode());
	
	
	try {
	result=managerDao.insertMultipleCustomer(customers_list); 
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	if(result>0) {
		s="ADDED";
		message="sucessfully added!!";
	}
	
	System.out.println(message);
	((ConfigurableApplicationContext) context).close();
	return s;
	
}

public String updateCustomer() {
	System.out.println("Helo"+customer.getCustomerId());
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	managerDao=(ManagerCustomers) context.getBean("CustomerManagerDaoImpl");
	String msg="error";
	message="cannot update!!!";
	int result=0;
	try {
//		System.out.println("helo"+id);
		result= managerDao.updateCustomer(customer.getCustomerId(),customer.getCustomerName(),customer.getContactName(),customer.getCountry(),customer.getAddress(),customer.getCity(),customer.getPostalCode(),customer.getIsdelete());
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	if(result>0) {
		msg="success";
		message="update successfull";
	}
	
	((ConfigurableApplicationContext) context).close();
	return msg;
}
		
}
