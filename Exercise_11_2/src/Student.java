
public class Student extends Person{

	private final String status;
	public Student(String name, String address, String phoneNumber, String emailAddress, String status) {
		super(name, address, phoneNumber, emailAddress);
		this.status = status;
	}

	public String toString() {
		return "\nStudent Class: " + super.toString() + "\nStatus: " + this.status;
	}
		
}
