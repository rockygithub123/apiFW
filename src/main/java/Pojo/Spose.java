package Pojo;

public class Spose {
	String name;
	String empid;
	String phno;
	String add;
	public Spose(String name, String empid, String phno, String add) {
		
		this.name = name;
		this.empid = empid;
		this.phno = phno;
		this.add = add;
	}
	public Spose()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}


}
