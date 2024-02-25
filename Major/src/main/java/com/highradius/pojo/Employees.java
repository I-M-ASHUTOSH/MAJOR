package com.highradius.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	@Column(name="last_name")
	private String lastName;
	@Column(name="first_name")
	private String firstName;
	@Column(name="birth_date")
	private String birthDate;
	@Column(name="notes")
	private String notes;
	@Column(name="is_delete")
	private int isDelete;
	
//	@OneToMany(mappedBy="employee")
//	private List<Orders> orders;
//	
	public int getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Employees(String first_name,String last_name,String birth_date,String notes,int employee_id,int isdelete) {
		this.birthDate=birth_date;
		this.employeeId=employee_id;
		this.firstName=first_name;
		this.lastName=last_name;
		this.notes=notes;
		this.isDelete=isdelete;
	}
	public Employees() {
		
	}


	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", birthDate=" + birthDate + ", notes=" + notes + "]";
	}
	
	

}
