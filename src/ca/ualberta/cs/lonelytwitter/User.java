package ca.ualberta.cs.lonelytwitter;

public class User {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// constructor
	public User (String n){
		super();
		name = n;
		
		
	}
	
	public User(){
		super();
		name = "anonymus";
	}
	
}
