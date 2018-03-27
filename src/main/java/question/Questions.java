package question;

/**
 * @author NINGTIANMIN
 */
public class Questions {
    /**
     * 找出数组中重复的数字
     * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
     * 那么对应的输出是重复的数字2或者3。
     *
     * @param array 一个整形数组
     * @return 任一重复数字
     */
    public static int duplicationInArray(int[] array) {
        int size;
        if (array == null || (size = array.length) == 0) {
            return -1;
        }
        for (int digit : array) {
            if (digit < 0 || digit >= size) {
                return -1;
            }
        }
        for (int i = 0; i < size; i++) {
            int digit = array[i];
            while (digit != i) {
                if (digit == array[digit]) {
                    return digit;
                }
                array[i] = array[digit];
                array[digit] = digit;
            }
        }
        return -1;
    }

    /**
     * 二维数组中的查找
     * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
     * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
     * 整数，判断数组中是否含有该整数。
     *
     * @param matrix 矩阵
     * @param number 要查找的数
     * @return 是否存在
     */
    public static boolean findInPartiallySortedMatrix(int[][] matrix, int number) {
        int row, col;
        if (matrix == null || (row = matrix.length) == 0 || (col = matrix[0].length) == 0) {
            return false;
        }
        int rowIndex = row - 1, colIndex = 0;
        while (rowIndex >= 0 && colIndex < col) {
            int digit = matrix[rowIndex][colIndex];
            if (digit == number) {
                return true;
            }
            if (digit > number) {
                rowIndex--;
            } else {
                colIndex++;
            }
        }
        return false;
    }

    /**
     * 二叉树的下一个结点
     * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
     * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
     *
     * @param node 结点
     * @param <T>  结点值类型
     * @return 结点的下一个结点
     */
    public static <T> BinaryTreeNode<T> nextNodeInBinaryTrees(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<T> next;
        if (node.getRight() != null) {
            BinaryTreeNode<T> nextTemp = node.getRight();
            while (nextTemp.getLeft() != null) {
                nextTemp = nextTemp.getLeft();
            }
            next = nextTemp;
        } else {
            BinaryTreeNode<T> cur = node;
            BinaryTreeNode<T> curParent = cur.getParent();
            while (curParent != null && curParent.getRight() == cur) {
                cur = curParent;
                curParent = curParent.getParent();
            }
            next = curParent;
        }
        return next;
    }

    /**
     * 斐波那契数列
     * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
     */
    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fist = 1, last = 0, cur = 0, index = 2;
        while (index <= n) {
            cur = fist + last;
            last = fist;
            fist = cur;
            index++;
        }
        return cur;
    }
}
