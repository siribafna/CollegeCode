import java.util.ArrayList;
import java.util.List;

/*
 * BST class includes all the functions necessary to traverse and manipulate the binary search tree including all CRUD operations for the tree. 
 */

class bst {

	Node root;
	List<Record> records; // returns when get_records is called

	private class Node {
		String keyword;
		Record record;
		int size;
		Node left;
		Node right;

		private Node(String k, Record r) {
			keyword = k;
			record = r;
			left = null;
			right = null;
		}

		private void update(Record r) { // updates and adds to the beginning of the linked list by shifting the pointers
			if (this.record == null) {
				this.record = r;
			}
			r.next = this.record;
			this.record = r;
		}
	}

	public bst() {
		this.root = null;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(String keyword, FileData fd) {
		Record recordToAdd = new Record(fd.id, fd.title, fd.author, null); // new record that is going to be added
		root = insertRecord(root, keyword, recordToAdd); // calls insertRecords method as it inserts to all the binary
															// tree
	}

	public Node insertRecord(Node root, String keyword, Record recordToAdd) {
		if (root == null) {
			root = new Node(keyword, recordToAdd); // instantiates new node
			return root;
		}
		if (root.keyword.compareTo(keyword) == 0) {
			recordToAdd.next = root.record; // adds to the new linked list by making current = to the next
			root.record = recordToAdd; // and next new = current
		}
		if (root.keyword.compareTo(keyword) < 0) { // necessary to traverse through entire binary tree
			root.left = insertRecord(root.left, keyword, recordToAdd);
		} else if (root.keyword.compareTo(keyword) > 0) {
			root.right = insertRecord(root.right, keyword, recordToAdd);
		}

		return root;
	}

	public boolean contains(String keyword) {
		if (root.keyword.equalsIgnoreCase(keyword)) { // tests to see if it contains it
			return true;
		} else if (root.keyword.compareTo(keyword) < 0) {
			root = root.left;
			contains(keyword);
		} else if (root.keyword.compareTo(keyword) > 0) {
			root = root.right;
			contains(keyword);
		}
		return false;
	}

	public List<Record> get_records(String keyword) {
		records = new ArrayList<>(); // creates new array
		records.clear(); // clears it
		records = get_r(root, keyword, records); // calls the get r function and returns to user
		return records;
	}

	public List<Record> get_r(Node temp, String keyword, List<Record> records) {
		// If the keyword is not in the bst, it should return null.
		if (temp == null) {
			return null; // if null, returns null
		}
		if (temp.keyword.equalsIgnoreCase(keyword)) {
			records.add(temp.record); // adds to the linked list if found
		}
		if (temp.keyword.compareTo(keyword) < 0) { // else continues traversing
			temp = temp.left;
			get_r(temp, keyword, records);
		}
		if (temp.keyword.compareTo(keyword) > 0) {
			temp = temp.right;
			get_r(temp, keyword, records);
		}

		return records;
	}

	public void delete(String keyword) {

		root = deleteRecord(root, keyword); // calls deleteRecords function

	}

	public Node deleteRecord(Node root, String keyword) {

		if (root == null) { // if null, returns null
			return root;
		}

		if (root.keyword.compareTo(keyword) < 0) { // traversing through the tree
			root.left = deleteRecord(root.left, keyword);
		} else if (root.keyword.compareTo(keyword) > 0) {
			root.right = deleteRecord(root.right, keyword);

		} else {

			if (root.left == null) {
				// root.record = null;
				return root.right;
			} else if (root.right == null) {
				// root.record = null;
				return root.left;
			}

			root.keyword = lowestNode(root.right); // finds the lowest node
			root.right = deleteRecord(root.right, root.keyword);
		}
		// root.record = null;
		return root;
	}

	public String lowestNode(Node root) { // to find the lowest node to replace with

		String word = root.keyword;

		while (root.left != null) {
			word = root.left.keyword;
			root = root.left;
		}
		return word;
	}

	public void print() {
		print(root);
	}

	private void print(Node t) { // print function given
		if (t != null) {
			print(t.left);
			System.out.println(t.keyword);
			Record r = t.record;
			while (r != null) {
				System.out.printf("\t%s\n", r.title);
				r = r.next;
			}
			print(t.right);
		}
	}
}