package com.kaushik.vote1.model;

public class VoteSummary {

	 private int candidateId;
	 private String candidateName;
	 private int count;
	 
	 private int battingCount;
	 private int bowlingCount;
	 private int wicketKeeperCount;
	 private int allRounderCount;
	
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
   }
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getBattingCount() {
		return battingCount;
	}
	public void setBattingCount(int battingCount) {
		this.battingCount = battingCount;
	}
	public int getBowlingCount() {
		return bowlingCount;
	}
	public void setBowlingCount(int bowlingCount) {
		this.bowlingCount = bowlingCount;
	}
	public int getWicketKeeperCount() {
		return wicketKeeperCount;
	}
	public void setWicketKeeperCount(int wicketKeeperCount) {
		this.wicketKeeperCount = wicketKeeperCount;
	}
	public int getAllRounderCount() {
		return allRounderCount;
	}
	public void setAllRounderCount(int allRounderCount) {
		this.allRounderCount = allRounderCount;
	}
	
	@Override
	public String toString() {
		return "VoteSummary [candidateId=" + candidateId + ", candidateName=" + candidateName + ", count=" + count
				+ ", battingCount=" + battingCount + ", bowlingCount=" + bowlingCount + ", wicketKeeperCount="
				+ wicketKeeperCount + ", allRounderCount=" + allRounderCount + "]";
	}
	
	
	
		 
}
