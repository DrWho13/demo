package demo.model;

public class UserChoices {
	
	private String customerId;
	private boolean skyNews;
	private boolean skySportsNews;
	private boolean liverpoolTv;
	private boolean arsenalTv;
	private boolean chelseaTv;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public boolean isSkyNews() {
		return skyNews;
	}
	public void setSkyNews(boolean skyNews) {
		this.skyNews = skyNews;
	}
	public boolean isSkySportsNews() {
		return skySportsNews;
	}
	public void setSkySportsNews(boolean skySportsNews) {
		this.skySportsNews = skySportsNews;
	}
	public boolean isLiverpoolTv() {
		return liverpoolTv;
	}
	public void setLiverpoolTv(boolean liverpoolTv) {
		this.liverpoolTv = liverpoolTv;
	}
	public boolean isArsenalTv() {
		return arsenalTv;
	}
	public void setArsenalTv(boolean arsenalTv) {
		this.arsenalTv = arsenalTv;
	}
	public boolean isChelseaTv() {
		return chelseaTv;
	}
	public void setChelseaTv(boolean chelseaTv) {
		this.chelseaTv = chelseaTv;
	}
}