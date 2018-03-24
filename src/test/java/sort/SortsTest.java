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
}