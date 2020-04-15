import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class test {

	BufferedReader b;
	bst a;

	/*
	 * Returns the next data record (a whole record object) in the data input file.
	 * Returns null if there is not such record. Hence a null indicates end of file
	 * or some error Error message will be displayed on the screen. DO NOT CHANGE
	 * THIS FUNCTION!
	 */
	public FileData readNextRecord() {
		if (b == null) {
			System.out.println("Error: You must open the file first.");
			return null;
		} else {
			FileData readData;
			try {
				String data = b.readLine();
				if (data == null)
					return null;
				int readNo = Integer.parseInt(data);
				readData = new FileData(readNo, b.readLine(), b.readLine(), Integer.parseInt(b.readLine()));
				for (int i = 0; i < readData.keywords.length; i++) {
					readData.addKeyword(b.readLine());
				}
				String space = b.readLine();
				if ((space != null) && (!space.trim().equals(""))) {
					System.out.println("Error in file format");
					return null;
				}
			} catch (NumberFormatException e) {
				System.out.println("Error Number Expected! ");
				return null;
			} catch (Exception e) {
				System.out.println("Fatal Error: " + e);
				return null;
			}
			return readData;
		}
	}

	public test(String filename) {
		try {

			this.a = new bst();
			this.b = new BufferedReader(new FileReader(filename));

			/* READS DATAFILE.TXT INTO DATASTRUCTURE */

			FileData fd;
			while ((fd = this.readNextRecord()) != null) {
				for (int i = 0; i < fd.keywords.length; i++) {
					a.insert(fd.keywords[i], fd);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (b != null)
					b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String args[]) {

		// PART 2
		test T = new test("datafile.txt");
		List<Record> records = new ArrayList<>();
		records = T.a.get_records("image-retrieval");
//		for (Record e : records) {
//			while (e != null) {
//				e.print();
//				e = e.next;
//			}
//			// if (e.next != null) {
//			// System.out.print("Hey");
//			// }
//		}
////
//
////		if (T.a.contains("medical"))
////			System.out.println("Hey!");// Prints titles of all elements in the bst sorted by keyword.
////		else
////			System.out.println("Not");
//////
////
////		System.out.println(T.a.root);
		T.a.delete("medical");
		T.a.delete("recognition");
		T.a.delete("learning");
		T.a.delete("concepts");

		T.a.print();
		// THIS AREA IS FOR YOUR USE TO HELP TEST THAT YOUR BST WORKS
		// T.a.print();
	}
}