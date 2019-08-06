package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bean.*;

import com.cg.exception.InvalidInputException;
import com.cg.service.*;




class OrderTests {
	
	
	static Order ob;
	static Order ob1;
	static int id1=0,id2=0;
	
	
	static OrderImpl  service ;
	
	
	@BeforeAll  //junit4 @BeforeClass
	public static void beforeallTests() throws InvalidInputException
	{
		System.out.println("Before All Tests");
		ob= new Order(1.0,2);//price and quantity
		ob1=new Order(-5,-5);//for checking Exception
		
		service = new OrderImpl();
		id1 = service.calculateOrder(ob);
		id2= service.saveOrder(ob);
	
	}
	
	
	
	@AfterAll  //junit4 @BeforeClass
	public static void atferallTests()
	{
		System.out.println("after All Tests");
		ob= null;
		ob1=null;
		
	}
	
	
	
	
	//testing addOrder of OrderImpl class
	@Test
	void testadd() {
		
		assertEquals(true,service.addOrder(ob));
	}

	
	//testing updateOrder of OrderImpl class
	@Test
	void testupdate() {
		
		assertEquals(true,service.updateOrder(ob));
	}
	
	//testing deleteOrder of OrderImpl class
	@Test
	void testdelete() {
		
		assertEquals(true,service.deleteOrder(ob));
	}
	
	
	//testing calculateOrder of OrderImpl class
	@Test
	void testcalculateOrder() throws InvalidInputException {
		
		//checking calculateOrder in service layer
		assertEquals(id1,service.calculateOrder(ob));
		
		//Checking Exception
		assertThrows(InvalidInputException.class,()->service.calculateOrder(ob1));
	}
	
	//testing saveOrder of OrderImpl class
	@Test
	void testsaveOrder() {
		
		assertEquals(id2,service.saveOrder(ob));
	}
	
	
	
}
