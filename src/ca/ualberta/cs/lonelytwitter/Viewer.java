package ca.ualberta.cs.lonelytwitter;

public class Viewer extends User {
	public void setName(String name) {
		if (name.length() > 8){
			// Exception 
			throw new RuntimeException("Too long");
		}
		this.name = name;
	}
}
