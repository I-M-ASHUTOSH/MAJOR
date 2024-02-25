package com.highradius.dao;


import java.util.List;

import com.highradius.pojo.Employees;

public interface EmployeesDao {

	public List<Employees> getAllEmployees();
	public List<Employees> getEmployeeById(int id);
	public int updateByEmployeeId(int id,String firstName,String lastName,String birthDates,String notes,int isdelete);
	public int deleteByEmployeeId(int id);
	public int insertSingleEmployee(Employees employee);
	public int insertMultipleEmployee(List<Employees>employee_list);
}
