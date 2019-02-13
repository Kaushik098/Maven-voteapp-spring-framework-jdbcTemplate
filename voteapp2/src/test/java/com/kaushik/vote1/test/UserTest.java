package com.kaushik.vote1.test;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import com.kaushik.vote1.dao.UserDAO;
import com.kaushik.vote1.dao.impl.UserDAOImpl;
import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.User;
import com.kaushik.vote1.service.UserService;
import com.kaushik.vote1.service.impl.UserServiceImpl;
import com.kaushik.vote1.validate.RegisterValidate;

public class UserTest {

	
	public static void main(String args[]){
	User users = new User();                  
	 
	/*// Registration
	  	     users.setAdhaarName("Vishnu");
			 users.setAdhaarNumber("988821155511");
			 String dobStr = "1999-06-01";
			 LocalDate date = LocalDate.parse(dobStr);
			 users.setDob(date);
			 users.setUsername("vishnu11");
			 users.setPassword("vishnulegend11");
			 users.setMobileNumber("9980013001");
			 users.setGender("male");
			 users.setEntry(0);
			 users.setRole("user");
			 
			 RegisterValidate userValidate = new RegisterValidate();
			 boolean value = userValidate.userValidate(users);
					 
			 if(value){
				 UserService us = new UserServiceImpl();
				 String s = us.register(users);
				 System.out.println(s);
			 }
			 else{
				 System.out.println("Please change the incorrect fields and try with proper credentials");
			 }  */
			 
	//login
	   /*  User userLogin = new User();
	     
	     String name = "vishnu11";
	     String password = "vishnulegend11";
           	
	     UserService log = new UserServiceImpl();
	     User u = log.login(name, password);
	     
	     System.out.println(u);*/
	
	//get vote by id
	
	/*UserService u = new UserServiceImpl();
	List<Cast> cast = u.getVoteListById(33);
	  
	System.out.println(cast);*/
	
	// get all votes

	UserService u = new UserServiceImpl();
	List<Cast>  cast = u.getAllEntries();
	
	Iterator itr = cast.iterator();
	while(itr.hasNext()){
		System.out.println(itr.next());
	}
	
     }
}
