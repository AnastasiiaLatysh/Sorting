package sorting;

import java.util.ArrayList;

class SortExperiment {

    private static ArrayList<AbstractSort> sortAlgorithms = new ArrayList<AbstractSort>() {{
        add(new HeapSort());
        add(new BucketSort());
        add(new ShakerSort());
    }};

    static void startExperimentForSortedASCArray(int n) {
        for (AbstractSort sortAlgorithm : sortAlgorithms) {
            int[] sortedASC = ArrayCreator.generateArrayWithSortedASCElements(n);
            System.out.println("\n\nSorted ASC array with " + n + " elements:");
            //printArray(sortedASC);
            System.out.println(sortAlgorithm.getAlgorithmName());
            sortAlgorithm.sort(sortedASC);
            //printArray(sortedASC);
            System.out.println("Amount of assigns: " + sortAlgorithm.getAmountOfAssigns());
            System.out.println("Amount of comparisons: " + sortAlgorithm.getAmountOfComparisons());
            System.out.println("Sorted ASC ended. \n\n\n");
        }
    }

    static void startExperimentForSortedDESCArray(int n) {
        for (AbstractSort sortAlgorithm : sortAlgorithms) {
            int[] sortedDESC = ArrayCreator.generateArrayWithSortedDESCElements(n);
            System.out.println("\n\nSorted DESC array with " + n + " elements:");
            //printArray(sortedDESC);
            System.out.println(sortAlgorithm.getAlgorithmName());
            sortAlgorithm.sort(sortedDESC);
            //printArray(sortedDESC);
            System.out.println("Amount of assigns: " + sortAlgorithm.getAmountOfAssigns());
            System.out.println("Amount of comparisons: " + sortAlgorithm.getAmountOfComparisons());
            System.out.println("Sorted DESC ended. \n\n\n");
        }
    }

    static void startExperimentForRandomSortedArray(int n) {
        for (AbstractSort sortAlgorithm : sortAlgorithms) {
            int[] randomSorted = ArrayCreator.generateArrayWithRandomElements(n);
            System.out.println("\n\nRandom sorted array with " + n + " elements:");
            //printArray(randomSorted);
            System.out.println(sortAlgorithm.getAlgorithmName());
            sortAlgorithm.sort(randomSorted);
            //printArray(randomSorted);
            System.out.println("Amount of assigns: " + sortAlgorithm.getAmountOfAssigns());
            System.out.println("Amount of comparisons: " + sortAlgorithm.getAmountOfComparisons());
            System.out.println("Random sorted ended. \n\n\n");
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
