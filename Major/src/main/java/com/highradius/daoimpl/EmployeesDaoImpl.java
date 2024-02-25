package com.highradius.daoimpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.highradius.dao.EmployeesDao;
import com.highradius.pojo.Employees;

public class EmployeesDaoImpl implements EmployeesDao {

	@Override
	public List<Employees> getAllEmployees() {
		
		List<Employees> employeesList=new ArrayList<>();
		
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;                         //various dialect like username password are present 
		Session session=null;                                //connect to database with no other connection to database until and unless it is released
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
		
		employeesList =session.createQuery("FROM Employees").list();
		transaction.commit();
		session.close();
		factory.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return employeesList;
		
	}

	@Override
	public List<Employees> getEmployeeById(int id) {
		List<Employees>employeesList=new ArrayList<>();
		
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;                         //various dialect like username password are present 
		Session session=null;                                //connect to database with no other connection to database until and unless it is released
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
		
		employeesList =session.createQuery("FROM Employees E where E.employeeId="+id).list();
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return employeesList;
	}

	@Override
	public int updateByEmployeeId(int id,String firstName,String lastName,String birthDates,String notes,int isdelete) {
		// TODO Auto-generated method stub
		
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;                         //various dialect like username password are present 
		Session session=null;                                //connect to database with no other connection to database until and unless it is released
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
		System.out.println(firstName+" "+lastName);
		Employees employee= (Employees)session.get(Employees.class, id);
		employee.setBirthDate(birthDates);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setNotes(notes);
		employee.setIsDelete(isdelete);
		
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	@Override
	public int insertSingleEmployee(Employees employee) {
		
		int result=0;
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;
		Session session=null;
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		result=(int) session.save(employee);
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

	
	
	@Override
	public int insertMultipleEmployee(List<Employees>employee_list) {
		// TODO Auto-generated method stub
		int result=0;
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;
		Session session=null;
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		for(int i=0;i<employee_list.size();i++) {
			session.save(employee_list.get(i));
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

	public int deleteByEmployeeId(int id) {
		// TODO Auto-generated method stub
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
		Employees employee= (Employees)session.get(Employees.class, id);
		employee.setIsDelete(1);
		
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	
	
	

	
}
