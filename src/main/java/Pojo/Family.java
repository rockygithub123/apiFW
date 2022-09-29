package Pojo;

public class Family {
	String name;
	String ph;
	String city;
	public Family(String name, String ph, String city) {
		super();
		this.name = name;
		this.ph = ph;
		this.city = city;
	}
	public Family()
	{}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
