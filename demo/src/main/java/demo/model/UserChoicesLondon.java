package demo.model;

public class UserChoicesLondon extends UserChoices {
	
	private String arsenalTv; // does thymeleaf work with interfaces? check
	private String chelseaTv;
	
	public String getArsenalTv() {
		return arsenalTv;
	}
	public void setArsenalTv(String arsenalTv) {
		this.arsenalTv = arsenalTv;
	}
	public String getChelseaTv() {
		return chelseaTv;
	}
	public void setChelseaTv(String chelseaTv) {
		this.chelseaTv = chelseaTv;
	}
}