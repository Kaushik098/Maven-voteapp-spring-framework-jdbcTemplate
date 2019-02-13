package com.kaushik.vote1.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.kaushik.vote1.dao.CastDAO;
import com.kaushik.vote1.model.Cast;
import com.kaushik.vote1.model.VoteSummary;
import com.kaushik.vote1.util.ConnectionUtil;

public class CastDAOImpl implements CastDAO {

	JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	
	public int findEntry(int id){
		int n = 0;
		try{
		 n = jdbctemplate.queryForObject("Select entry from users where user_id ="+ id, (result, rowNo)->{
			return  result.getInt("entry");
		});
		}
		catch(Exception ae){
			System.out.println(ae.getMessage());
		}
		return n;
	}
	
	public int addVote(Cast cast) {
	   
		CastDAOImpl entryFind = new CastDAOImpl();
		int entry = entryFind.findEntry(cast.getUserID());
		try{
		 if(entry == 0 && cast.getRole().equals("user")){
			 String sql = "Insert into category_votes(user_id, batting, bowling, wicket_keeper, all_rounder, cast_datetime) values(?,?,?,?,?,?)";
	         Object[] params = {cast.getUserID(), cast.getCandidateID1(), cast.getCandidateID2(), cast.getCandidateID3(), cast.getCandidateID4(), cast.getDateTime()};
			 int result =jdbctemplate.update(sql, params);
			 
			 System.out.println(result+ "Added");
			 
			 String sql1 = "Update users set entry = entry+1 where user_id ="+cast.getUserID();
		     int result1 = jdbctemplate.update(sql1);
				
			System.out.println(result1+ "User Entry Updated");
		  }
		 else if(entry == 0 && cast.getRole().equals("admin")){
			 System.out.println("Vote update will not be made in Admin Page... Sorry!!!");
		 }
		 else{
			System.out.println("Already voted!!! Only once you can be voted... Sorry!!!");
		  }
		}
		catch(Exception ae){
			System.err.println(ae.getMessage());
		}
		return entry;
	    
	}
	
	public List<VoteSummary> getVoteCountByID(int cId){
		   
		 List<VoteSummary> al = new ArrayList<>();
		 try{
			String sql = "select candidate_id, candidate_name from category where candidate_id = ?";
			Object[] params = {cId};
			 
		    al = jdbctemplate.query(sql, params, (result, rowNo)->{
			 
			 int id = result.getInt("candidate_id");
		    	String name = result.getString("candidate_name");
		    			
             int btc = jdbctemplate.queryForObject( "Select count(*) from category_votes where batting = ?", new Object[] {id}, (result1, rowNo1)-> {
                  return  result1.getInt(1);
             });
		         
             int bwc = jdbctemplate.queryForObject("Select count(*) from category_votes where bowling = ?", new Object[] {id}, (result2, rowNo2)-> {
                  return  result2.getInt(1);
             });
             
             int wc = jdbctemplate.queryForObject("Select count(*) from category_votes where wicket_keeper = ?", new Object[] {id}, (result3, rowNo3)-> {
                 return  result3.getInt(1);
            });
             
             int ar = jdbctemplate.queryForObject("Select count(*) from category_votes where all_rounder = ?", new Object[] {id}, (result4, rowNo4)-> {
                 return  result4.getInt(1);
            });
			 VoteSummary vs = new VoteSummary();
			 vs.setCandidateId(id);
             vs.setCandidateName(name);
             vs.setBattingCount(btc);
             vs.setBowlingCount(bwc);
             vs.setWicketKeeperCount(wc);
             vs.setAllRounderCount(ar);
             
			 return vs; 
		 });
		}
		 catch(Exception ae){
		     System.err.println(ae.getMessage());	 
		 }
		 return al;  	
	}
		
	
	public List<VoteSummary> getVoteCountOfAll() {
		
		 List<VoteSummary> al = new ArrayList<>();
		 
		try{ 
		 String sql = "select candidate_id, candidate_name from category";
		
		 al = jdbctemplate.query(sql, (result, rowNo)->{
			 
			 int id = result.getInt("candidate_id");
		    	String name = result.getString("candidate_name");
		    			
             int btc = jdbctemplate.queryForObject( "Select count(*) from category_votes where batting = ?", new Object[] {id}, (result1, rowNo1)-> {
                  return  result1.getInt(1);
             });
		         
             int bwc = jdbctemplate.queryForObject("Select count(*) from category_votes where bowling = ?", new Object[] {id}, (result2, rowNo2)-> {
                  return  result2.getInt(1);
             });
             
             int wc = jdbctemplate.queryForObject("Select count(*) from category_votes where wicket_keeper = ?", new Object[] {id}, (result3, rowNo3)-> {
                 return  result3.getInt(1);
            });
             
             int ar = jdbctemplate.queryForObject("Select count(*) from category_votes where all_rounder = ?", new Object[] {id}, (result4, rowNo4)-> {
                 return  result4.getInt(1);
            });
			 VoteSummary vs = new VoteSummary();
			 vs.setCandidateId(id);
             vs.setCandidateName(name);
             vs.setBattingCount(btc);
             vs.setBowlingCount(bwc);
             vs.setWicketKeeperCount(wc);
             vs.setAllRounderCount(ar);
             
			 return vs; 
		 });
		}
		catch(Exception ae){
			System.err.println(ae.getMessage());
		}
		 return al;  	
	}
}
	




	/*/*return jdbctemplate.query("select candidate_id, candidate_name from category where candidate_id = "+cId,new ResultSetExtractor<List<VoteSummary>>(){  
		
			@Override  
		     public List<VoteSummary> extractData(ResultSet result) throws SQLException,  
		        
		     DataAccessException {   
		        List<VoteSummary> list=new ArrayList<>();  

		    while(result.next()){
		    	int id = result.getInt("candidate_id");
		    	String name = result.getString("candidate_name");
		    			
                int btc = jdbctemplate.queryForObject( "Select count(*) from category_votes where batting = ?", new Object[] {id}, (result1, rowNo)-> {
                     return  result1.getInt(1);
                });
		         
                int bwc = jdbctemplate.queryForObject("Select count(*) from category_votes where bowling = ?", new Object[] {id}, (result2, rowNo)-> {
                     return  result2.getInt(1);
                });
                
                int wc = jdbctemplate.queryForObject("Select count(*) from category_votes where wicket_keeper = ?", new Object[] {id}, (result3, rowNo)-> {
                    return  result3.getInt(1);
               });
                
                int ar = jdbctemplate.queryForObject("Select count(*) from category_votes where all_rounder = ?", new Object[] {id}, (result4, rowNo)-> {
                    return  result4.getInt(1);
               });
		       
                    VoteSummary vs = new VoteSummary();
                    vs.setCandidateId(id);
                    vs.setCandidateName(name);
                    vs.setBattingCount(btc);
                    vs.setBowlingCount(bwc);
                    vs.setWicketKeeperCount(wc);
                    vs.setAllRounderCount(ar);
                    
                    
                    list.add(vs);
		        }  
		        return list;  
		        }  
		      });*/
		  
