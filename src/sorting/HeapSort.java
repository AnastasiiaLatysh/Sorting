package sorting;

class HeapSort extends AbstractSort {

    private double amountOfComparisons;
    private double amountOfAssigns;

    @Override
    void sort(int array[])
        {
            amountOfComparisons = 0;
            amountOfAssigns = 0;

            int n = array.length;

            buildMaxHeap(array, n);

            int heapSize = n;
            int i = n - 1;

            while (i > 0){
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                amountOfAssigns += 3;
                buildMaxHeap(array, heapSize=heapSize - 1);
                i--;
                amountOfComparisons += 1;

            }
            amountOfComparisons += 1;
        }

        private void maxHeapify(int array[], int i, int n)
        {
            int largest;
            int left = 2 * (i + 1) - 1;
            int right = 2 * (i + 1);

            // If left child is larger than root
            amountOfComparisons++;
            if (left < n && array[left] > array[i]){
                amountOfAssigns++;
                largest = left;
            }
            else {
                amountOfAssigns++;
                largest = i;
            }

            // If right child is larger than largest
            amountOfComparisons++;
            if (right < n && array[right] > array[largest]){
                amountOfAssigns++;
                largest = right;
            }

            // If largest is not root
            amountOfComparisons++;
            if (largest != i)
            {
                int temp = array[i];
                array[i] = array[largest];
                array[largest] = temp;
                amountOfAssigns = amountOfAssigns + 3;
                maxHeapify(array, largest, n);
            }
        }

        private void buildMaxHeap(int[] array, int n){
            int i = n / 2;
            while (i >= 0){
                maxHeapify(array, i, n);
                i = i - 1;
            }
        }

    @Override
    public double getAmountOfAssigns() {
        return amountOfAssigns;
    }

    @Override
    public double getAmountOfComparisons() {
        return amountOfComparisons;
    }

    @Override
    String getAlgorithmName() {
        return "Heap sort!";
    }
}
