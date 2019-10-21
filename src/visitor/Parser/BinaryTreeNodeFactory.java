package src.visitor.Parser;

import src.Core.OperationLabels;
import src.visitor.OperationNodes.*;
import src.visitor.Visitable;

public class BinaryTreeNodeFactory {

    public static Visitable get(String nodeLabel, Visitable left, Visitable right) throws Exception {
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
                throw new Exception("Unknown node-label \"" + nodeLabel + "\"");
        }
    }
}
