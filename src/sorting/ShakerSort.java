package sorting;


class ShakerSort extends AbstractSort {

    private double amountOfComparisons;
    private double amountOfAssigns;

    @Override
    void sort(int array[]) {

        amountOfComparisons = 0;
        amountOfAssigns = 0;
        boolean swapped = false;
        int temp;
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                amountOfComparisons += 1;
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    amountOfAssigns += 3;
                    swapped = true;
                }
            }
            right--;

            if (swapped) {
                swapped = false;
                for (int i = right; i > left; i--) {
                    amountOfComparisons += 1;
                    if (array[i] < array[i - 1]) {
                        temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        amountOfAssigns += 3;
                        swapped = true;
                    }
                }
                left++;
            }
        } while (left < right && swapped);
    }

    @Override
    public double getAmountOfComparisons() {
        return amountOfComparisons;
    }

    @Override
    public double getAmountOfAssigns() {
        return amountOfAssigns;
    }

    @Override
    String getAlgorithmName() {
        return "Shaker sort!";
    }
}
