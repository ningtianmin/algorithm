package question;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NINGTIANMIN
 */
@Data
@NoArgsConstructor
public class BinaryTreeNode<T> {
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private BinaryTreeNode<T> parent;

    public BinaryTreeNode(T value) {
        this.value = value;
    }
}
