package part_two;

import java.util.Random;

public class Main_Part_Two {

	public static class Height {
		int height = 0;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(50);
		BSTNode root = new BSTNode(num); //
		int numbers[] = new int[50];
		numbers[num] = 1;
		Height height = new Height();

		for (int i = 0; i < 10; i++) {
			while (true) { // FILLING ARRAY WITH RANDOM INTS
				num = rand.nextInt(50);
				if (numbers[num] == 0) {
					numbers[num] = 1;
					break;
				}
			}
			BSTTree.insert(root, num); // INSERT INTO TREE
		}

		// REPORTS OUT TO USER

		if (BSTTree.checkBSTOrderProperty(root)) {
			System.out.println("BST Order Property: WORKS");
		}

		else {
			System.out.println("BST Order Property: DOESN'T WORK");
		}

		if (BSTTree.checkAVLProperty(root, height)) {
			System.out.println("AVL Balance Condition: WORKS");
		}

		else {
			System.out.println("AVL Balance Condition: DOESN'T WORK");
		}
	}
}
