package sorting;


import java.util.List;

class InsertionSort {

    static void sort(List<Integer> arr) {
        int n = arr.size();

        for (int i = 1; i < n; ++i) {
            BucketSort.amountOfcomparisons += 1;
            int key = arr.get(i);
            int j = i - 1;
            BucketSort.amountOfassigns += 1;

            while (j >= 0 && arr.get(j) > key) {
                BucketSort.amountOfcomparisons++;
                arr.set(j + 1, arr.get(j));
                j = j - 1;
                BucketSort.amountOfassigns += 1;
            }
            BucketSort.amountOfcomparisons += 1;
            arr.set(j + 1, key);
            BucketSort.amountOfassigns += 1;
        }
        BucketSort.amountOfcomparisons+= 1;
    }
}
