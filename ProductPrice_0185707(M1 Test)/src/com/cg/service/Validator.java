package com.cg.service;

public interface Validator {
	
	String pricepattern="[1-9][0-9]*+[.]*+[0-9]*";//first digit cannot be zero and no negative number and can include double decimal also.
	String quantitypattern="[1-9][0-9]*";//first digit cannot be zero and no negative number and only Positive Integer value
	
	public static boolean validatedata(String data, String pattern)
	{
		return data.matches(pattern);
	}

}
