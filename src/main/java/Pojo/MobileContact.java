package Pojo;

public class MobileContact {
	String fn;
	String ln;
	long[] num;
	String eMail;
	String[] relatedName;
	String companyName;
	String url;
	String add;
	String[] prof;
	Object family;
	public MobileContact(String fn, String ln, long[] num, String eMail, String[] relatedName, String companyName,
			String url, String add, String[] prof, Object family) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.num = num;
		this.eMail = eMail;
		this.relatedName = relatedName;
		this.companyName = companyName;
		this.url = url;
		this.add = add;
		this.prof = prof;
		this.family = family;
	}
	public MobileContact()
	{}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public long[] getNum() {
		return num;
	}
	public void setNum(long[] num) {
		this.num = num;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String[] getRelatedName() {
		return relatedName;
	}
	public void setRelatedName(String[] relatedName) {
		this.relatedName = relatedName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String[] getProf() {
		return prof;
	}
	public void setProf(String[] prof) {
		this.prof = prof;
	}
	public Object getFamily() {
		return family;
	}
	public void setFamily(Object family) {
		this.family = family;
	}
	

}
