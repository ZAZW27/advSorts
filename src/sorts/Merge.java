package sorts;
import java.io.*;

public class Merge {
    public static void mergeSort(int[] arr){
        divide(arr);
    }

    static void divide(int[] arr){
        int length = arr.length;
        if (length <= 1)return;

        int middle = (length / 2);
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0, j = 0;

        for(; i < length; i++){
            if(i < middle) leftArray[i] = arr[i];
            else rightArray[j++] = arr[i];
        }

        divide(leftArray);

        divide(rightArray);

        merge(leftArray, rightArray, arr);
    }

    static void merge(int[] leftArray, int[] rightArray, int[] mainArray){
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0, rightIdx = 0, leftIdx = 0;

        while(leftIdx < leftSize && rightIdx < rightSize){
            if(leftArray[leftIdx] < rightArray[rightIdx]){
                mainArray[i++] = leftArray[leftIdx++];
            }
            else{
                mainArray[i++] = rightArray[rightIdx++];
            }
        }

        while(leftIdx < leftSize){
            mainArray[i++] = leftArray[leftIdx++];
        }

        while(rightIdx < rightSize){
            mainArray[i++] = rightArray[rightIdx++];
        }
    }
}
