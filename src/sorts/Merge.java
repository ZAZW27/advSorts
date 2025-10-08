package sorts;

public class Merge {

    /**
     * Public entry point for the merge sort algorithm.
     * This method sets up the visual output and times the sorting process.
     */
    public static void mergeSort(int[] arr) {
        System.out.println("======== Original array ========");
        displayArray(arr, -1, -1); // No highlight for original
        System.out.println("\n===============================");

        long startTime = System.nanoTime();
        // A mutable integer array to pass the step count by reference
        int[] step = {1};
        divide(arr, step);
        timeSpent(System.nanoTime() - startTime);

        System.out.println("\n======== Final Sorted array ========");
        displayArray(arr, -1, -1); // No highlight for final
        System.out.println("\n===================================");
    }

    /**
     * Recursively divides the array into halves until subarrays have one or zero elements.
     */
    private static void divide(int[] arr, int[] step) {
        int length = arr.length;
        if (length <= 1) return; // Base case for recursion

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        // Populate left and right subarrays
        for (int i = 0; i < middle; i++) {
            leftArray[i] = arr[i];
        }
        for (int i = middle; i < length; i++) {
            rightArray[i - middle] = arr[i];
        }

        // Recurse on the two halves
        divide(leftArray, step);
        divide(rightArray, step);

        // Merge the sorted halves back together
        merge(leftArray, rightArray, arr, step);
    }

    /**
     * Merges two sorted subarrays into one larger sorted array.
     * This is where the visualization for each step happens.
     */
    private static void merge(int[] leftArray, int[] rightArray, int[] mainArray, int[] step) {
        // --- VISUALIZATION START ---
        System.out.println("Step " + step[0]++ + ": Merging");
        System.out.print("  Left sub-array: ");
        displayArray(leftArray, -1, -1);
        System.out.print("\n  Right sub-array: ");
        displayArray(rightArray, -1, -1);
        System.out.println();
        // --- VISUALIZATION END ---

        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int mainIdx = 0, leftIdx = 0, rightIdx = 0;

        // Compare elements from left and right arrays and merge into main array
        while (leftIdx < leftSize && rightIdx < rightSize) {
            if (leftArray[leftIdx] <= rightArray[rightIdx]) {
                mainArray[mainIdx++] = leftArray[leftIdx++];
            } else {
                mainArray[mainIdx++] = rightArray[rightIdx++];
            }
        }

        // Copy any remaining elements from the left array
        while (leftIdx < leftSize) {
            mainArray[mainIdx++] = leftArray[leftIdx++];
        }

        // Copy any remaining elements from the right array
        while (rightIdx < rightSize) {
            mainArray[mainIdx++] = rightArray[rightIdx++];
        }

        // --- VISUALIZATION START ---
        System.out.print("  Result of merge -> ");
        // Highlight the entire merged array in yellow to show the result
        displayArray(mainArray, 0, mainArray.length - 1);
        System.out.println("\n");
        // --- VISUALIZATION END ---
    }

    // ===============================================================
    // UTILITIES (copied from your Quick.java)
    // ===============================================================
    private static void timeSpent(long nano) {
        System.out.printf("Time spent: %.2f ms", (nano / 1_000_000.0));
    }

    /**
     * Displays the array. If start and end indices are provided, it highlights
     * all elements within that range.
     */
    private static void displayArray(int[] arr, int highlightStart, int highlightEnd) {
        final String YELLOW_BG = "\u001B[33m"; // To highlight merged results
        final String RESET = "\u001B[0m";

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");

            if (i >= highlightStart && i <= highlightEnd) {
                System.out.print(YELLOW_BG + arr[i] + RESET);
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}