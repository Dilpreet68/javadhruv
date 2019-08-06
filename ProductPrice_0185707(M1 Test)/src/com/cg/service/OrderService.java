package com.cg.service;
import com.cg.bean.*;
import com.cg.exception.*;

public interface OrderService {
	
	
	public int calculateOrder(Order bean) throws InvalidInputException;
	

}
