package src.visitor.Visitors;

import src.Core.IOperationNode;
import src.visitor.BinaryTreeLeaf;
import src.visitor.BinaryTreeVisitor;

public abstract class A_FixPrintVisitor implements BinaryTreeVisitor {

    String value = "";

    @Override
    public abstract void visit(IOperationNode node);

    @Override
    public void visit(BinaryTreeLeaf node) {
        value += node.getValue();
    }

    @Override
    public String report() {
        return value;
    }
}
