package com.cg.dao;

import java.util.Map;
import com.cg.bean.*;


//Dao layer to add ,delete and update records .


public interface OrderDAO {
	public boolean addOrder(Order o);
	public boolean updateOrder(Order o);
	public boolean deleteOrder(Order o);
	public Order findOrder(int id);
	public Map<Integer,Order> getAllOrders();
   

}
