package com.kaushik.vote1.dao;

import java.util.List;

import com.kaushik.vote1.model.Candidate;


public interface CandidateDAO {

	 void newCandidate(Candidate candidate);
	 void deleteCandidate(int id);
	 List<Candidate> showCandidates();
	 List<Candidate> findById(Candidate find);
}
