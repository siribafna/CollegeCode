package algo_analysis;

public class InsertionSort {

	static int comparisons;
	static int movements;

	/* Function to sort array using insertion sort */
	void sort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				comparisons++;
				arr[j + 1] = arr[j];
				movements++;
				j = j - 1;

			}
			arr[j + 1] = key;
			movements++;
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	// Driver method
	public static void main(String args[]) {
		comparisons = 0;
		movements = 0;
		int arr[] = { 12, 11, 13, 5, 6 };

		InsertionSort ob = new InsertionSort();
		long startTime = System.nanoTime();
		ob.sort(arr);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		System.out.println(movements);
		System.out.println(comparisons);
		printArray(arr);
	}
}
