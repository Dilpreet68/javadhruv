package com.cg.eis.service;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.cg.eis.Exception.InvalidInputException;
import com.cg.eis.bean.Employee;
import com.cg.eis.dao.*;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao = new EmployeeDAOImpl();
	@Override
	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return dao.addEmployee(e);
	}

	@Override
	public boolean updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(e);
	}

	@Override
	public boolean deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(e);
	}

	@Override
	public Employee findEmployee(int e_id) {
		// TODO Auto-generated method stub
		return dao.findEmployee(e_id);
	}

	@Override
	public ConcurrentMap<Integer, Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllEmployee();
	}

	@Override
	public String getScheme( double salary, String e_designation) throws InvalidInputException {
		// TODO Auto-generated method stub
		return dao.getScheme( salary, e_designation);
	}

	
	
}
