import sorts.Merge;
import sorts.Quick;
import sorts.Shell;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        menu();
    }

    private static void menu(){
        int[] myArray = createRandomArray();

        boolean run = true;
        showMenuOption();

        while(run){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your option: ");
            switch (input.nextInt()){
                case 0:
                    System.out.println("\n=====> New Array <=====");
                    myArray = createRandomArray();
                    break;
                case 1:
                    showArray(myArray);
                    break;
                case 2:
                    doMerge(myArray);
                    break;
                case 3:
                    doQuick(myArray);
                    break;
                case 4:
                    doShell(myArray);
                    break;
                case 5:
                    run = false;
                    break;

                default:
                    System.out.println("Opsi tidak valid, cek kembali");
                    showMenuOption();
            }
        }
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
        int arrLength = 10;

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
        Merge.mergeSort(arr);
        showArray(arr);
    }

    private static void doQuick(int[] arr){
        System.out.println("\n=========== Original Array ===========");
        showArray(arr);

        System.out.println("\n============ Quick Sorted ============");
        Quick.quickSort(arr, 0, arr.length - 1);
        showArray(arr);
    }

    private static void doShell(int[] arr){
        System.out.println("\n=========== Original Array ===========");
        showArray(arr);

        System.out.println("\n============ Shell Sorted ============");
        Shell.shellSort(arr);
        showArray(arr);
    }
}

