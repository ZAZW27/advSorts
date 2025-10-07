package sorts;

public class Merge {
    public static void mergeSort(int[] arr) {
        if (arr.length > 10) {
            hugeSort(arr);
        } else {
            smallSort(arr);
        }
    }

    // ===============================================================
    // SMALL SORT (dengan highlight visualisasi)
    // ===============================================================
    static void smallSort(int[] arr) {
        System.out.println("======== Original array ========");
        displayArray(arr);
        System.out.println("\n===============================");
        long startTime = System.nanoTime();

        int[] temp = arr.clone();
        divide(temp, arr, 1, true); // step count mulai dari 1

        timeSpent(System.nanoTime() - startTime);
    }

    static void divide(int[] arr, int[] mainArr, int step, boolean visual) {
        int length = arr.length;
        if (length <= 1) return;

        int middle = (length / 2);
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0, j = 0;

        for (; i < length; i++) {
            if (i < middle) leftArray[i] = arr[i];
            else rightArray[j++] = arr[i];
        }

        divide(leftArray, mainArr, step, visual);
        divide(rightArray, mainArr, step, visual);

        merge(leftArray, rightArray, arr, mainArr, step, visual);
    }

    static void merge(int[] leftArray, int[] rightArray, int[] mainArray, int[] fullArr, int step, boolean visual) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0, rightIdx = 0, leftIdx = 0;

        while (leftIdx < leftSize && rightIdx < rightSize) {
            if (leftArray[leftIdx] < rightArray[rightIdx]) {
                mainArray[i] = leftArray[leftIdx++];
            } else {
                mainArray[i] = rightArray[rightIdx++];
            }

            if (visual && fullArr.length <= 10) {
                System.out.println("Step " + step++ + ": merging...");
                highlightArray(fullArr, mainArray[i]);
                System.out.println();
            }
            i++;
        }

        while (leftIdx < leftSize) {
            mainArray[i] = leftArray[leftIdx++];
            if (visual && fullArr.length <= 10) {
                System.out.println("Step " + step++ + ": merging...");
                highlightArray(fullArr, mainArray[i]);
                System.out.println();
            }
            i++;
        }

        while (rightIdx < rightSize) {
            mainArray[i] = rightArray[rightIdx++];
            if (visual && fullArr.length <= 10) {
                System.out.println("Step " + step++ + ": merging...");
                highlightArray(fullArr, mainArray[i]);
                System.out.println();
            }
            i++;
        }
    }

    // ===============================================================
    // HUGE SORT (tanpa highlight)
    // ===============================================================
    static void hugeSort(int[] arr) {
        long startTime = System.nanoTime();
        divideFast(arr);
        timeSpent(System.nanoTime() - startTime);
    }

    static void divideFast(int[] arr) {
        int length = arr.length;
        if (length <= 1) return;

        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        for (int i = 0; i < length; i++) {
            if (i < middle) left[i] = arr[i];
            else right[i - middle] = arr[i];
        }

        divideFast(left);
        divideFast(right);
        mergeFast(left, right, arr);
    }

    static void mergeFast(int[] left, int[] right, int[] arr) {
        int i = 0, l = 0, r = 0;
        while (l < left.length && r < right.length) {
            arr[i++] = (left[l] < right[r]) ? left[l++] : right[r++];
        }
        while (l < left.length) arr[i++] = left[l++];
        while (r < right.length) arr[i++] = right[r++];
    }

    // ===============================================================
    // UTILITIES
    // ===============================================================
    static void timeSpent(long nano) {
        System.out.printf("Time spent: %.2f ms%n", (nano / 1_000_000.0));
    }

    static void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    static void highlightArray(int[] arr, int highlightValue) {
        final String YELLOW_BG = "\u001B[33m";
        final String RESET = "\u001B[0m";
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            if (arr[i] == highlightValue) {
                System.out.print(YELLOW_BG + arr[i] + RESET);
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}
