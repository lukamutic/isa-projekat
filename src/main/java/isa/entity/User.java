package isa.entity;

public class User {
	
	private int id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private String role;
	private boolean active;
	
	public User() {
		super();
	}
	
	public User(String name, String phone, String email, String password, String role, boolean active) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
	}
	
	public User(int id, String name, String phone, String email, String password, String role, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}
