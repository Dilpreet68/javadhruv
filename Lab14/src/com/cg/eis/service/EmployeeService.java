package com.cg.eis.service;

import com.cg.eis.bean.*;

public interface EmployeeService extends EmployeeOperation {
	
	 
	
	public default void printEmployeedetails(Employee e)
	{
		System.out.println("=====================================");
		System.out.println("Details for Employee ID. :-"+e.getE_id());
		System.out.println("Employee Name :- "+e.getE_name());
		System.out.println("Employee Salary :- "+e.getE_salary());
		System.out.println("Employee Designation :- "+e.getE_designation());
		
	}
	
	

}
