package com.cg.pl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.cg.bean.*;
import com.cg.exception.InvalidInputException;
import com.cg.service.*;


import com.cg.service.Validator;

public class MyOrder {

	public static void main(String[] args) throws IOException, InvalidInputException {
		// TODO Auto-generated method stub

		double price=0.0;
		int quantity=0;
		OrderImpl service= new OrderImpl ();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String choice="";
		
		
			while(true)
			{
			System.out.println("Menu");
			System.out.println("========================");
			System.out.println("1 Book Order");//Get order details after validation ,then calculate amount and charges, then display
			System.out.println("2 Print All Orders");//Display all records
			System.out.println("3 Exit");//To Exit
			System.out.println("Enter your choice");
			choice=br.readLine();
			
		
		
			switch(choice)
			{
			case "1":
					  
					  
					  //Accepting and validating input for Order Price.......
					  System.out.println("Enter Order Price in Dollar ");
					  while(true)
					  {
						  String s_price=br.readLine();
						  boolean ch1=Validator.validatedata(s_price, Validator.pricepattern);
						  if(ch1==true)
						  {
							  try {
								  price=Double.parseDouble(s_price);
								  break;
							  }
							  catch(NumberFormatException e)
						  
						  {
							 System.out.println("Price must be numeric. Re Enter"); 
						  }
					  }
						  else
						  {
							  System.out.println("Re Enter Price..Numeric and Positive  ");
						  }
					  
					  }//end of while
					 
					  //Accepting and validating input for Quantity
					  System.out.println("Enter Order Quantity");
					  while(true)
					  {
						  String s_quantity=br.readLine();
						  boolean ch1=Validator.validatedata(s_quantity, Validator.quantitypattern);
						  if(ch1==true)
						  {
							  try {
								  quantity=Integer.parseInt(s_quantity);
								  break;
							  }
							  catch(NumberFormatException e)
						  
						  {
							 System.out.println("Quantity must be numeric. Re Enter"); 
						  }
					  }
						  else
						  {
							  System.out.println("Re Enter Quantity ..Numeric and Positive");
						  }
					  
					  }//end of Quantity validation
					  
					
					 Order o=new Order(price,quantity); //Adding data
					 int Id=service.calculateOrder(o);
					 Id=service.saveOrder(o);
					 
					 
				      
					  System.out.println("Order with ID = "+Id+" Saved Successfully ");
					  service.printStatment(o);
					  
					  break;
			     	
		    case "2"://print all accounts
		    	     
		    	     Map <Integer,Order> ordermap=service.getAllOrders();
		    	     Collection<Order> vc = ordermap.values();
		    	     List<Order> orderlist=new ArrayList<Order>(vc);
		    	     Collections.sort(orderlist);
		    	     Iterator <Order> itr = orderlist.iterator();  
		    	       //Returns true if there are more number of elements.  
		    	        while(itr.hasNext()) {  
		    	       //Returns the next element.  
		    	        	service.printStatment(itr.next());
		    	       } 
		    	    
				     break;
		   
			case "3":
				     System.out.println("Exiting Program");
				     System.exit(0);
				     break;
		    default:
		    	    System.out.println("Invalid choice");
			
			
			
			
			
			}
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	}}
