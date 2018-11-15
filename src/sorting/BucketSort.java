package sorting;

import java.util.ArrayList;
import java.util.List;


public class BucketSort {

    static double amountOfcomparisons;
    static double amountOfassigns;
    static int amountOfBuckets = 10;

    static void bucketSort(int array[]) {
        amountOfcomparisons = 0;
        amountOfassigns = 0;

        int n = array.length;
        int i = 0;
        int minValue = getMin(array);
        int maxValue = getMax(array);

        List<List<Integer>> buckets = new ArrayList<>();

        // Add buckets
        for (int j = 0; j < amountOfBuckets; j++) {
            buckets.add(new ArrayList<>());
        }

        // clear buckets
        while (i < buckets.size()){
            clear(buckets.get(i));
            i++;
        }

        // add to buckets values
        i = 0;
        while (i < n){
            double bucketNumber = (double) (array[i] - minValue)/(maxValue - minValue + 1);
            buckets.get(getBucketIndex(bucketNumber)).add(array[i]);
            amountOfassigns += 1;
            amountOfcomparisons += 1;
            i++;

        }
        amountOfcomparisons += 1;

        // Sort values inside buckets
        i = 0;
        while (i < buckets.size()){
            InsertionSort.sort(buckets.get(i));
            i++;
        }

        // Move values from bucket to array
        int currentIndex = 0;
        for (int j = 0; j < buckets.size(); j++) {
            for (int k = 0; k < buckets.get(j).size(); k++) {
                array[currentIndex++] = buckets.get(j).get(k);
                amountOfassigns += 1;
            }
        }
        System.out.println("Amount of comparisons is: " + amountOfcomparisons);
        System.out.println("Amount of assigns is: " + amountOfassigns);
        System.out.println();
    }

    private static void clear(List<Integer> array){
            for (int i = 0; i < array.size(); i++)
                array.set(i, null);
        }

    private static int getMin(int[] array){
        int minValue = array[0];
        for (int k = 1; k < array.length; k++) {
            if (array[k] < minValue)
                minValue = array[k];
        }
        return minValue;
    }

    private static int getMax(int[] array){
        int maxValue = array[0];
        for (int k = 1; k < array.length; k++) {
            if(array[k] > maxValue)
                maxValue = array[k];
        }
        return maxValue;
    }

    private static int getBucketIndex(double scaleNumber){

        if (scaleNumber >= 0 && scaleNumber < 0.1)
                return 0;

        else if (scaleNumber >= 0.1 && scaleNumber < 0.2)
            return 1;

        else if (scaleNumber >= 0.2 && scaleNumber < 0.3)
            return 2;

        else if (scaleNumber >= 0.3 && scaleNumber < 0.4)
            return 3;

        else if (scaleNumber >= 0.4 && scaleNumber < 0.5)
            return 4;

        else if (scaleNumber >= 0.5 && scaleNumber < 0.6)
            return 5;

        else if (scaleNumber >= 0.6 && scaleNumber < 0.7)
            return 6;

        else if (scaleNumber >= 0.7 && scaleNumber < 0.8)
            return 7;

        else if (scaleNumber >= 0.8 && scaleNumber < 0.9)
            return 8;
        else if (scaleNumber >= 0.9 && scaleNumber < 1)
            return 9;
        else
            return -1;
    }
}
