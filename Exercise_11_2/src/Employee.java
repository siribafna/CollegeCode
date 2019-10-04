
public class Employee extends Person{
	private String office;
	private double salary;
	private MyDate dateHired; 

	
	public Employee(String name, String address, String phoneNumber, String emailAddress, String office, double salary) {
		super(name, address, phoneNumber, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateHired = new MyDate();
	}
	
	public String getDateHired() {
		return dateHired.getMonth() + "/" + dateHired.getDay() 
				 + "/" + dateHired.getYear();
	}
	
	public String toString() {
		return "\nEmployee Class: " + super.toString() + "\nOffice: " + this.office + "\nSalary: $" + this.salary + "\nDate Hired: " + getDateHired();
	}
}
