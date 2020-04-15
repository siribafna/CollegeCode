package part_two;

import java.util.Random;

import part_two.Main_Part_Two.Height;

public class BSTTree {

	public static boolean isBalanced(BSTNode root) {
		int leftHeight;
		int rightHeight;

		if (root == null)
			return true;

		leftHeight = height(root.left);
		rightHeight = height(root.right);

		if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;
	}

	public static boolean isBST(BSTNode node) {
		return (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) && (isBalanced(node));
	}

	public static boolean isBST(BSTNode node, int min, int max) {

		if (node == null)
			return true;

		if (node.value < min || node.value > max)
			return false;

		return (isBST(node.left, min, node.value - 1) && isBST(node.right, node.value + 1, max));
	}

	public static int height(BSTNode node) {
		if (node == null)
			return 0;

		return 1 + max(height(node.left), height(node.right));
	}

	public static int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	public static boolean checkAVLProperty(BSTNode root, Height height) {
		if (root == null) {
			height.height = 0;
			return true;
		}

		Height leftHeight = new Height();
		Height rightHeight = new Height();

		boolean isLeft = checkAVLProperty(root.left, leftHeight);
		boolean isRight = checkAVLProperty(root.right, rightHeight);
		int leftHeightInt = leftHeight.height;
		int rightHeightInt = rightHeight.height;
		if (Math.abs(leftHeightInt - rightHeightInt) >= 2)
			return false;
		else
			return (isLeft && isRight);
	}

	public static boolean checkBSTOrderProperty(BSTNode root) {
		return BSTTree.isBST(root);
	}

	public static void insert(BSTNode root, int key) {
		Random rand = new Random();
		int num = rand.nextInt(2);
		if (num == 0) {
			if (root.left != null) {
				insert(root.left, key);
				return;
			} else {
				BSTNode temp = new BSTNode(key);
				root.left = temp;
				return;
			}
		}

		else {
			if (root.right != null) {
				insert(root.right, key);
				return;
			} else {
				BSTNode temp = new BSTNode(key);
				root.right = temp;
				return;
			}
		}
	}
}
