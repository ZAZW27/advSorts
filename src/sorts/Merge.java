package sorts;
import java.io.*;

public class Merge {
    public static void mergeSort(int[] arr){
        breakDown(arr);
    }
    static void breakDown(int[] arr){
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

        breakDown(leftArray);

        breakDown(rightArray);

        merge(leftArray, rightArray, arr);
    }

    static void merge(int[] leftArray, int[] rightArray, int[] mainArray){
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0;
        int rightIdx = 0;
        int leftIdx = 0;

        while(leftIdx < leftSize && rightIdx < rightSize){
            if(leftArray[leftIdx] < rightArray[rightIdx]){
                mainArray[i] = leftArray[leftIdx];
                leftIdx++;
            }
            else{
                mainArray[i] = rightArray[rightIdx];
                rightIdx++;
            }
            i++;
        }

        while(leftIdx < leftSize){
            mainArray[i] = leftArray[leftIdx];
            i++;
            leftIdx++;
        }

        while(rightIdx < rightSize){
            mainArray[i] = rightArray[rightIdx];
            i++;
            rightIdx++;
        }
    }
}
