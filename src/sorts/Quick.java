package sorts;

public class Quick {
    public static void quickSort(int[] array) {
        if (array.length > 10) {
            hugeSort(array);
        } else {
            smallSort(array);
        }
    }

    // ===============================================================
    // SMALL SORT (dengan highlight warna)
    // ===============================================================
    private static void smallSort(int[] array) {
        System.out.println("======== Original array ========");
        displayArray(array);
        System.out.println("\n===============================");

        long startTime = System.nanoTime();
        quickSortVisual(array, 0, array.length - 1, new int[]{1});
        timeSpent(System.nanoTime() - startTime);
    }

    private static void quickSortVisual(int[] array, int start, int end, int[] step) {
        if (end <= start) return;

        int pivotIndex = partitionVisual(array, start, end, step);
        quickSortVisual(array, start, pivotIndex - 1, step);
        quickSortVisual(array, pivotIndex + 1, end, step);
    }

    private static int partitionVisual(int[] array, int start, int end, int[] step) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                if (i != j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                    System.out.println("Step " + step[0]++ + ": Swapping " + array[i] + " and " + array[j]);
                    highlightArray(array, i, j, end);
                    System.out.println();
                }
            }
        }

        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        System.out.println("Step " + step[0]++ + ": Swapping pivot " + array[i] + " with " + array[end]);
        highlightArray(array, i, end, end);
        System.out.println();

        return i;
    }

    // ===============================================================
    // HUGE SORT (tanpa highlight)
    // ===============================================================
    private static void hugeSort(int[] array) {
        long startTime = System.nanoTime();
        quickSortFast(array, 0, array.length - 1);
        timeSpent(System.nanoTime() - startTime);
    }

    private static void quickSortFast(int[] array, int start, int end) {
        if (end <= start) return;

        int pivot = partitionFast(array, start, end);
        quickSortFast(array, start, pivot - 1);
        quickSortFast(array, pivot + 1, end);
    }

    private static int partitionFast(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

    // ===============================================================
    // UTILITIES
    // ===============================================================
    private static void timeSpent(long nano) {
        System.out.printf("Time spent: %.2f ms%n", (nano / 1_000_000.0));
    }

    private static void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    /**
     * Highlight elemen yang ditukar dengan KUNING, dan pivot dengan BIRU
     */
    private static void highlightArray(int[] arr, int pos1, int pos2, int pivotIndex) {
        final String YELLOW_BG = "\u001B[33m"; // untuk elemen swap
        final String BLUE_BG = "\u001B[44m";   // untuk pivot
        final String RESET = "\u001B[0m";

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");

            if (i == pivotIndex) {
                System.out.print(BLUE_BG + arr[i] + RESET);
            } else if (i == pos1 || i == pos2) {
                System.out.print(YELLOW_BG + arr[i] + RESET);
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}
