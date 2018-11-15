package sorting;


import java.util.List;

class InsertionSort extends AbstractSort {

    private double amountOfComparisons;
    private double amountOfAssigns;

    void sort(List<Integer> arr) {
        amountOfComparisons = 0;
        amountOfAssigns = 0;

        int n = arr.size();

        for (int i = 1; i < n; ++i) {
            amountOfComparisons += 1;
            int key = arr.get(i);
            int j = i - 1;
            amountOfAssigns += 1;

            while (j >= 0 && arr.get(j) > key) {
                amountOfComparisons++;
                arr.set(j + 1, arr.get(j));
                j = j - 1;
                amountOfAssigns += 1;
            }
            amountOfComparisons += 1;
            arr.set(j + 1, key);
            amountOfAssigns += 1;
        }
        amountOfComparisons+= 1;
    }

    @Override
    void sort(int[] array) {

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
        return "Insertion sort!";
    }
}
