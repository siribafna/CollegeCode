package part_one;

public class Book {
	long isbn;
	String title;
	String author;

	Book(String line) {

		String[] lines = line.split(" "); // splits to get each value
		this.isbn = Long.parseLong(lines[0]); // convert String into long
		this.title = lines[1];
		this.author = lines[2];

	}

}
