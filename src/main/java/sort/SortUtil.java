package sort;

/**
 * @author NINGTIANMIN
 */
public class SortUtil {
    public static <T extends Comparable<? super T>> boolean isIncrementalSequence(T[] array) {
        if (array == null) {
            return true;
        }
        for (int i = 0, length = array.length; i < length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
