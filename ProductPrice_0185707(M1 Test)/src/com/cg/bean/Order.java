package com.cg.bean;

public class Order implements Comparable<Order> {
	
	private int id;
	private double price;
	private int quantity;
	private double amount;
	private double charges;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
 
	//only accepting price and quantity as amount and charges will be calculated by calculateOrder function in service layer.
	
	
	public Order( double price, int quantity) {
		super();
		this.id = (int) (Math.random()*1000);
		this.price = price;
		this.quantity = quantity;
		this.amount = 0.0;
		this.charges = 0.0;
	}

	public int getId() {
		return id;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + ", quantity=" + quantity + ", amount=" + amount + ", charges="
				+ charges + "]";
	}

	//to sort all records on basis of order id
	@Override
	public int compareTo(Order arg0) {
		
			
			int diff=this.getId()-arg0.getId();
			if(diff>0)
				return 1;
			else if(diff<0)
				return -1;
			else 
				return 0;
			
		
		
	}
	
	
	
	

}
