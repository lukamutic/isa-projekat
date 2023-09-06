package isa.entity;

public class AdDto {
	
	private Ad ad;
	private User user;
	
	public AdDto() {
		super();
	}

	public AdDto(Ad ad, User user) {
		super();
		this.ad = ad;
		this.user = user;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
