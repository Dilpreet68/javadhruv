package com.cg.dao;

import java.util.HashMap;
import java.util.Map;


import com.cg.bean.Order;


//implements Function of Dao Layer

public class OrderDAOImpl implements OrderDAO {

	static Map<Integer,Order> ordermap = new HashMap<Integer,Order>();
	
	@Override
	public boolean addOrder(Order o) {
		// TODO Auto-generated method stub
		ordermap.put(o.getId(), o);
		return true;
	}

	@Override
	public boolean updateOrder(Order o) {
		// TODO Auto-generated method stub
		 int id=o.getId();
	        ordermap.put(id, o);
	        //Override previous value in ordermap
			return true;
	}

	@Override
	public boolean deleteOrder(Order o) {
		// TODO Auto-generated method stub
		ordermap.remove(o);
		return true;
	}

	@Override
	public Order findOrder(int id) {
		// TODO Auto-generated method stub
		Order O= ordermap.get(id);
		return O;
		
	}

	@Override
	public Map<Integer, Order> getAllOrders() {
		// TODO Auto-generated method stub
		return ordermap;
	}

	
}
