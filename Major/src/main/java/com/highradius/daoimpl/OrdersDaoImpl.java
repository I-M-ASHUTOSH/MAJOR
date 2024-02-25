package com.highradius.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.highradius.dao.OrdersDao;
import com.highradius.pojo.Customers;
import com.highradius.pojo.Orders;

public class OrdersDaoImpl implements OrdersDao{

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
			
		List<Orders> ordersList=new ArrayList<>();
		
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;                         //various dialect like username password are present 
		Session session=null;                                //connect to database with no other connection to database until and unless it is released
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
		
		ordersList =session.createQuery("FROM Orders").list();
		transaction.commit();
		session.close();
		factory.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return ordersList;

	}

	@Override
	public List<Orders> getOrderById(int orderId) {
		// TODO Auto-generated method stub
		List<Orders> ordersList=new ArrayList<>();
		
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;                         //various dialect like username password are present 
		Session session=null;                                //connect to database with no other connection to database until and unless it is released
		try {
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
		
		ordersList =session.createQuery("FROM Orders O where O.order_id="+orderId).list();
		transaction.commit();
		session.close();
		factory.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return ordersList;

		
		
	}

	@Override
	public List<Orders> getOrdersByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		
			List<Orders> ordersList=new ArrayList<>();
	        Configuration configuration= new Configuration ();
			configuration.configure("hibernate.cfg.xml");
			SessionFactory factory=null;                         //various dialect like username password are present 
			Session session=null;                                //connect to database with no other connection to database until and unless it is released
			
	        try {
	        	factory= configuration.buildSessionFactory();
				session=factory.openSession();
				Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
				
	            String hql = "from Orders where customer.id = :customerId";
	            ordersList=session.createQuery(hql).setParameter("customerId", customerId).list();
	            transaction.commit();
	    		session.close();
	    		factory.close();
	        } catch (Exception e) {
	        	e.printStackTrace();
	        
	        }

		
		return ordersList;
	}

	@Override
	public List<Orders> getOrdersByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		List<Orders> ordersList=new ArrayList<>();
        Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;                         //various dialect like username password are present 
		Session session=null;              
		
        try{
        	factory= configuration.buildSessionFactory();
			session=factory.openSession();
			Transaction transaction=session.beginTransaction();   
            String hql = "from Orders where employee.id = :employeeId";
            ordersList=session.createQuery(hql).setParameter("employeeId", employeeId).list();
            transaction.commit();
    		session.close();
    		factory.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }

		
		
		return ordersList;
	}

	@Override
	public List<Orders> getOrdersByOrderDate(String orderDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOrderByOrderId(int orderId, String date,int isDelete) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;
		Session session=null;
		int result=0;
		try {
			factory= configuration.buildSessionFactory();
			session=factory.openSession();
			Transaction transaction=session.beginTransaction();        
			System.out.println(orderId);
			Orders order=(Orders)session.get(Orders.class, orderId);
			System.out.println("Helo"+order.getOrder_date());
			order.setIsdelete(isDelete);
			order.setOrder_date(date);
			 transaction.commit();
	    		result=1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateOrdersByShipperId(int shipperId, String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrderByOrderId(int orderId) {
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
		Orders order= (Orders)session.get(Orders.class, orderId);
		order.setIsdelete(1);
		result=1;
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int deleteOrdersByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrdersByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	 public int insertOrders(Orders order){
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
		
		session.save(order.getCustomer());
		session.save(order.getEmployee());
		session.save(order.getShipper());
		
		result=(int) session.save(order);
		transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
				factory.close();
			}
		}
		
		
		return result;
        
	}


	
	
	
}
