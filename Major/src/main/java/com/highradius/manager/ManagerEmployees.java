package com.highradius.manager;

import java.util.List;

import com.highradius.pojo.Employees;

public interface ManagerEmployees {
	
	public List<Employees> getAllEmployees();
	public List<Employees> getEmployeeById(int id);
	public int updateByEmployeeId(int id,String fistName,String lastName,String birthDate,String note,int isdelete);
	public int deleteByEmployeeId(int id);
	public int insertSingleEmployee(Employees employee);
	public int insertMultipleEmployee(List<Employees>employee_list);
	
}
