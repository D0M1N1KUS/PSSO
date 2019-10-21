package src.visitor.Parser;

import src.visitor.BinaryTreeNode;
import src.visitor.OperationNodes.*;

public class BinaryTreeNodeFactory {

    public static BinaryTreeNode get(String nodeLabel, BinaryTreeNode left, BinaryTreeNode right) throws Exception {
        switch (nodeLabel)
        {
            case OperationLabels.ADDITION:
                return new AdditionNode(left, right);
            case OperationLabels.SUBTRACTION:
                return new SubtractionNode(left, right);
            case OperationLabels.MULTIPLICATION:
                return new MultiplicationNode(left, right);
            case OperationLabels.DIVISION:
                return new DivisionNode(left, right);
            case OperationLabels.MODULO:
                return new ModuloNode(left, right);
            default:
                throw new Exception("Unknown label \"" + nodeLabel + "\"");
        }
    }
}
