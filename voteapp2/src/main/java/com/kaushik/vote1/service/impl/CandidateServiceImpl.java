package com.kaushik.vote1.service.impl;

import java.util.List;


import org.apache.log4j.Logger;

import com.kaushik.vote1.dao.CandidateDAO;
import com.kaushik.vote1.dao.impl.CandidateDAOImpl;
import com.kaushik.vote1.model.Candidate;
import com.kaushik.vote1.model.Category;
import com.kaushik.vote1.service.CandidateService;


public class CandidateServiceImpl implements CandidateService {

	static Logger candidatelog = Logger.getLogger(CandidateServiceImpl.class.getName());
	CandidateDAO candidate = new CandidateDAOImpl();
	
	public void addCandidate(Candidate candidate) {
		 candidatelog.info("Add Candidate Method Called");
		 
				 Category category = null;
				 int id = 0;
				 String name = "";
						 
				 candidate.setCandidateId(candidate.getCandidateId());
		         candidate.setCandidateName(candidate.getCandidateName());
		         id = candidate.getCategory().getId();
		         name = candidate.getCategory().getName();
		         
		         category = new  Category(id, name);
		         candidate.setCategory(category);
				 
				 CandidateDAO addCandidate = new CandidateDAOImpl();
				 addCandidate.newCandidate(candidate); 
		
	}

	public void deleteCandidate(int id) {
		candidatelog.info("Delete candidate Method called");
	       
		CandidateDAO deleteCandidate = new CandidateDAOImpl();
		deleteCandidate.deleteCandidate(id);
		
	}

	public List<Candidate> getAllCandidates() {
        candidatelog.info("Method called to view all Candidates");
		
		List<Candidate> allcandidates = candidate.showCandidates();    
		return allcandidates;
	}

	public List<Candidate> getCandidateById(int id) {
		 candidatelog.info("Method called to view candidate using id");
			
		 Candidate find = new Candidate();
		 find.setCandidateId(id);
			
	     CandidateDAO candidateSelectByID = new  CandidateDAOImpl();
	     List<Candidate> candidateName = candidateSelectByID.findById(find);
         
	     return candidateName;
	}

}
