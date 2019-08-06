package com.cg.eis.pl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cg.eis.Exception.InvalidInputException;
import com.cg.eis.bean.*;
import com.cg.eis.service.*;

public class EmployeeData {
	//Made by Er. Dilpreet kaur
	

	public static void main(String[] args) throws IOException, InvalidInputException {
		// TODO Auto-generated method stub

		int e_id=0;
		String e_name="";
		 double e_salary=0L;
		 String e_designation="";
	    String e_insurance_scheme="";
	    String input="";
	    
	    EmployeeServiceImpl em = new EmployeeServiceImpl();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String choice="";
	    //Menu
		while(true)
		{
		System.out.println(" ");
		System.out.println("MENU");
		System.out.println("=================================");
		System.out.println("1 Enter Employee Details and Get Scheme");
		System.out.println("2 Get Insurance Scheme");
		System.out.println("3 Print Employee Details");
		System.out.println("4 Exit");
		System.out.println("Enter your choice");
		choice=br.readLine();
		switch(choice)
		{
		case "1":
				  
				  
				  //Accepting Employee details, Validating ,then generating Scheme and Details of Employee with Scheme
			      //Employee ID
				  System.out.println("Enter Employee ID in 5 Digits");
				  while(true)
				  {
					  input=br.readLine();
					 
					  boolean ch1=Validator.validatedata(input, Validator.e_idpattern);
					  if(ch1==true)
					  {
						  try {
							  e_id=Integer.parseInt(input);
							  break;
						  }
						  catch(NumberFormatException e)
					  
					  {
						 System.out.println("Employee ID must be Numeric. Re Enter"); 
					  }
				  }
					  else
					  {
						  System.out.println("Re Enter Employee ID in 5 digits");
					  }
				  
				  }//end of while
				  
				  
				  
				  //accepting and validating Employee Name
				  System.out.println("Enter Employee Name");
				 while(true)
				  {
					  input=br.readLine();
					  boolean ch1=Validator.validatedata(input, Validator.e_namepattern);
					  if(ch1==true)
					  {
						  e_name=input;
						  break;
						  
						  
				       }
					  else
						  System.out.println("Re Enter Employee Name"); 
					  
				  
				  }
				 
				 
				 //Employee Salary
				 System.out.println("Enter Employee Salary");
				 while(true)
				  {
					 input=br.readLine();
					  boolean ch1=Validator.validatedata(input, Validator.e_salary);
					  if(ch1==true)
					  {
						  try {
							  e_salary= Double.parseDouble(input);
							  break;
						  }
						  catch(NumberFormatException e)
					  
					  {
						 System.out.println("Salary must be Numeric. Re Enter"); 
					  }
				  }
					  else
					  {
						  System.out.println("Re Enter Salary");
					  }
				  
				  }
				 
				 //Employee Designation
				 System.out.println("Enter Employee Designation");
				 while(true)
				  {
					 input=br.readLine();
					 if(input.equalsIgnoreCase("System Associate")||input.equalsIgnoreCase("Programmer")||(input.equalsIgnoreCase("Manager")||input.equalsIgnoreCase("Clerk")))
					  {
						  
						  e_designation=input;
						  break;
						  
				       }
					  else
					  {
						  System.out.println("Re Enter Employee Designation");  
					  }
				  }
				  
				  System.out.println("Successfully Recorded");
				  try{
				  e_insurance_scheme= em.getScheme(e_salary, e_designation);
				  System.out.println(" ");
				  System.out.println("==========================Insurance Scheme============================");
				  System.out.println(e_insurance_scheme);
				  System.out.println("======================================================================");
				  Employee e= new Employee( e_id, e_name,  e_salary,  e_designation, e_insurance_scheme);
				  System.out.println(" ");
			      em.addEmployee(e);
			      em.printEmployeedetails(e);
			      System.out.println("Employee Insurance Scheme :- "+e_insurance_scheme);
			      System.out.println("=====================================");
			      
			      System.out.println(" ");
			      
				
				  
				  break;
				  }
				  catch(InvalidInputException e)
				  {
					  System.err.println(e.getMessage());
				  }
				  
		     	
		case "2"://Just generating Insurance scheme for anyone on basis of Employee Salary and designation
			System.out.println("Enter Employee Salary");
			 while(true)
			  {
				 input=br.readLine();
				  boolean ch1=Validator.validatedata(input, Validator.e_salary);
				  if(ch1==true)
				  {
					  try {
						  e_salary= Double.parseDouble(input);
						  break;
					  }
					  catch(NumberFormatException e2)
				  
				  {
					 System.out.println("Salary must be Numeric. Re Enter"); 
				  }
			  }
				  else
				  {
					  System.out.println("Re Enter Salary");
				  }
			  
			  }
			 
			 System.out.println("Enter Employee Designation");
			 while(true)
			  {
				 input=br.readLine();
				 if(input.equalsIgnoreCase("System Associate")||input.equalsIgnoreCase("Programmer")||(input.equalsIgnoreCase("Manager")||input.equalsIgnoreCase("Clerk")))
				  {
					  
					  e_designation=input;
					  break;
					  
			       }
				  else
				  {
					  System.out.println("Re Enter Employee Designation");  
				  }
			  }
			  
			  System.out.println("Successfully Recorded");
			  try{
				  System.out.println(" ");
				  e_insurance_scheme= em.getScheme(e_salary, e_designation);
				  System.out.println("==========================Insurance Scheme============================");
				  System.out.println(e_insurance_scheme);
				  System.out.println("======================================================================");
				  break;
				  }
				  catch(InvalidInputException e5)
				  {
					  System.err.println(e5.getMessage());
				  }
			  
			 
	   
		case "3": //Getting detail of employee by just taking employee id
			    
			System.out.println("Enter Employee ID");
			  while(true)
			  {
				  input=br.readLine();
				 
				  boolean ch1=Validator.validatedata(input, Validator.e_idpattern);
				  if(ch1==true)
				  {
					  try {
						  e_id=Integer.parseInt(input);
						  break;
					  }
					  catch(NumberFormatException e1)
				  
				  {
					 System.out.println("Employee ID must be Numeric. Re Enter"); 
				  }
			  }
				  else
				  {
					  System.out.println("Re Enter Employee ID in 4 digits");
				  }
			  
			  }
			  System.out.println("Successfully Recorded");
			  Employee em1= em.findEmployee(e_id);
			  try{
				  System.out.println(" ");
				  e_insurance_scheme= em.getScheme(em1.getE_salary(), em1.getE_designation());
				  em.printEmployeedetails(em1);
			      System.out.println("Employee Insurance Scheme :- "+e_insurance_scheme);
			      System.out.println("=====================================");
			      
			      System.out.println(" ");
			      
				
				  
				  break;
				  }
				  catch(InvalidInputException e7)
				  {
					  System.err.println(e7.getMessage());
				  }
			 
			  
			  
		case "4":
			     System.out.println("Exiting Program");
			     System.exit(0);
			     break;
	    default:
	    	    System.out.println("Invalid choice");
		
		
		
		
		
		}
		
		
		
		
		}
	}

}
