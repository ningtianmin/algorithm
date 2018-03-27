package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortsTest {

    @Test
    void insertionSort() {
        Integer[] array = {5, 4, 3, 2, 1};
        Sorts.insertionSort(array);
        System.out.println(String.format("insertionSort:%s", Arrays.toString(array)));
        Assertions.assertTrue(SortUtil.isIncrementalSequence(array));
    }

    @Test
    void shellSort() {
        Integer[] array = {5, 4, 3, 2, 1};
        Sorts.shellSort(array);
        System.out.println(String.format("shellSort:%s", Arrays.toString(array)));
        Assertions.assertTrue(SortUtil.isIncrementalSequence(array));
    }

    @Test
    void heapSort() {
        Integer[] array = {5, 4, 3, 2, 1};
        Sorts.heapSort(array);
        System.out.println(String.format("heapSort:%s", Arrays.toString(array)));
        Assertions.assertTrue(SortUtil.isIncrementalSequence(array));
    }

    @Test
    void mergeSort() {
        Integer[] array = {5, 4, 3, 2, 1};
        Sorts.mergeSort(array);
        System.out.println(String.format("mergeSort:%s", Arrays.toString(array)));
        Assertions.assertTrue(SortUtil.isIncrementalSequence(array));
    }

    @Test
    void quickSort2Way() {
        Integer[] array;
        array = null;
        Assertions.assertTrue(SortUtil.isIncrementalSequence(Sorts.quickSort2Way(array)));
        array = new Integer[]{1};
        Assertions.assertTrue(SortUtil.isIncrementalSequence(Sorts.quickSort2Way(array)));
        array = new Integer[]{1, 1};
        Assertions.assertTrue(SortUtil.isIncrementalSequence(Sorts.quickSort2Way(array)));
        array = new Integer[]{5, 4, 4, 2, 1};
        Assertions.assertTrue(SortUtil.isIncrementalSequence(Sorts.quickSort2Way(array)));
    }

    @Test
    void quickSort3Way() {
        Integer[] array;
        array = null;
        Assertions.assertTrue(SortUtil.isIncrementalSequence(Sorts.quickSort3Way(array)));
        array = new Integer[]{1};
        Assertions.assertTrue(SortUtil.isIncrementalSequence(Sorts.quickSort3Way(array)));
        array = new Integer[]{1, 1};
        Assertions.assertTrue(SortUtil.isIncrementalSequence(Sorts.quickSort3Way(array)));
        array = new Integer[]{1, 3, 4, 2, 2, 1, 4, 5, 6};
        Assertions.assertTrue(SortUtil.isIncrementalSequence(Sorts.quickSort3Way(array)));
    }
}