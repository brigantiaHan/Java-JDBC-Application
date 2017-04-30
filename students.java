
public class students {
	
	int authorID;
	String firstName,lastName;
	
	
	
	public students(int authorID, String firstName, String lastName) {
		
		this.authorID = authorID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
