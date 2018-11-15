package sorting;

class HeapSort {

    static double amountOfcomparisons;
    static double amountOfassigns;

    static void heapSort(int array[])
        {
            amountOfcomparisons = 0;
            amountOfassigns = 0;
            int n = array.length;

            buildMaxHeap(array, n);

            int heapSize = n;
            int i = n - 1;

            while (i > 0){
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                amountOfassigns += 3;
                buildMaxHeap(array, heapSize=heapSize - 1);
                i--;
                amountOfcomparisons += 1;

            }
            amountOfcomparisons += 1;

            System.out.println("Amount of comparisons is: " + amountOfcomparisons);
            System.out.println("Amount of assigns is: " + amountOfassigns);
            System.out.println();
        }

        private static void maxHeapify(int array[], int i, int n)
        {
            int largest;
            int left = 2 * (i + 1) - 1;
            int right = 2 * (i + 1);

            // If left child is larger than root
            if (left < n && array[left] > array[i]){
                largest = left;
            }
            else {
                largest = i;
            }

            // If right child is larger than largest
            if (right < n && array[right] > array[largest]){
                largest = right;
            }

            // If largest is not root
            if (largest != i)
            {
                int temp = array[i];
                array[i] = array[largest];
                array[largest] = temp;
                maxHeapify(array, largest, n);
            }
        }

        private static void buildMaxHeap(int[] array, int n){
            int i = n / 2;
            while (i >= 0){
                maxHeapify(array, i, n);
                i = i - 1;
            }
        }
}
