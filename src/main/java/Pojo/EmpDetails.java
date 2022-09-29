package Pojo;

public class EmpDetails {
	String emName;
	String empid;
	int phNo;
	String empAdd;

	
	public EmpDetails(String emName, String empid, int phNo, String empAdd) {
		super();
		this.emName = emName;
		this.empid = empid;
		this.phNo = phNo;
		this.empAdd = empAdd;
	
		
	}
	public EmpDetails()
	{
		
	}
	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public int getPhNo() {
		return phNo;
	}
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}
	public String getEmpAdd() {
		return empAdd;
	}
	public void setEmpAdd(String empAdd) {
		this.empAdd = empAdd;
	}

	 

}
