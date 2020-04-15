package algo_analysis;

public class SelectionSort {
	static int movements;
	static int comparisons;

	void sort(int arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_idx])
					comparisons++;
				min_idx = j;
				movements++;
			}

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];

			arr[min_idx] = arr[i];
			movements++;
			arr[i] = temp;
			movements++;
		}
	}

	// Prints the array
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver code to test above
	public static void main(String args[]) {
		comparisons = 0;
		movements = 0;
		SelectionSort ob = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		long startTime = System.nanoTime();
		ob.sort(arr);
		long endTime = System.nanoTime();
		System.out.println("Sorted array");
		System.out.println(endTime - startTime);
		System.out.println(movements);
		System.out.println(comparisons);
		ob.printArray(arr);
	}
}
