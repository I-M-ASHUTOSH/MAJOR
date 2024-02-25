package com.highradius.managerImpl;

import java.util.List;

import com.highradius.dao.OrdersDao;
import com.highradius.manager.ManagerOrders;
import com.highradius.pojo.Orders;

public class ManagerImplOrders implements ManagerOrders {

	OrdersDao ordersDao;

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public List<Orders> readAllOrders() {
		// TODO Auto-generated method stub

		return ordersDao.getAllOrders();
	}

	@Override
	public List<Orders> readOrderById(int orderId) {
		// TODO Auto-generated method stub
		return ordersDao.getOrderById(orderId);
	}

	@Override
	public List<Orders> readOrdersByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return ordersDao.getOrdersByCustomerId(customerId);
	}

	@Override
	public List<Orders> readOrdersByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return ordersDao.getOrdersByEmployeeId(employeeId);
	}

	@Override
	public List<Orders> readOrdersByOrderDate(String orderDate) {
		// TODO Auto-generated method stub
		return ordersDao.getOrdersByOrderDate(orderDate);
	}

	@Override
	public int updateOrderByOrderId(int orderId, String date,int isDelete) {
		// TODO Auto-generated method stub
		return ordersDao.updateOrderByOrderId(orderId, date, isDelete);
	}

	@Override
	public int updateOrdersByShipperId(int shipperId, String date) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int deleteOrderByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return ordersDao.deleteOrderByOrderId(orderId);
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
	public int insertOrders(Orders order) {
		// TODO Auto-generated method stub

		return ordersDao.insertOrders(order);
	}

}
