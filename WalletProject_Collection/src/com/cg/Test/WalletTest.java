package com.cg.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bean.Account;
import com.cg.exception.InsuffecientFundException;
import com.cg.service.AccountService;

class WalletTest {

	
	static Account ob;
	static Account ob1;
	
	
	static AccountService  service ;
	
	
	@BeforeAll  //junit4 @BeforeClass
	public static void beforeallTests()
	{
		System.out.println("Before All Tests");
		ob= new Account(109,1010101010,"Rajini",25000.00);
		ob1= new Account(110,1010101011,"Raja",25000.00);
		
		service = new AccountService();
	
	}
	
	
	
	@AfterAll  //junit4 @BeforeClass
	public static void atferallTests()
	{
		System.out.println("after All Tests");
		ob= null;
		ob1=null;
	}
	
	
	
	@Test
	void testfind() {
		
service.addAccount(ob);
		assertEquals(ob,service.findAccount((long)1010101010));
	}
	
	@Test
	void testdeposit() throws InsuffecientFundException {
		
		double oldamount=ob.getBalance();
		//System.out.println(oldamount);
		
		
		double newamount= service.Deposit(ob, 1000.00);
		//System.out.println(newamount);
		
		
		assertTrue(newamount>oldamount);
		
		assertThrows(InsuffecientFundException.class,()->service.Deposit(ob, -5));
	}
	
	
	
	@Test
	void testwithdraw()  throws InsuffecientFundException {
		
		
		double oldamount=ob.getBalance();
		
		double newamount= service.withdraw(ob, 1000.00);
		
		assertTrue(newamount<oldamount);
		assertThrows(InsuffecientFundException.class,()->service.withdraw(ob, 25000.00));
		
	}
	

	
	@Test
	void testTranserferMoney() throws InsuffecientFundException {
		
	
		double oldamount=ob.getBalance();
		double newamount=service.TransferMoney(ob, ob1, 1000.00);
		assertTrue(newamount<oldamount);
		assertThrows(InsuffecientFundException.class,()->service.TransferMoney(ob,ob1, 25000.00));
		
	}
	
	
	@Test
	void testadd() {
		
		assertEquals(true,service.addAccount(ob));
	}

	

	@Test
	void testupdate() {
		
		assertEquals(true,service.updateAccount(ob));
	}
	
	
	@Test
	void testdelete() {
		
		assertEquals(true,service.deleteAccount(ob));
	}
	
	
	
}
