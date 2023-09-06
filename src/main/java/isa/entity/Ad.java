package isa.entity;

import java.sql.Date;

public class Ad {
	
	private int id;
	private int userId;
	private int categoryId;
	private Date date;
	private String title;
	private String description;
	private double price;
	private boolean active;
	 
	public Ad() {
		super();
	}

	public Ad(int userId, int categoryId, Date date, String title, String description, double price, boolean active) {
		super();
		this.userId = userId;
		this.categoryId = categoryId;
		this.date = date;
		this.title = title;
		this.description = description;
		this.price = price;
		this.active = active;
	}

	public Ad(int id, int userId, int categoryId, Date date, String title, String description, double price,
			boolean active) {
		super();
		this.id = id;
		this.userId = userId;
		this.categoryId = categoryId;
		this.date = date;
		this.title = title;
		this.description = description;
		this.price = price;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + " " + title + " " + description + " " + price;
	}
}
