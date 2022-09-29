package Pojo;

public class EmpDetailsWithObject {
	String emName;
	String empid;
	int[] phNo;
	String empAdd;
	Object spose;
	
	public EmpDetailsWithObject(String emName, String empid, int[] phNo, String empAdd, Object spose) {
		super();
		this.emName = emName;
		this.empid = empid;
		this.phNo = phNo;
		this.empAdd = empAdd;
		this.spose = spose;
		
	}
	public EmpDetailsWithObject()
	{}
	public String getEmName() {
		return emName;
	}
	/*public void setEmName(String emName) {
		this.emName = emName;
	}*/
	
	public String getEmpid() {
		return empid;
	}
	/*public void setEmpid(String empid) {
		this.empid = empid;
	}*/
	public int[] getPhNo() {
		return phNo;
	}
	public void setPhNo(int[] phNo) {
		this.phNo = phNo;
	}
	public String getEmpAdd() {
		return empAdd;
	}
	public void setEmpAdd(String empAdd) {
		this.empAdd = empAdd;
	}
	public Object getSpose() {
		return spose;
	}
	public void setSpose(Object spose) {
		this.spose = spose;
	}

	
	

}
