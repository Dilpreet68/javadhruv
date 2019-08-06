package com.cg.service;

import java.util.Map;


import com.cg.bean.Order;



//include functions from dao layer and printstatement for printing output

public interface OrderDetails {
	
	public boolean addOrder(Order o);
	public boolean updateOrder(Order o);
	public boolean deleteOrder(Order o);
	public Order findOrder(int id);
	public Map<Integer,Order> getAllOrders();
	public default void printStatment(Order o)
	{
		System.out.println("=====================================");
		System.out.println("Order for Order-ID :- "+o.getId());
		System.out.println("Price :- "+o.getPrice());
		System.out.println("Quantity :- "+o.getQuantity());
		System.out.println("Amount :- INR "+o.getAmount());
		System.out.println("Total Charges  :- INR "+o.getCharges());
		System.out.println("=====================================");
	}

}
