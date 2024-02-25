package com.highradius.manager;

import java.util.List;

import com.highradius.pojo.Orders;

public interface ManagerOrders {
	 public List<Orders> readAllOrders();
	 public List<Orders> readOrderById(int orderId) ;
	 public List<Orders> readOrdersByCustomerId(int customerId);
	 public List<Orders> readOrdersByEmployeeId(int employeeId);
	 public List<Orders> readOrdersByOrderDate(String orderDate) ;
	 public int updateOrderByOrderId(int orderId, String  date,int isDelete);
	 public int updateOrdersByShipperId(int shipperId, String  date);
	 public int deleteOrderByOrderId(int orderId);
	 public int deleteOrdersByCustomerId(int customerId);
	 public int deleteOrdersByEmployeeId(int employeeId);
	 public int insertOrders(Orders order) ;
}
