package sorts;

public class MyUtil {
    public static void timeSpent(long nano) {
        System.out.printf("Time spent: %.2f ms%n", (nano / 1_000_000.0));
    }

    public static void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public static void highlightArray(int[] arr, int pos1, int pos2) {
        final String YELLOW_BG = "\u001B[33m";
        final String RESET = "\u001B[0m";
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            if (i == pos1 || i == pos2) {
                System.out.print(YELLOW_BG + arr[i] + RESET);
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}
