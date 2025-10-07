import sorts.Merge;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        int arrLength = 10;

        int[] myArray = new int[arrLength];
        Random rand = new Random();
        for(int i = 0; i < arrLength; i++){
            myArray[i] = rand.nextInt(arrLength);
        }

        System.out.println("Before");
        for(int num : myArray){
            System.out.println(num);
        }

        Merge.mergeSort(myArray);

        System.out.println("After");
        for(int num : myArray){
            System.out.println(num);
        }
    }
}

