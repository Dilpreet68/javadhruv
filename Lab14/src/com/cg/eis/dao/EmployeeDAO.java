package com.cg.eis.dao;
import com.cg.eis.Exception.InvalidInputException;
import com.cg.eis.bean.*;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public interface EmployeeDAO {
	
	
	public boolean addEmployee(Employee e);
	public boolean updateEmployee(Employee e);
	public boolean deleteEmployee(Employee e);
	public Employee findEmployee(int e_id);
	public ConcurrentMap <Integer,Employee> getAllEmployee();
    public String getScheme( double salary, String e_designation) throws InvalidInputException; 


}
