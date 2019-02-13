package com.kaushik.vote1.model;

import java.sql.Timestamp;

public class Cast {

		private int userID;
		private int candidateID;
		private Timestamp dateTime;
		private String role;
		private int candidateID1,candidateID2,candidateID3,candidateID4;
		
		
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public int getCandidateID() {
			return candidateID;
		}
		public void setCandidateID(int candidateID) {
			this.candidateID = candidateID;
		}
		public Timestamp getDateTime() {
			return dateTime;
		}
		public void setDateTime(Timestamp dateTime) {
			this.dateTime = dateTime;
		}
				
		public int getCandidateID1() {
			return candidateID1;
		}
		public void setCandidateID1(int candidateID1) {
			this.candidateID1 = candidateID1;
		}
		public int getCandidateID2() {
			return candidateID2;
		}
		public void setCandidateID2(int candidateID2) {
			this.candidateID2 = candidateID2;
		}
		public int getCandidateID3() {
			return candidateID3;
		}
		public void setCandidateID3(int candidateID3) {
			this.candidateID3 = candidateID3;
		}
		public int getCandidateID4() {
			return candidateID4;
		}
		public void setCandidateID4(int candidateID4) {
			this.candidateID4 = candidateID4;
		}
		@Override
		public String toString() {
			return "Cast [userID=" + userID + ", candidateID=" + candidateID + ", dateTime=" + dateTime + ", role="
					+ role + ", candidateID1=" + candidateID1 + ", candidateID2=" + candidateID2 + ", candidateID3="
					+ candidateID3 + ", candidateID4=" + candidateID4 + "]";
		}
		
		
}
