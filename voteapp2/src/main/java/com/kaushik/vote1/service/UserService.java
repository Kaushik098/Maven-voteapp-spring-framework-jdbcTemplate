package com.kaushik.vote1.service;

import java.util.List;

import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.User;

public interface UserService {

	String register(User user); // registerService

	User login(String name,String password); //LoginService
	
	List<Cast> getVoteListById(int id);

	List<Cast> getAllEntries();

}
