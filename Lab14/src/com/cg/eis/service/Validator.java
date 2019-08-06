package com.cg.eis.service;

public interface Validator {
	
	String e_idpattern="[1-9][0-9][0-9][0-9][0-9]";
	String e_namepattern ="[a-zA-Z][a-z]*+[']*[.]*[ ]*+[a-zA-Z]*";
	String e_salary="[0-9]*+[.]*+[0-9]*";
	
	public static boolean validatedata(String data, String pattern)
	{
		return data.matches(pattern);
	}

}
