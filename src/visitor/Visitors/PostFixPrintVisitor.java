package src.visitor.Visitors;

import src.Core.IOperationNode;
import src.visitor.BinaryTreeVisitor;

public class PostFixPrintVisitor extends A_FixPrintVisitor implements BinaryTreeVisitor
{
    @Override
    public void visit(IOperationNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        value += node.getLabel();
    }
}
