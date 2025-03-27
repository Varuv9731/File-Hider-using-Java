package model;

public class User {
	private String name;
	private String email;
	
	//empty constructor
	public User() {
		
	}
	//constructor setters
	public User(String name,String email) {
		this.name = name;
		this.email = email;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//getters
	public String getName() {
		return name;
	} 	 	
	public String getEmail() {
		return email;
	}
	
}
