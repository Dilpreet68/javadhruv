package com.cg.eis.service;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.cg.eis.Exception.InvalidInputException;
import com.cg.eis.bean.*;

public interface EmployeeOperation {
	
	public boolean addEmployee(Employee e);
	public boolean updateEmployee(Employee e);
	public boolean deleteEmployee(Employee e);
	public Employee findEmployee(int e_id);
	public ConcurrentMap <Integer,Employee> getAllEmployee();
    public String getScheme( double salary, String e_designation) throws InvalidInputException; 
	

}
