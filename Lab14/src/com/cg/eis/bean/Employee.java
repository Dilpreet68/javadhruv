package com.cg.eis.bean;

public class Employee implements Comparable<Employee> {
	
	private int e_id;
	private String e_name;
	private double e_salary;
	private String e_designation;
	private String e_insurance_scheme;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int e_id, String e_name, double e_salary, String e_designation, String e_insurance_scheme) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_salary = e_salary;
		this.e_designation = e_designation;
		this.e_insurance_scheme = e_insurance_scheme;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public double getE_salary() {
		return e_salary;
	}

	public void setE_salary(double e_salary) {
		this.e_salary = e_salary;
	}

	public String getE_designation() {
		return e_designation;
	}

	public void setE_designation(String e_designation) {
		this.e_designation = e_designation;
	}

	public String getE_insurance_scheme() {
		return e_insurance_scheme;
	}

	public void setE_insurance_scheme(String e_insurance_scheme) {
		this.e_insurance_scheme = e_insurance_scheme;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", e_salary=" + e_salary + ", e_designation="
				+ e_designation + ", e_insurance_scheme=" + e_insurance_scheme + "]";
	}
	
	
	@Override
	public int compareTo (Employee e) {
		// default sorting based on employee id
		
				int diff=this.getE_id()-e.getE_id();
				if(diff>0)
					return 1;
				else if(diff<0)
					return -1;
				else 
					return 0;
	}
	
	
	
	

}
