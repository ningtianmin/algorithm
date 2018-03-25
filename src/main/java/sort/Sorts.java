package sort;

import java.util.Arrays;

/**
 * @author NINGTIANMIN
 */
public class Sorts {
    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        for (int p = 1, length = array.length; p < length; p++) {
            T temp = array[p];
            int j = p;
            while (j > 0 && temp.compareTo(array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void shellSort(T[] array) {
        int length = array.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int p = gap; p < length; p++) {
                T temp = array[p];
                int i = p;
                while (i >= gap && temp.compareTo(array[i - gap]) < 0) {
                    array[i] = array[i - gap];
                    i -= gap;
                }
                array[i] = temp;
            }
        }
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            buildMaxHeap(array, i);
            T max = array[0];
            array[0] = array[i];
            array[i] = max;
        }
    }

    private static <T extends Comparable<? super T>> void buildMaxHeap(T[] array, int rightIndex) {
        for (int p = (rightIndex - 1) / 2; p >= 0; p--) {
            int greaterIndex = 2 * p + 1;
            if (greaterIndex + 1 <= rightIndex && array[greaterIndex].compareTo(array[greaterIndex + 1]) < 0) {
                greaterIndex++;
            }
            if (array[greaterIndex].compareTo(array[p]) > 0) {
                T temp = array[greaterIndex];
                array[greaterIndex] = array[p];
                array[p] = temp;
            }
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        mergeSort(array, leftIndex, midIndex);
        mergeSort(array, midIndex + 1, rightIndex);
        T[] tempArray = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
        int tempArraySecondIndex = midIndex + 1 - leftIndex;
        int i = 0, j = tempArraySecondIndex, p = leftIndex;
        while (i < tempArraySecondIndex && j < tempArray.length) {
            if (tempArray[i].compareTo(tempArray[j]) < 0) {
                array[p] = tempArray[i];
                i++;
            } else {
                array[p] = tempArray[j];
                j++;
            }
            p++;
        }
        if (i < tempArraySecondIndex) {
            System.arraycopy(tempArray, i, array, p, rightIndex - p + 1);
        } else {
            System.arraycopy(tempArray, j, array, p, rightIndex - p + 1);
        }
    }
}
