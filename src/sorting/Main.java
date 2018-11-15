package sorting;

public class Main {

    public static void main(String[] args) {

        int[] arraySize = new int[]{1000, 10000, 100000};

        for(int size: arraySize){
            SortExperiment.startExperimentForSortedDESCArray(size);
            SortExperiment.startExperimentForRandomSortedArray(size);
            SortExperiment.startExperimentForSortedASCArray(size);
        }
    }
}
