package com.kaushik.vote1.test;

import java.util.Iterator;
import java.util.List;



import com.kaushik.vote1.dao.CandidateDAO;
import com.kaushik.vote1.dao.impl.CandidateDAOImpl;
import com.kaushik.vote1.model.Candidate;
import com.kaushik.vote1.model.Category;
import com.kaushik.vote1.service.CandidateService;
import com.kaushik.vote1.service.impl.CandidateServiceImpl;


public class CandidateTest {

	public static void main(String args[]){
		
		//1.) Delete
		
		/*CandidateService cd = new CandidateServiceImpl();
		cd.deleteCandidate(103);*/
		
		//
		
		//2.) get all entries
		
	/*	CandidateService cd  = new CandidateServiceImpl();
		List<Candidate> c = cd.getAllCandidates();
		
		Iterator itr = c.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		
		//3.) get by id
		/*Candidate find = new Candidate();
		
		find.setCandidateId(101);
		
		CandidateDAO cd = new CandidateDAOImpl();
		List<Candidate> c = cd.findById(find);
		
		System.out.println(c);*/
		
		// add new Candidate
		
		/* Candidate candidate = new Candidate();
         Category category = null;
	//a.)	
                  
          candidate.setCandidateId(103);
          candidate.setCandidateName("Raghul Dravid");
          category = new  Category(1, "Batsman");
          candidate.setCategory(category);
          
          CandidateService ct = new CandidateServiceImpl();
          ct.addCandidate(candidate);*/
          
  		//System.out.println(candidate.getCandidateId()+" "+candidate.getCategory());

        /*  CandidateService ct = new CandidateServiceImpl();
          ct.addCandidate(candidate);
          */
		
	}
}
