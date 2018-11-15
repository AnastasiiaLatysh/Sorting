package sorting;

import java.util.ArrayList;
import java.util.List;


class BucketSort extends AbstractSort {

    private double amountOfComparisons;
    private double amountOfAssigns;

    @Override
    void sort(int array[]) {
        amountOfComparisons = 0;
        amountOfAssigns = 0;

        int n = array.length;
        int i = 0;
        int minValue = getMin(array);
        int maxValue = getMax(array);

        List<List<Integer>> buckets = new ArrayList<>();

        // Add buckets
        for (int j = 0; j < n; j++) {
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
            buckets.get((int) (n * bucketNumber)).add(array[i]);
            amountOfAssigns += 1;
            amountOfComparisons += 1;
            i++;

        }
        amountOfComparisons += 1;

        // AbstractSort values inside buckets
        i = 0;
        InsertionSort insertionSort = new InsertionSort();
        while (i < buckets.size()){
            insertionSort.sort(buckets.get(i));
            amountOfAssigns = amountOfAssigns + insertionSort.getAmountOfAssigns();
            amountOfComparisons = amountOfComparisons + insertionSort.getAmountOfComparisons();
            i++;
        }

        // Move values from bucket to array
        int currentIndex = 0;
        for (int j = 0; j < buckets.size(); j++) {
            for (int k = 0; k < buckets.get(j).size(); k++) {
                array[currentIndex++] = buckets.get(j).get(k);
                amountOfAssigns += 1;
            }
        }
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

    @Override
    double getAmountOfAssigns() {
        return amountOfAssigns;
    }

    @Override
    double getAmountOfComparisons() {
        return amountOfComparisons;
    }

    @Override
    String getAlgorithmName() {
        return "Bucket sort!";
    }
}
