package part_one;

public class AVLTree {
	private AVLNode root;

	public AVLTree() {
		root = null;
	}

	public void insert(Book book) {
		root = insert(book, root);
	}

	private int height(AVLNode node) {
		return node == null ? -1 : node.height;
	}

	private int max(int left, int right) {
		return left > right ? left : right;
	}

	private AVLNode insert(Book book, AVLNode top) {
		if (top == null)
			top = new AVLNode(book.isbn, book);
		else if (book.isbn < top.value.isbn) {
			top.leftPtr = insert(book, top.leftPtr);
			if (height(top.leftPtr) - height(top.rightPtr) == 2) {
				System.out.print("Imbalance occurred at inserting ISBN " + book.isbn + ": " + book.title);
				if (book.isbn < top.leftPtr.value.isbn) {
					System.out.println("; fixed in Left Rotation");
					top = rotateWithLeftChild(top);
				}

				else {
					System.out.println("; fixed in Right-Left Rotation");
					top = doubleWithLeftChild(top);
				}
			}
		} else if (book.isbn > top.value.isbn) {
			top.rightPtr = insert(book, top.rightPtr);
			if (height(top.rightPtr) - height(top.leftPtr) == 2) {
				System.out.print("Imbalance occurred at inserting ISBN " + book.isbn + ": " + book.title);
				if (book.isbn > top.rightPtr.value.isbn) {
					System.out.println("; fixed in Right Rotation");
					top = rotateWithRightChild(top);
				} else {
					System.out.println("; fixed in Left-Right Rotation");
					top = doubleWithRightChild(top);
				}
			}
		}

		top.height = max(height(top.leftPtr), height(top.rightPtr)) + 1;

		return top;
	}

	private AVLNode rotateWithLeftChild(AVLNode node) {
		AVLNode rotated = node.leftPtr;
		node.leftPtr = rotated.rightPtr;
		rotated.rightPtr = node;
		node.height = max(height(node.leftPtr), height(node.rightPtr)) + 1;
		rotated.height = max(height(rotated.leftPtr), node.height) + 1;
		return rotated;
	}

	private AVLNode rotateWithRightChild(AVLNode node) {
		AVLNode rotated = node.rightPtr;
		node.rightPtr = rotated.leftPtr;
		rotated.leftPtr = node;
		node.height = max(height(node.leftPtr), height(node.rightPtr)) + 1;
		rotated.height = max(height(rotated.rightPtr), node.height) + 1;
		return rotated;
	}

	private AVLNode doubleWithLeftChild(AVLNode node) {
		node.leftPtr = rotateWithRightChild(node.leftPtr);
		return rotateWithLeftChild(node);
	}

	private AVLNode doubleWithRightChild(AVLNode node) {
		node.rightPtr = rotateWithLeftChild(node.rightPtr);
		return rotateWithRightChild(node);
	}

}
// At inserting N in the spare tree, Find -> Splay -> Insert or Insert -> Splay