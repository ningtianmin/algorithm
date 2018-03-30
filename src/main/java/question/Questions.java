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

    /**
     * 矩阵中的路径
     * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
     * 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
     * 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
     * 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
     * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
     * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     *
     * @param matrix 字符矩阵
     * @param target 路径
     */
    public static boolean stringPathInMatrix(char[][] matrix, char[] target) {
        if (matrix == null || target == null) {
            return false;
        }
        int rowNum = matrix.length, columnNum = matrix[0].length;
        boolean[][] visited = new boolean[rowNum][columnNum];
        int[] nextIndex = {0};
        for (int row = 0; row < rowNum; row++) {
            for (int column = 0; column < columnNum; column++) {
                if (stringPathInMatrixHasPath(matrix, visited, target, row, column, nextIndex)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean stringPathInMatrixHasPath(char[][] matrix, boolean[][] visited, char[] target, int currentRow, int currentColumn, int[] nextIndex) {
        if (currentRow < 0 || currentRow >= matrix.length || currentColumn < 0 || currentColumn >= matrix[0].length) {
            return false;
        }
        boolean hasPath = false;
        if (!visited[currentRow][currentColumn] && matrix[currentRow][currentColumn] == target[nextIndex[0]]) {
            visited[currentRow][currentColumn] = true;
            if (++nextIndex[0] == target.length) {
                return true;
            }
            hasPath = stringPathInMatrixHasPath(matrix, visited, target, currentRow, currentColumn + 1, nextIndex) ||
                    stringPathInMatrixHasPath(matrix, visited, target, currentRow, currentColumn - 1, nextIndex) ||
                    stringPathInMatrixHasPath(matrix, visited, target, currentRow + 1, currentColumn, nextIndex) ||
                    stringPathInMatrixHasPath(matrix, visited, target, currentRow - 1, currentColumn, nextIndex);
            if (!hasPath) {
                nextIndex[0]--;
                visited[currentRow][currentColumn] = false;
            }
        }
        return hasPath;
    }

    public static int cuttingRope(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] dp = new int[length + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int currentLength = 4; currentLength <= length; currentLength++) {
            int max = 0;
            for (int i = 1, border = currentLength / 2; i <= border; i++) {
                int temp = dp[i] * dp[currentLength - i];
                max = max > temp ? max : temp;
            }
            dp[currentLength] = max;
        }
        return dp[length];
    }
}
