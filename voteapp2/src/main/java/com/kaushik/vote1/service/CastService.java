package com.kaushik.vote1.service;

import java.util.List;

import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.VoteSummary;



public interface CastService {

	//a.) 
		int addVote(Cast cast);

		//b.)
		List<VoteSummary> candidateVoteCount(int candidateId);

		//c.)
		List<VoteSummary> candidatesVoteCount();
}
