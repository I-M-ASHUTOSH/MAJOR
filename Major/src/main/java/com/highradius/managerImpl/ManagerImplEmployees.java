package com.highradius.managerImpl;


import java.util.List;

import com.highradius.dao.EmployeesDao;
import com.highradius.manager.ManagerEmployees;
import com.highradius.pojo.Employees;

public class ManagerImplEmployees implements ManagerEmployees {
	
	
	
	public EmployeesDao employeedao;


	public void setEmployeedao(EmployeesDao employeedao) {
		this.employeedao = employeedao;
	}

	@Override
	public List<Employees> getAllEmployees() {
		return employeedao.getAllEmployees();

	}

	@Override
	public List<Employees> getEmployeeById(int id) {
		
		return employeedao.getEmployeeById(id);
		
		
	}

	@Override
	public int updateByEmployeeId(int id,String firstName,String lastName,String birthDate,String note,int isdelete) {
		// TODO Auto-generated method stub
		
		employeedao.updateByEmployeeId(id,firstName, lastName, birthDate, note,isdelete);
		return 0;
	}

	@Override
	public int deleteByEmployeeId(int id) {
		// TODO Auto-generated method stub
		return employeedao.deleteByEmployeeId(id);

	}
	
	@Override
	public int insertSingleEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return employeedao.insertSingleEmployee(employee);
	}

	@Override
	public int insertMultipleEmployee(List<Employees>employees_list) {
		// TODO Auto-generated method stub
		return employeedao.insertMultipleEmployee(employees_list);
	
	}
	
	

}
