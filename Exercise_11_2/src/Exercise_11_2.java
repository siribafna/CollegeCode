
/*
 * In Class Assignment #3 
 * 10.02.2019
 * Siri Bafna
 * Purpose: To create classes and instances, practicing inheritance 
 */


public class Exercise_11_2 {
	public static void main(String[] args) {
		
		// creating a new instance of all the classes and fills in the necessary constructors, along with their super constructors
		Person person = new Person ("Siri Bafna", "5445 Legacy Dr.", "9727477365", "ssb170001@utdallas.edu");
		Student student = new Student("Bob Smith", "1234 Windrose Dr.", "9847284928", "bobsmith@gmail.com", "Sophomore");
		Employee employee = new Employee("Zach Johnson", "4364 Waterview Dr.", "5738294729", "zachm@gmail.com", "Frisco", 120000);
		Faculty faculty = new Faculty("Maria", "423 Legacy Dr.", "9864823782", "maria@gmail.com", "Plano", 20000, "9pm to 5pm", "Principal");
		Staff staff = new Staff("John Smith", "587 Copper Point Ln.", "7940972839", "johnsmith@gmail.com", "Frisco", 56000, "Vice President");

		//presents the data of a class through toString();
		System.out.println("Person Class: ");
		System.out.println(person.toString());
		System.out.println(student.toString());
		System.out.println(employee.toString());
		System.out.println(faculty.toString());
		System.out.println(staff.toString());
	}
	

}