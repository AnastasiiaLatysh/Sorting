package sorting;

import java.util.Random;


class ArrayCreator {


    static int[] generateArrayWithRandomElements(int n){
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            array[i] = random.nextInt(n);
        }
        return array;
    }

    static int[] generateArrayWithSortedASCElements(int n){
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
        {
            array[i] = i;
        }
        return array;
    }

    static int[] generateArrayWithSortedDESCElements(int n){
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
        {
            array[i] = n - i;
        }
        return array;
    }
}
