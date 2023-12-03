package com.metakeep.auditstore.bean;

public class AnalyticsDashboardBean {
	
	private int noOfUniqueUsers;
	private int noOfAPICalls;
	private int noOfFailures;
	public int getNoOfUniqueUsers() {
		return noOfUniqueUsers;
	}
	public void setNoOfUniqueUsers(int noOfUniqueUsers) {
		this.noOfUniqueUsers = noOfUniqueUsers;
	}
	public int getNoOfAPICalls() {
		return noOfAPICalls;
	}
	public void setNoOfAPICalls(int noOfAPICalls) {
		this.noOfAPICalls = noOfAPICalls;
	}
	public int getNoOfFailures() {
		return noOfFailures;
	}
	public void setNoOfFailures(int noOfFailures) {
		this.noOfFailures = noOfFailures;
	}
	

}
