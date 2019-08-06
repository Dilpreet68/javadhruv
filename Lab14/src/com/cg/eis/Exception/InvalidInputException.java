package com.cg.eis.Exception;

public class InvalidInputException extends Exception {
	
//Exception raises when employees does'nt fall in any category and salary range is matching with designation...	
	public InvalidInputException() {
		// TODO Auto-generated constructor stub
	}
	public InvalidInputException(String msg) {
		// TODO Auto-generated constructor stub
		super (msg);
		
	}
	@Override
	public String toString() {
		return "InvalidInputException - "+super.getMessage();
	}
}
