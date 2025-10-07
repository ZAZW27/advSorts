package sorts;

public class Shell {
    public static void shellSort(int[] arr) {
        if (arr.length > 10) {
            hugeSort(arr);
        } else {
            smallSort(arr);
        }
    }

    // ===============================================================
    // SMALL SORT (dengan highlight)
    // ===============================================================
    private static void smallSort(int[] arr) {
        System.out.println("======== Original array ========");
        displayArray(arr);
        System.out.println("\n===============================");

        final String YELLOW_BG = "\u001B[33m";
        final String RESET = "\u001B[0m";

        long startTime = System.nanoTime();
        int n = arr.length;
        int step = 1;

        // Shell sort visual
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("\n--- Gap = " + gap + " ---");
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];

                    System.out.println("Step " + step++ + ": moving " + arr[j - gap] + " to position " + j);
                    highlightArray(arr, j, j - gap, YELLOW_BG, RESET);
                    System.out.println();

                    j -= gap;
                }

                arr[j] = temp;
                if (j != i) {
                    System.out.println("Step " + step++ + ": inserting " + temp + " at position " + j);
                    highlightArray(arr, j, i, YELLOW_BG, RESET);
                    System.out.println();
                }
            }
        }

        timeSpent(System.nanoTime() - startTime);
    }

    // ===============================================================
    // HUGE SORT (tanpa highlight)
    // ===============================================================
    private static void hugeSort(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }

        timeSpent(System.nanoTime() - startTime);
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

    private static void highlightArray(int[] arr, int pos1, int pos2, String color, String reset) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            if (i == pos1 || i == pos2) {
                System.out.print(color + arr[i] + reset);
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}
