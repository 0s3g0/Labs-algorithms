package lab04;

import java.util.Random;

public class ArrayGenerator {
    private static final Random rnd = new Random();


    public static int[] generateRandom(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = rnd.nextInt(1000);
        }
        return arr;
    }

    public static int[] generateSorted(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReversed(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = size - 1 - i;
        }
        return arr;
    }

    public static int[] generatePartiallySorted(int size, double ratio){
        int[] arr = generateSorted(size);

        int startIndex = (int) Math.round(ratio * size);

        for(int i = size - 1; i > startIndex; i--){
            int j = startIndex + rnd.nextInt(i - startIndex + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

}
