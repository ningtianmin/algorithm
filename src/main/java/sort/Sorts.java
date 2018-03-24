package sort;

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
}
