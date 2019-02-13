package com.kaushik.vote1.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;

import com.kaushik.vote1.dao.CastDAO;
import com.kaushik.vote1.dao.impl.CastDAOImpl;
import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.VoteSummary;
import com.kaushik.vote1.service.CastService;


public class CastServiceImpl implements CastService{
	
	static Logger castlog = Logger.getLogger(CastServiceImpl.class.getName()); 
    Cast cast = new Cast();
	
    public int addVote(Cast cast) {
    	castlog.info("Add Vote method called");
		  
		  LocalDateTime  dt = LocalDateTime.now();
		  
		    int userId = cast.getUserID();
		    int c_id1 = cast.getCandidateID1();
		    int c_id2 = cast.getCandidateID2();
		    int c_id3 = cast.getCandidateID3();
		    int c_id4 = cast.getCandidateID4();
		    
	         cast.setUserID(userId);
	         cast.setCandidateID1(c_id1);
	         cast.setCandidateID2(c_id2);
	         cast.setCandidateID3(c_id3);
	         cast.setCandidateID4(c_id4);
	         cast.setDateTime(Timestamp.valueOf(dt));
	   	    
	         CastDAO vote = new CastDAOImpl();
	         int n = vote.addVote(cast);
	         return n;
	}
	public List<VoteSummary> candidateVoteCount(int candidateId) {
		 castlog.info("Method called to view individual candidate vote count");
	     
	     CastDAO countVote = new CastDAOImpl();
	     List<VoteSummary> totalVotes = countVote.getVoteCountByID(candidateId);
	    
	     System.out.println("The total vote count for candidateId "+candidateId+" is : "+totalVotes);  
	     
	     return totalVotes;
	}
	public List<VoteSummary> candidatesVoteCount() {
		castlog.info("Method called to view all Candidated Vote count");
		
	     CastDAO countVotesOfAll = new CastDAOImpl();
	     List<VoteSummary> totalVotesOfAll = countVotesOfAll.getVoteCountOfAll();
	    	     
	     return totalVotesOfAll;
	}
}
