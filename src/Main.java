import java.util.Random;

public class Main {
    public static void main(String[] args){
        int arrLength = 100;

        int[] myArray = new int[arrLength];
        Random rand = new Random();
        for(int i = 0; i < arrLength; i++){
            myArray[i] = rand.nextInt(arrLength);
        }

        for(int j = 0; j < myArray.length; j++){
            System.out.println(j + ". " + myArray[j]);
        }
    }
}

