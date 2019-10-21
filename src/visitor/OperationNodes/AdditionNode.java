package src.visitor.OperationNodes;

import src.visitor.BinaryTreeNode;
import src.visitor.Visitable;

public class AdditionNode extends BinaryTreeNode implements IOperationNode {

    /**
     * Creates a non-terminal node of a binary tree.
     *
     * @param left  the new left subtree.
     * @param right the new left subtree.
     */
    public AdditionNode(Visitable left, Visitable right) {
        super(left, right);
    }

    @Override
    public int compute(int a, int b) {
        return a + b;
    }
}
