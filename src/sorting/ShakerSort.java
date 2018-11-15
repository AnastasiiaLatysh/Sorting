package sorting;


class ShakerSort {

    static double amountOfcomparisons;
    static double amountOfassigns;

    static void shakerSort(int array[]) {
        amountOfcomparisons = 0;
        amountOfassigns = 0;
        boolean swapped = false;
        int temp;
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                amountOfcomparisons += 1;
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    amountOfassigns += 3;
                    swapped = true;
                }
            }
            right--;

            if (swapped) {
                swapped = false;
                for (int i = right; i > left; i--) {
                    amountOfcomparisons += 1;
                    if (array[i] < array[i - 1]) {
                        temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        amountOfassigns += 3;
                        swapped = true;
                    }
                }
                left++;
            }
        } while (left <right && swapped);
        System.out.println("Amount of comparisons is: " + amountOfcomparisons);
        System.out.println("Amount of assigns is: " + amountOfassigns);
        System.out.println();
    }
}
