package dd;
//JavaBEan
public class Coder {
	private  String firstName;
	private  String lastName; 
	private int coderID;
		
	public Coder(int coderID, String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.coderID = coderID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int getCoderID() {
		return coderID;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setCoderID(int coderID) {
		this.coderID = coderID;
	}

	@Override
	public String toString() {
		return "Coder [firstName=" + firstName + ", lastName=" + lastName + ", coderID=" + coderID + "]";
	}
	
	
	

	
}
