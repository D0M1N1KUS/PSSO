package src.visitor.OperationNodes;

import src.Core.IOperationNode;
import src.visitor.BinaryTreeNode;
import src.visitor.Visitable;

public class ModuloNode extends BinaryTreeNode implements IOperationNode {
    /**
     * Creates a non-terminal node of a binary tree.
     *
     * @param left  the new left subtree.
     * @param right the new left subtree.
     */
    public ModuloNode(Visitable left, Visitable right) {
        super(left, right);
    }

    @Override
    public int compute(int a, int b) {
        return a % b;
    }
}
