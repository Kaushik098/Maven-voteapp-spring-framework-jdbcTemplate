package com.kaushik.vote1.validate;

import java.time.LocalDate;
import java.util.regex.Pattern;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kaushik.vote1.model.User;
import com.kaushik.vote1.util.ConnectionUtil;
import com.kaushik.vote1.util.StringUtil;



public class RegisterValidate {

	public boolean userValidate(User user){
	
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
        
	   	 int invalid = 0;
	   	 boolean value = false;
	   	 
	  //a.) AdhaarName
	   	 StringUtil adhaarName = new StringUtil();
	   	 boolean adhaarNameCheck = adhaarName.isValid(user.getAdhaarName());
	   	 
	   	 if(adhaarNameCheck == true){
	   		 System.out.println("true");
	   	 }
	   	 else{
	   		 System.out.println("Please enter the valid AdhaarName");
	   		 invalid++;
	   	 }
	   	 
	  //b.) Adhaar Card Digits check 	 
	   	if(user.getAdhaarNumber().length()!=12){
	   		System.out.println("Enter the valid 12 digit adhaar card number");
	        invalid++;
	   	}
	   	
	  //c.) dob 	
	      LocalDate date = user.getDob();
	      
	      int year = date.getYear();
	      
	      if(year > 2000){
	    	  System.out.println("Only above 18 age people are eligible to register and vote");
	    	   invalid++;
	      }
	  //d.)Checking Username
	   	
	    StringUtil checkUsername = new StringUtil();
	    boolean rs = checkUsername.isValid(user.getUsername());
	   
	   
	     if(rs){
	    	    
	    	    
			try {
				String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
				//String usernameCheckCopy = null;
			    String usernameCheckCopy = jdbcTemplate.queryForObject(sql, new Object[] {user.getUsername()}, (result, rowNo) ->{
			    	 return  result.getString(1);
			    });
		  
		        int val1 = Integer.parseInt(usernameCheckCopy);

		        if(val1 >= 1) {
		        	System.out.println("Username already Exists, please change and try");
		        	invalid++;
		        }
			    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      } 
	    else{
		   System.out.println("Please enter a valid username");
		   invalid++;
	    }  // end of usernameCheck
	     
	   //e.)Checking Password
	     
	     StringUtil checkPassword = new StringUtil();
	     boolean pwd = checkPassword.isValid(user.getPassword());
	       
	     if(pwd){
	       
	        try {
	        	
				String sql = "SELECT COUNT(*) FROM users WHERE u_password = ?";
				/*preparedStatement = conn.prepareStatement(passwordQuery);
				preparedStatement.setString(1, user.getPassword());
			    result = preparedStatement.executeQuery();
			    */    
				String passwordCheckCopy = jdbcTemplate.queryForObject(sql, new Object[] {user.getPassword()}, (result,rowNo)->{
					return result.getString(1);
				}); 
			   
				int val2 = Integer.parseInt(passwordCheckCopy);

				if (val2 >= 1) {
					System.out.println("Password already exists, please change and try");
					invalid++;
				}
				
			// Regular Expression pattern (Atleast 8 characters and one number")
				
		     	if(!Pattern.matches("[a-zA-Z]{8,}+[0-9]{1,}", user.getPassword()))
		   	   {
		   		  System.out.println("Please enter valid password which has 8 characters with atleast 1 number ");
		   		  invalid++;
		   	   }

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	     else{
	    	 System.out.println("Please enter a valid password with atleast 8 charcters and 1 number");
	         invalid++;
	     }
			
	            
	   	
	     // f.) mobile number
	   	   if(!Pattern.matches("[6-9]{1}+[0-9]{9}", user.getMobileNumber()))
	   	   {
				   System.out.println("Please enter correct mobile number");
				   invalid++;
		   }
	   	
	         
	        if(invalid == 0)
	       	     value = true;
	        else
	       	     value = false;
	        
	         
	       return value;
	        
		}
}
