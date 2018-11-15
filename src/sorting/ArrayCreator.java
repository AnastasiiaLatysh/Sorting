package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


class ArrayCreator {


    static int[] generateArrayWithRandomElements(int n){
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    static int[] generateArrayWithSortedASCElements(int n){
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            array[i] = random.nextInt(1000);
        }
        Arrays.sort(array);
        return array;
    }

    static int[] generateArrayWithSortedDSCElements(int n){
        Integer[] array = new Integer[n];
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            array[i] = random.nextInt(1000);
        }

        Arrays.sort(array, Collections.reverseOrder());
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
}
