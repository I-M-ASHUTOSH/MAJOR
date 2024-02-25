package com.highradius.action;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.highradius.manager.ManagerEmployees;
import com.highradius.pojo.Employees;

public class EmployeesAction {
	
	public ManagerEmployees managerDao;					//no getters and setters
	public List<Employees>employees_list;                      
	public Employees employee;
	public String message;                            //message to be returned after successfully performing CRUD operations     //only getters
	public int id;										//only setters
	
	

	public void setId(int id) {
		this.id = id;
	}

	public List<Employees> getEmployees_list() {
		return employees_list;
	}

	public void setEmployees_list(List<Employees> employees_list) {
		this.employees_list = employees_list;
	}

	

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Employees getEmployee() {
		return employee;
	}

	public String getMessage() {
		return message;
	}
		
	
	public String readAllEmployees() {
			System.out.println("hba");
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			managerDao=(ManagerEmployees) context.getBean("EmployeeManagerDaoImpl");
			String msg="error";
			message="cannot read!!!";
			try {
			employees_list= managerDao.getAllEmployees();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			if(employees_list!=null) {
				msg="success";
				message="read successfull";
			}
			
			
			((ConfigurableApplicationContext) context).close();
			return msg;
		
	}
	
	public String readEmployeesById() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao=(ManagerEmployees) context.getBean("EmployeeManagerDaoImpl");
		String msg="error";
		message="cannot read!!!";
		try {
//			System.out.println("helo"+id);
			employees_list= managerDao.getEmployeeById(id);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(employees_list!=null) {
			msg="success";
			message="read successfull";
		}
		
		((ConfigurableApplicationContext) context).close();
		return msg;
	
	}
public String updateEmployeesById() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao=(ManagerEmployees) context.getBean("EmployeeManagerDaoImpl");
		String msg="error";
		message="cannot update!!!";
		int result=0;
		try {
			result=managerDao.updateByEmployeeId(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getBirthDate(), employee.getNotes(), employee.getIsDelete());
//			System.out.println("helo"+id);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result==0) {
			msg="success";
			message="update successfull";
		}
		
		((ConfigurableApplicationContext) context).close();
		return msg;
	
	}
	
	public String deleteEmployeesById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao=(ManagerEmployees) context.getBean("EmployeeManagerDaoImpl");
		String msg="error";
		message="cannot read!!!";
		int res=0;
		try {

			managerDao.deleteByEmployeeId(id);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(res==0) {
			msg="success";
			message="delete successfull";
		}
		
		((ConfigurableApplicationContext) context).close();
		return msg;
	}
	
	
	public String insertSingleEmployee() {
		System.out.println(employee.getFirstName());
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao=(ManagerEmployees) context.getBean("EmployeeManagerDaoImpl");
		//String msg="error";
//		message="cannot read!!!";
		String s="ALREADY_PRESENT";
		message="cannot add!";
		int result=0;
		
		try {
		result=managerDao.insertSingleEmployee(employee); 
		
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
	
	public String insertMultipleEmployees() {
		
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao=(ManagerEmployees) context.getBean("EmployeeManagerDaoImpl");
		//String msg="error";
//		message="cannot read!!!";
		String s="ALREADY_PRESENT";
		message="cannot add!";
		int result=0;
		
		try {
		result=managerDao.insertMultipleEmployee(employees_list); 
		
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
	

}
