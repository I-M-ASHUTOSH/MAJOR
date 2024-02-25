package com.highradius.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.highradius.manager.ManagerCustomers;
import com.highradius.manager.ManagerEmployees;
import com.highradius.manager.ManagerOrders;
import com.highradius.pojo.Employees;
import com.highradius.pojo.Orders;

public class OrdersAction {

	public ManagerOrders managerDao; // no getters and setters
	public List<Orders> orders_list;
	public Orders order;
	public String message; // message to be returned after successfully performing CRUD operations //only
							// getters
	public int id; // only setters

	public void setId(int id) {
		this.id = id;
	}

	public List<Orders> getOrders_list() {
		return orders_list;
	}

	public void setOrders_list(List<Orders> orders_list) {
		this.orders_list = orders_list;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Orders getOrder() {
		return order;
	}

	public String getMessage() {
		return message;
	}

	public String readAllOrders() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao = (ManagerOrders) context.getBean("ordersManager");
		System.out.println("hba");

		String msg = "error";
		message = "cannot read!!!";
		try {
			orders_list = managerDao.readAllOrders();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (orders_list != null) {
			msg = "success";
			message = "read successfull";
		}

		((ConfigurableApplicationContext) context).close();
		return msg;

	}

	public String readOrdersByCustomerId() {
		System.out.println("hba");
		String msg = "error";
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao = (ManagerOrders) context.getBean("ordersManager");
		message = "cannot read!!!";
		try {
			orders_list = managerDao.readOrdersByCustomerId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (orders_list != null) {
			msg = "success";
			message = "read successfull";
		}

		((ConfigurableApplicationContext) context).close();
		return msg;

	}

	public String readOrdersById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao = (ManagerOrders) context.getBean("ordersManager");
		String msg = "error";
		message = "cannot read!!!";
		try {
//			System.out.println("helo"+id);
			orders_list = managerDao.readOrderById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (orders_list != null) {
			msg = "success";
			message = "read successfull";
		}

		((ConfigurableApplicationContext) context).close();
		return msg;

	}

	public String readOrdersByEmployeeId() {
		System.out.println(id);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao = (ManagerOrders) context.getBean("ordersManager");
		String msg = "error";
		message = "cannot read!!!";
		try {
			orders_list = managerDao.readOrdersByEmployeeId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (orders_list != null) {
			msg = "success";
			message = "read successfull";
		}

		((ConfigurableApplicationContext) context).close();
		return msg;

	}

	public String insertSingleOrder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao = (ManagerOrders) context.getBean("ordersManager");
		// String msg="error";
//		message="cannot read!!!";
		String s = "ALREADY_PRESENT";
		message = "cannot add!";
		int result = 0;

		try {
			result = managerDao.insertOrders(order);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			s = "ADDED";
			message = "sucessfully added!!";
		}

		System.out.println(message);
		((ConfigurableApplicationContext) context).close();
		return s;

	}
	
	public String deleteOrderById()
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao = (ManagerOrders) context.getBean("ordersManager");
		// String msg="error";
//		message="cannot read!!!";
		String s = "ALREADY_DELETED";
		message = "cannot delete!";
		int result = 0;

		try {
			result = managerDao.deleteOrderByOrderId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			s = "DELETED";
			message = "sucessfully deleted!!";
		}

		System.out.println(message);
		((ConfigurableApplicationContext) context).close();
		return s;
		
		
	}
	
	public String updateOrderById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		managerDao = (ManagerOrders) context.getBean("ordersManager");
		String msg="error";
		message="cannot update!!!";
		int result=0;
		try {
			
			result= managerDao.updateOrderByOrderId(order.getOrder_id(), order.getOrder_date(), order.getIsdelete());
			System.out.println("helo"+order.getOrder_id());
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
