package src.Core;

import src.Core.OperationLabels;
import src.visitor.BinaryTreeNode;
import src.visitor.Visitable;

public interface IOperationNode extends Visitable {
    int compute(int a, int b);

    Visitable getLeft();
    Visitable getRight();

    default String getLabel()
    {
        try{
            return OperationLabels.getLabelForNode(this);
        }
        catch (Exception e)
        {
            return "?";
        }
    }
}
