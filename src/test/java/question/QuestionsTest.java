package question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuestionsTest {

    @Test
    void findDuplication() {
        int[] data = {0, 2, 3, 3, 2, 1};
        int result = Questions.duplicationInArray(data);
        System.out.println(String.format("findDuplication:%d", result));
    }

    @Test
    void findInPartiallySortedMatrix() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Assertions.assertTrue(Questions.findInPartiallySortedMatrix(data, 7));
        Assertions.assertFalse(Questions.findInPartiallySortedMatrix(data, 10));
        Assertions.assertFalse(Questions.findInPartiallySortedMatrix(data, 0));
    }

    @Test
    void nextNodeInBinaryTrees() {
        BinaryTreeNode<Character> nodeA = new BinaryTreeNode<>('a');
        BinaryTreeNode<Character> nodeB = new BinaryTreeNode<>('b');
        BinaryTreeNode<Character> nodeC = new BinaryTreeNode<>('c');
        BinaryTreeNode<Character> nodeD = new BinaryTreeNode<>('d');
        BinaryTreeNode<Character> nodeE = new BinaryTreeNode<>('e');
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);
        nodeB.setParent(nodeA);
        nodeC.setParent(nodeA);
        nodeD.setParent(nodeB);
        nodeE.setParent(nodeB);
        Assertions.assertEquals(nodeC, Questions.nextNodeInBinaryTrees(nodeA));
        Assertions.assertEquals(nodeE, Questions.nextNodeInBinaryTrees(nodeB));
        Assertions.assertNull(Questions.nextNodeInBinaryTrees(nodeC));
        Assertions.assertEquals(nodeB, Questions.nextNodeInBinaryTrees(nodeD));
        Assertions.assertEquals(nodeA, Questions.nextNodeInBinaryTrees(nodeE));

    }

    @Test
    void fibonacci() {
        Assertions.assertEquals(0, Questions.fibonacci(0));
        Assertions.assertEquals(1, Questions.fibonacci(1));
        Assertions.assertEquals(1, Questions.fibonacci(2));
        Assertions.assertEquals(2, Questions.fibonacci(3));
    }
}