package com.kaushik.vote1.util;

public class StringUtil {

	 public static boolean isValid(String input) {
		 
	        if (input == null) {
	            return false;
	        } else if (input.equals("")) {
	            return false;
	        } else if (input.trim().equals("")) {
	            return false;
	        } else {
	            return true;
	        }     
	    }

}
