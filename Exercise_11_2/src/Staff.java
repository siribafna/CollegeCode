
public class Staff extends Employee {
	private String title;
	
	public Staff(String name, String address, String phoneNumber, String emailAddress, String office, double salary,String title) {
		
		super(name, address, phoneNumber, emailAddress, office, salary);
		this.title = title;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "\nStaff: " + super.toString() + " \nTitle: " + title;
	}

	
}
