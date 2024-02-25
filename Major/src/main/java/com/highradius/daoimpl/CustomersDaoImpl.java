package com.highradius.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.highradius.dao.CustomersDao;
import com.highradius.pojo.Customers;
import com.highradius.pojo.Employees;

public class CustomersDaoImpl implements CustomersDao {

	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub

		List<Customers> customersList = new ArrayList<>();

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = null; // various dialect like username password are present
		Session session = null; // connect to database with no other connection to database until and unless it
								// is released
		try {
			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction(); // at one hit all rules must be performed if not then
																	// rollback all

			customersList = session.createQuery("FROM Customers").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customersList;

	}

	@Override
	public List<Customers> getCustomersById(int id) {
		// TODO Auto-generated method stub

		List<Customers> customersList = new ArrayList<>();

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = null; // various dialect like username password are present
		Session session = null; // connect to database with no other connection to database until and unless it
								// is released
		try {
//			factory = configuration.buildSessionFactory();
//			session = factory.openSession();
//			Transaction transaction = session.beginTransaction(); // at one hit all rules must be performed if not then
//																	// rollback all
//			customersList = session.createQuery("FROM Customers C where C.customerId=" + id).list();
//			System.out.println("customer list is "+customersList.size());
//			transaction.commit();
			factory= configuration.buildSessionFactory();
			session=factory.openSession();
			Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
			
			customersList =session.createQuery("FROM Customers C where C.customerId="+id).list();
			System.out.println("customer list is "+customersList.size());
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customersList;

	}

	@Override
	public List<Customers> getCustomersByCountry(String country) {
		
		// TODO Auto-generated method stub
		List<Customers> customersList = new ArrayList<>();

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = null; // various dialect like username password are present
		Session session = null; // connect to database with no other connection to database until and unless it
								// is released
		try {
			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction(); // at one hit all rules must be performed if not then
																	// rollback all
			Criteria criteria = session.createCriteria(Customers.class);

			customersList = criteria.add(Restrictions.like("country", country)).list();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customersList;

	}
	
	public int deleteCustomersById(int id) {
		
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;                         //various dialect like username password are present 
		Session session=null;                                //connect to database with no other connection to database until and unless it is released
		int result=0;
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
		
//		result=session.createQuery("DELETE FROM Employees E where E.employeeId="+id).executeUpdate();
		Customers customer= (Customers)session.get(Customers.class, id);
		customer.setIsdelete(1);
		
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	public int insertSingleCustomer(Customers customer){
		int result=0;
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;
		Session session=null;
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println(customer.getContactName());
		result=(int) session.save(customer);
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return result;
		
	}
	
	public int insertMultipleCustomer(List<Customers>customer_list) {
		int result=0;
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;
		Session session=null;
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		for(int i=0;i<customer_list.size();i++) {
			session.save(customer_list.get(i));
		} 
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return 1;
	}
	
	public int updateCustomer(int customerId,String customerName,String contactName,String country ,String address ,String city,int postalCode,int isdelete) {
		int result=0;
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;
		Session session=null;
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		 
//		Employees employee= (Employees)session.get(Employees.class, id);
//		employee.setBirthDate(birthDates);
//		employee.setFirstName(firstName);
//		employee.setLastName(lastName);
//		employee.setNotes(notes);
//		employee.setIsDelete(isdelete);
		
		Customers customer=(Customers)session.get(Customers.class, customerId);
		customer.setCustomerName(customerName);
		customer.setContactName(contactName);
		customer.setCity(city);
		customer.setAddress(address);
		customer.setCountry(country);
		customer.setIsdelete(isdelete);
		customer.setPostalCode(postalCode);
		
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return 1;
	}

}
