package com.kaushik.vote1.dao;

import java.util.List;

import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.VoteSummary;


public interface CastDAO {

	  int addVote(Cast cast);
	  List<VoteSummary> getVoteCountByID(int c_id);
	  List<VoteSummary> getVoteCountOfAll();
	  
}
