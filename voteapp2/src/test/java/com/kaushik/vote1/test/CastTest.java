package com.kaushik.vote1.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import com.kaushik.vote1.dao.CastDAO;
import com.kaushik.vote1.dao.impl.CastDAOImpl;
import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.VoteSummary;
import com.kaushik.vote1.service.CastService;
import com.kaushik.vote1.service.impl.CastServiceImpl;

public class CastTest {

	public static void main(String args[]){
		
	// All Candidate Result Count	
		CastService cast = new CastServiceImpl();
		List<VoteSummary> al = cast.candidatesVoteCount();
		
		Iterator itr = al.iterator();
		while(itr.hasNext()){
			  System.out.println(itr.next());  
		}
		
		
	// Individual Count	
		/*CastService cast = new CastServiceImpl();
		List<VoteSummary> al = cast.candidateVoteCount(101);
		
		System.out.println(al);*/
	
		
	// add Vote
		/* LocalDateTime dt = LocalDateTime.now();
         
         Cast cast = new Cast();
         cast.setUserID(36);
         cast.setCandidateID1(102);
         cast.setCandidateID2(202);
         cast.setCandidateID3(303);
         cast.setCandidateID4(402);
         cast.setRole("admin");
         cast.setDateTime(Timestamp.valueOf(dt));
         
         CastService av = new CastServiceImpl();
         int n = av.addVote(cast); */
		
	}
}
