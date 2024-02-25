package com.highradius.dao;

import java.util.List;

import com.highradius.pojo.Orders;

public interface OrdersDao {

	 public List<Orders> getAllOrders();
	 public List<Orders> getOrderById(int orderId) ;
	 public List<Orders> getOrdersByCustomerId(int customerId);
	 public List<Orders> getOrdersByEmployeeId(int employeeId);
	 public List<Orders> getOrdersByOrderDate(String orderDate) ;
	 public int updateOrderByOrderId(int orderId, String  date,int isDelete);
	 public int updateOrdersByShipperId(int shipperId, String  date);
	 public int deleteOrderByOrderId(int orderId);
	 public int deleteOrdersByCustomerId(int customerId);
	 public int deleteOrdersByEmployeeId(int employeeId);
	 public int insertOrders(Orders order) ;
	 
}
