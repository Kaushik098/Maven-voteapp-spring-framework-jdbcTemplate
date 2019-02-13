package com.kaushik.vote1.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kaushik.vote1.dao.CandidateDAO;
import com.kaushik.vote1.model.Candidate;
import com.kaushik.vote1.model.Category;
import com.kaushik.vote1.util.ConnectionUtil;

public class CandidateDAOImpl implements CandidateDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public boolean isCandidateExists(Integer candidateId) {

		String sql = "Select 1 from category where candidate_id = ?";
		Object[] params = { candidateId };
		boolean exists = false;
		try {
			exists = jdbcTemplate.queryForObject(sql, params, Boolean.class);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		//System.out.println(exists);
		return exists;
	}

	public void newCandidate(Candidate candidate) {

		try {
			if (isCandidateExists(candidate.getCandidateId())) {
				throw new Exception("Candidate Already exists " + candidate.getCandidateId());
			} else {
				String sql1 = "INSERT INTO category(candidate_id, candidate_name, category_id, category_name) VALUES (?,?,?,?)";
				Object[] params = { candidate.getCandidateId(), candidate.getCandidateName(),
						candidate.getCategory().getId(), candidate.getCategory().getName() };

				int rows = jdbcTemplate.update(sql1, params);

				System.out.println(rows + " candidate added");
			}

		} catch (Exception ae) {
			ae.printStackTrace();
			System.err.println(ae.getMessage());
		}

	}

	public void deleteCandidate(int id) {

		try {
			String sql = "DELETE FROM category WHERE candidate_id = "+ id;
			int rows = jdbcTemplate.update(sql);
			System.out.println(rows + " row removed");
		} catch (Exception ae) {
			System.err.println(ae.getMessage());
		}

	}

	public List<Candidate> showCandidates() {

		List<Candidate> candidatesList = new ArrayList<>();
		try {
			String sql = "Select candidate_id, candidate_name, category_id, category_name from category";
		     candidatesList = jdbcTemplate.query(sql, (result, rowNo)->{
		    	 Candidate candidate;
				 Category ctg;
				
				 int candidateID = result.getInt("candidate_id"); 
				 String candidateName = result.getString("candidate_name");
				 int categoryID = result.getInt("category_id");
				 String categoryName = result.getString("category_name");
				 
				 ctg = new Category(categoryID , categoryName);

				 candidate = new Candidate();
				 
				 candidate.setCandidateId(candidateID);
				 candidate.setCandidateName(candidateName);
				 candidate.setCategory(ctg);
				
				 return candidate;
			});
		} catch (Exception ae) {
			System.err.println(ae.getMessage());
		}
		
		return candidatesList;
	}

	public List<Candidate> findById(Candidate find) {

		List<Candidate> candidateList = new ArrayList<>();
		try {
			String sql = "Select candidate_id, candidate_name, category_id, category_name from category where id = "+ find.getCandidateId();
			/*
			Object[] params = {find.getCandidateId()};*/
			System.out.println(find.getCandidateId());
			
		    candidateList = jdbcTemplate.query(sql,(result, rowNo)->{
		    	 Candidate candidate;
				 Category ctg;
			
				 System.out.println("hello");
				 int candidateID = result.getInt("candidate_id"); 
				 String candidateName = result.getString("candidate_name");
				 int categoryID = result.getInt("category_id");
				 String categoryName = result.getString("category_name");
				 
				 ctg = new Category(categoryID , categoryName);

				 candidate = new Candidate();
				 
				 candidate.setCandidateId(candidateID);
				 candidate.setCandidateName(candidateName);
				 candidate.setCategory(ctg);
				
				 return candidate;
				 
			});

			
		} catch (Exception ae) {
			System.err.println(ae.getMessage());
		}
		return candidateList;
	}

}
