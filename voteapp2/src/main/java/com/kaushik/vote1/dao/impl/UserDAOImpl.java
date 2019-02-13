package com.kaushik.vote1.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kaushik.vote1.dao.UserDAO;
import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.User;
import com.kaushik.vote1.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
//a.) register	
	public void register(User users) {

         try{
        	 String sql = "Insert into users(adhaar_name, adhaar_number, dob, username, u_password, mobile_number, gender, entry, role)"
                     +"values(?,?,?,?,?,?,?,?,?)";
        	 
        	 Object[] params = {users.getAdhaarName(), users.getAdhaarNumber(), users.getDob(),
        	                    users.getUsername(), users.getPassword(), users.getMobileNumber(),
        	                    users.getGender(), users.getEntry(), users.getRole()};
        	
        	 int rows = jdbcTemplate.update(sql,params);
        	 
        	 System.out.println(rows+ "added");
         }
         catch(Exception ae){
        	 System.err.println(ae.getMessage());
         }
		
	}

//b.) Login	
	public User login(User userLogin) {
           
		User loginValues = new User();
		
        try{
			 String sql = "Select user_id, adhaar_name, adhaar_number, dob, username, u_password, mobile_number, gender, role from users where username = ? and u_password = ?";
			 
			    loginValues = jdbcTemplate.queryForObject(sql,new Object[]{userLogin.getUsername(), userLogin.getPassword()},(result,rowNo)->{
			
				
				    User username = new User();
				
				     int userID = Integer.parseInt(String.valueOf(result.getString("user_id")));
			         String adhaarName = String.valueOf(result.getString("adhaar_name"));
			         String adhaarNumber = String.valueOf(result.getString("adhaar_number"));
			         LocalDate dateOfBirth = LocalDate.parse(result.getString("dob"));
				     String usernameCopy = String.valueOf(result.getString("username"));
				     String passwordCopy = String.valueOf(result.getString("u_password"));
				     String mobile = String.valueOf(result.getString("mobile_number"));
					 String gender = String.valueOf(result.getString("gender"));
				     String role = String.valueOf(result.getString("role"));
				   
				      
					 if( role.equals("admin")){
				    	  username = new User();
				          System.out.println("Welcome Admin");
				          username.setUserId(userID);
				    	  username.setAdhaarName(adhaarName);
				          username.setAdhaarNumber(adhaarNumber);
				          username.setDob(dateOfBirth);
				          username.setUsername(usernameCopy);
				          username.setMobileNumber(mobile);
				          username.setGender(gender);
				          username.setRole(role);
				    }
				    else if(usernameCopy.equals(userLogin.getUsername()) && passwordCopy.equals(userLogin.getPassword()))
				        {
				    	  username = new User();
				    	  System.out.println("Welcome to vote your favourite candidate");
				          username.setUserId(userID);
				    	  username.setAdhaarName(adhaarName);
				          username.setAdhaarNumber(adhaarNumber);
				          username.setDob(dateOfBirth);
				          username.setUsername(usernameCopy);
				          username.setMobileNumber(mobile);
				          username.setGender(gender);
				          username.setRole(role);
				    }
				    else if(usernameCopy.equals(userLogin.getUsername()))
				    		System.out.println("Incorrect Password");
				    else if(passwordCopy.equals(userLogin.getPassword()))
					        System.out.println("Incorrect Username");
				    else
				    	   System.out.println("Incorrect username and password");

 				   
				        
				        return username;
			 });
                  
            }
        catch(Exception ae){
       	 System.err.println(ae.getMessage());
        }
		return loginValues;
   	
	}

	public List<Cast> getVoteListById(int id) {
		
		
		List<Cast> values = new ArrayList<>();
		
        try{
        	String sql = "Select user_id, batting, bowling, wicket_keeper, all_rounder, cast_datetime from category_votes where user_id = ?";
        	 values = jdbcTemplate.queryForObject(sql, new Object[] {id}, (result, rowNo)->{
        		           
        		Cast c = new Cast();
        		
        		int userID = result.getInt("user_id");
			    int id1 = result.getInt("batting");
			    int id2 = result.getInt("bowling");
			    int id3 = result.getInt("wicket_keeper");
			    int id4 = result.getInt("all_rounder");
			    String date = result.getString("cast_datetime");
				  
			    Timestamp ts = Timestamp.valueOf(date);
			    System.out.println(ts); 
			    
			    c.setUserID(userID);
			    c.setCandidateID1(id1);
			    c.setCandidateID2(id2);
			    c.setCandidateID3(id3);
			    c.setCandidateID4(id4);
			    c.setDateTime(ts);
			    
			    List<Cast> al = new ArrayList<>();
	        	al.add(c);
	        	
	        	return al;
        	});
        	
        	
        }
        catch(Exception ae){
       	 System.err.println(ae.getMessage());
        }
        
		return values;
	}
	
	public List<Cast> getAllEntries(){ 
		String sql = "Select user_id, batting, bowling, wicket_keeper, all_rounder, cast_datetime from category_votes";
	
		List<Cast> al = new ArrayList<>();
	try{     	
		al = jdbcTemplate.query(sql, (result,rowNo)->{
			
			Cast cast = new Cast();
			
			int userID = result.getInt("user_id");
		    int id1 = result.getInt("batting");
		    int id2 = result.getInt("bowling");
		    int id3 = result.getInt("wicket_keeper");
		    int id4 = result.getInt("all_rounder");
		    String date = result.getString("cast_datetime");
			  
		    Timestamp ts = Timestamp.valueOf(date);
		    System.out.println(ts); 
		    
		    cast.setUserID(userID);
		    cast.setCandidateID1(id1);
		    cast.setCandidateID2(id2);
		    cast.setCandidateID3(id3);
		    cast.setCandidateID4(id4);
		    cast.setDateTime(ts);
		    
		    
			return cast;
		});
	}
	catch(Exception ae){
		System.err.println(ae.getMessage());
	}
		return al;
	}
	
}
