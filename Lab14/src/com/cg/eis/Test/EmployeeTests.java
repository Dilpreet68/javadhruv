package com.cg.eis.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.eis.Exception.InvalidInputException;
import com.cg.eis.bean.*;

import com.cg.eis.service.*;


class EmployeeTests {

	static Employee ob;
	static Employee ob1;
	
	
	static EmployeeServiceImpl  service ;
	
	
	@BeforeAll  //junit4 @BeforeClass
	public static void beforeallTests()
	{
		System.out.println("Before All Tests");
		ob= new Employee(10001,"Ram",4500,"Clerk","Scheme C");
	//	ob1= new Account(110,1010101011,"Raja",25000.00);
		
		service = new EmployeeServiceImpl();
	
	}
	
	
	
	@AfterAll  //junit4 @BeforeClass
	public static void atferallTests()
	{
		System.out.println("after All Tests");
		ob= null;
		//ob1=null;
	}
	
	
	
	@Test
	void testfind() {
		
         service.addEmployee(ob);
		assertEquals(ob,service.findEmployee(1001));
	}
	
	@Test
	void testScheme() throws InvalidInputException {
		
		
		assertEquals("No Scheme",service.getScheme(4500, "Clerk"));
		assertThrows(InvalidInputException.class,()->service.getScheme(5500, "Clerk"));
	}
	
	
	
	
	
	
	
	@Test
	void testadd() {
		
		assertEquals(true,service.addEmployee(ob));
	}

	

	@Test
	void testupdate() {
		
		assertEquals(true,service.updateEmployee(ob));
	}
	
	
	@Test
	void testdelete() {
		
		assertEquals(true,service.deleteEmployee(ob));
	}
	
	
}
