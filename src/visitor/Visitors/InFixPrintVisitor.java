package src.visitor.Visitors;

import src.Core.IOperationNode;
import src.Core.OperationLabels;
import src.visitor.BinaryTreeLeaf;
import src.visitor.BinaryTreeVisitor;

public class InFixPrintVisitor implements BinaryTreeVisitor {

    protected String result = "";

    @Override
    public void visit(IOperationNode node) {
        result += "( ";
        node.getLeft().accept(this);
        result += ' ' + node.getLabel() + ' ';
        node.getRight().accept(this);
        result += " )";
    }

    @Override
    public void visit(BinaryTreeLeaf node) {
        result += node.getValue();
    }


    @Override
    public String report() {
        return result;
    }
}
