package PojoClassGenericUtility;

import java.util.Random;

public class AddProjectPojoClass {
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	int ran=new Random().nextInt(500);
	public AddProjectPojoClass(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName+ran;
		this.status = status;
		this.teamSize = teamSize;
		
	}
	public AddProjectPojoClass()
	{
		
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	

}
