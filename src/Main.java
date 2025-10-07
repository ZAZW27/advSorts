import sorts.Merge;
import sorts.Quick;
import sorts.Shell;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        menu();
    }

    private static void menu() {
        Scanner input = new Scanner(System.in);
        int[] myArray = null;
        int[] absoluteArray = createRandomArray();

        boolean run = true;

        showMenuOption();

        while (run) {
            int[] consistArr = absoluteArray;
            System.out.print("Enter your option: ");
            switch (getUserOption(input)) {
                case 0 -> {
                    System.out.println("\n=====> New Array <=====");
                    myArray = createRandomArray();
                }
                case 1 -> {
                    if (myArray != null) showArray(consistArr);
                    else System.out.println("Array belum dibuat!");
                }
                case 2 -> {
                    if (myArray != null) doMerge(consistArr);
                    else System.out.println("Array belum dibuat!");
                }
                case 3 -> {
                    if (myArray != null) doQuick(consistArr);
                    else System.out.println("Array belum dibuat!");
                }
                case 4 -> {
                    if (myArray != null) doShell(consistArr);
                    else System.out.println("Array belum dibuat!");
                }
                case 5 -> {
                    run = false;
                    System.out.println("Exiting...");
                }
                default -> {
                    System.out.println("Opsi tidak valid!");
                    showMenuOption();
                }
            }
        }

        input.close();
    }

    private static int getUserOption(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Masukkan angka yang valid: ");
            input.next(); // discard invalid input
        }
        return input.nextInt();
    }


    private static void showMenuOption(){
        System.out.println("\n==== Sorting Menu ====");
        System.out.println("0 - Create New Random Array");
        System.out.println("1 - Show Array");
        System.out.println("2 - Merge Sort");
        System.out.println("3 - Quick Sort");
        System.out.println("4 - Shell Sort");
        System.out.println("5 - Exit");
    }

    private static void showArray(int[] arr){
        System.out.print("[");
        for(int num : arr){
            System.out.print(num + ", ");
        }
        System.out.println("]");
    }

    private static int[] createRandomArray(){
        int arrLength = 10000;

        int[] myArray = new int[arrLength];
        Random rand = new Random();
        for(int i = 0; i < arrLength; i++){
            myArray[i] = rand.nextInt(arrLength);
        }

        showArray(myArray);

        return myArray;
    }

    private static void doMerge(int[] arr){
        System.out.println("\n=========== Original Array ===========");
        showArray(arr);
        System.out.println("\n============ Merge Sorted ============");

        long startTime = System.nanoTime();
        Merge.mergeSort(arr);
        String timeTaken = timeSpent(System.nanoTime() - startTime);

        showArray(arr);

        System.out.println(timeTaken);
    }

    private static void doQuick(int[] arr){
        System.out.println("\n=========== Original Array ===========");
        showArray(arr);
        System.out.println("\n============ Quick Sorted ============");

        long startTime = System.nanoTime();
        Quick.quickSort(arr, 0, arr.length - 1);
        String timeTaken = timeSpent(System.nanoTime() - startTime);

        showArray(arr);
        System.out.println(timeTaken);
    }

    private static void doShell(int[] arr){
        System.out.println("\n=========== Original Array ===========");
        showArray(arr);
        System.out.println("\n============ Shell Sorted ============");

        long startTime = System.nanoTime();
        Shell.shellSort(arr);
        String timeTaken = timeSpent(System.nanoTime() - startTime);

        showArray(arr);
        System.out.println(timeTaken);
    }

    public static String timeSpent(long nanotime){
        return String.format("%06.2f ms%n", (nanotime) / 1_000_000.0);
    }
}

