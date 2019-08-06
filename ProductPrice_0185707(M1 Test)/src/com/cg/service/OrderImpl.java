package com.cg.service;

import java.util.Map;

import com.cg.bean.Order;
import com.cg.dao.*;
import com.cg.exception.InvalidInputException;

//implements function from all interfaces

public class OrderImpl implements OrderRepo,OrderService,OrderDetails {
	
	
	OrderDAO dao=new OrderDAOImpl();

	@Override
	public boolean addOrder(Order o) {
		// TODO Auto-generated method stub
		//calling dao layer function
		return dao.addOrder(o);
	}

	@Override
	public boolean updateOrder(Order o) {
		// TODO Auto-generated method stub
		//calling dao layer function
		return dao.updateOrder(o);
	}

	@Override
	public boolean deleteOrder(Order o) {
		// TODO Auto-generated method stub
		//calling dao layer function
		return dao.deleteOrder(o);
	}

	@Override
	public Order findOrder(int id) {
		// TODO Auto-generated method stub
		//calling dao layer function
		return dao.findOrder(id);
	}

	@Override
	public Map<Integer, Order> getAllOrders() {
		// TODO Auto-generated method stub
		//calling dao layer function
		return dao.getAllOrders();
	}

	
	@Override
	public int saveOrder(Order bean) {
		// TODO Auto-generated method stub
		//calling dao layer function
		
		dao.addOrder(bean);
		return bean.getId();
	}

	@Override
	public int calculateOrder(Order bean) throws InvalidInputException {//Exception occurs when price or quantity is negative
		// TODO Auto-generated method stub
		
		if(bean.getPrice()<0||bean.getQuantity()<0)
		{
			throw new InvalidInputException("Enter Valid Inputs only");
		}
		
		Double amount=bean.getPrice()*75*bean.getQuantity();//price*Quantity*75(to change into INR)
		Double charges=amount+amount*1.25/100;//1.25% of total amount
		bean.setAmount(amount);
		bean.setCharges(charges);
		dao.addOrder(bean);
		
		
		
		
		return bean.getId();
	}

	
	
	
	
}
