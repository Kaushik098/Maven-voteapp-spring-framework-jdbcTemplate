package com.kaushik.vote1.service;

import java.util.List;

import com.kaushik.vote1.model.Candidate;


public interface CandidateService {

	    //a.)
		void addCandidate(Candidate candidate);
	    //b.)
		void deleteCandidate(int id);
		
		//c.)
		List<Candidate> getAllCandidates();
		//c.)
		List<Candidate> getCandidateById(int id);
}
