
public class Faculty extends Employee {
	private String officeHours;
	private String rank;
	public Faculty(String name, String address, String phoneNumber, String emailAddress, String office, double salary,
			String officeHours, String rank) {
		
		super(name, address, phoneNumber, emailAddress, office, salary);
		// TODO Auto-generated constructor stub
		this.officeHours = officeHours;
		this.rank = rank;
	}
	

	public String toString() {
		return "\nFaculty Class: " + super.toString() + "\nOffice Hours: " + officeHours + "\nRank: " + rank;
	}
}
