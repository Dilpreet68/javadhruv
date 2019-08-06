package com.cg.eis.dao;
import java.util.HashMap;
import com.cg.eis.Exception.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.cg.eis.bean.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
static ConcurrentMap<Integer,Employee> emmap = new ConcurrentHashMap<Integer,Employee>();
	

	@Override
	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub
		emmap.put(e.getE_id(), e);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		
        emmap.put(e.getE_id(), e);
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee e) {
		
		emmap.remove(e);
		return true;
	}

	@Override
	public Employee findEmployee(int e_id) {
		
		Employee e= emmap.get(e_id);
		return e;
	}

	@Override
	public ConcurrentMap<Integer, Employee> getAllEmployee() {
		
		return emmap;
	}

	@Override
	public String getScheme( double salary, String e_designation) throws InvalidInputException {
		
		if(((salary>=5000)&&(salary<20000))&&(e_designation.equalsIgnoreCase("System Associate")))
				{
			     return "Scheme C";
				}
		else if(((salary>=20000)&&(salary<40000))&&(e_designation.equalsIgnoreCase("Programmer")))
		{
	     return "Scheme B";
		}
		
		else if((salary>=40000)&&(e_designation.equalsIgnoreCase("Manager")))
		{
	     return "Scheme A";
		}
		
		else if((salary<5000)&&(e_designation.equalsIgnoreCase("Clerk")))
		{
	     return "No Scheme";
		}
		
		else 
		{
			throw new InvalidInputException("Salary Range is not matching with Designation of an Employee...Enter Correct Details");

	     
		}
		
	}

}
