package src.visitor.Visitors;

import src.Core.IOperationNode;
import src.visitor.BinaryTreeVisitor;

public class PreFixPrintVisitor extends A_FixPrintVisitor implements BinaryTreeVisitor
{
    @Override
    public void visit(IOperationNode node) {
        value += node.getLabel();
        node.getLeft().accept(this);
        node.getRight().accept(this);
    }
}
