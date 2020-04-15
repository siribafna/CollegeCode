package part_one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_Part_One {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("//Users//siri//Desktop//books.txt");
		Scanner sc = new Scanner(file);
		AVLTree tree = new AVLTree();
		while (sc.hasNextLine()) {
			Book book = new Book(sc.nextLine());
			tree.insert(book); // insert book into tree
		}
	}
}
