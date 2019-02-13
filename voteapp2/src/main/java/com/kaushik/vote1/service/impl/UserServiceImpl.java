package com.kaushik.vote1.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import com.kaushik.vote1.dao.UserDAO;
import com.kaushik.vote1.dao.impl.UserDAOImpl;
import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.User;
import com.kaushik.vote1.service.UserService;
import com.kaushik.vote1.validate.RegisterValidate;


public class UserServiceImpl implements UserService {

	static Logger userlog = Logger.getLogger(UserServiceImpl.class.getName());

	public String register(User user) {
		userlog.info("Register method called");
		 
		 User users = new User();	
		 String status = "";
		 
		 int userId;
		 
		 String adhaarName = user.getAdhaarName();
		 String adhaarNumber = user.getAdhaarNumber();
		 LocalDate date = user.getDob();
		 String username = user.getUsername();
		 String password = user.getPassword();
		 String mobile = user.getMobileNumber();
		 String gender = user.getGender();
		 int entry = 0;
		 String role = "user";
	          
				 
//Registration
 	     users.setAdhaarName(adhaarName);
		 users.setAdhaarNumber(adhaarNumber);
		 users.setDob(date);
		 users.setUsername(username);
		 users.setPassword(password);
		 users.setMobileNumber(mobile);
		 users.setGender(gender);
		 users.setEntry(entry);
		 users.setRole(role);
		 
		 RegisterValidate userValidate = new RegisterValidate();
		 boolean value = userValidate.userValidate(users);
				 
		 if(value){
		     UserDAO registerUser = new UserDAOImpl();		     
		     registerUser.register(users);
		     status = "Successfully registered";
		 }
		 else{
			 System.out.println("Please change the incorrect fields and try with proper credentials");
			 status = "Incorrect Details, try with any other username and password if you followed the above note points";
		 }
		 
		 return status;
	}

	public User login(String name, String password) {
		 userlog.info("Login method called"); 
			
		 User users = new User();
	    
	     users.setUsername(name);
		 users.setPassword(password);
		 
		 UserDAO loginUser = new UserDAOImpl();
		 User login = loginUser.login(users);   
		 
		 return login;
	}

	public List<Cast> getVoteListById(int id) {
        userlog.info("Method called to view the casted votes by user_id");
		
		UserDAO getVote = new UserDAOImpl();   
	    List<Cast> l = getVote.getVoteListById(id);
		
		return l;
	}

	public List<Cast> getAllEntries() {
		 userlog.info("Method called to get whole list of user votes");
		 
		 UserDAO getUsers = new UserDAOImpl();
		 List<Cast> usersList = getUsers.getAllEntries();
		 
		 return usersList;
	}

	

}
