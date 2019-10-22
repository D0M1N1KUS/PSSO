package src.visitor.Visitors;

import src.Core.IOperationNode;
import src.visitor.BinaryTreeLeaf;
import src.visitor.BinaryTreeVisitor;

public class EvaluateVisitor implements BinaryTreeVisitor {

    int leafValue;

    @Override
    public void visit(IOperationNode node) {
        node.getLeft().accept(this);
        int a = leafValue;
        node.getRight().accept(this);
        leafValue = node.compute(a, leafValue);
    }

    @Override
    public void visit(BinaryTreeLeaf node) {
        leafValue = node.getValue();
    }

    @Override
    public String report() {
        return String.valueOf(leafValue);
    }
}
