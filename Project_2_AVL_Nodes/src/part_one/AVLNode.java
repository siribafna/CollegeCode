package part_one;

public class AVLNode {
	long key;
	Book value;
	int height;
	AVLNode leftPtr;
	AVLNode rightPtr;

	AVLNode(long key, Book value) { // initializes node
		this.key = key;
		this.value = value;
	}
}
