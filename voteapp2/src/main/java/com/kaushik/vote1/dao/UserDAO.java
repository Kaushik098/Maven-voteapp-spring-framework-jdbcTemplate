package com.kaushik.vote1.dao;

import java.util.List;

import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.User;


public interface UserDAO {
    
	 void register(User users);
	 User login(User userLogin);
	 List<Cast> getVoteListById(int id);
	 List<Cast> getAllEntries();
	 
}
