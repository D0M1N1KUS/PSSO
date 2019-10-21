package src.visitor.OperationNodes;

import src.visitor.BinaryTreeNode;

public class OperationLabels {
    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";
    public static final String MODULO = "%";

    public static String getLabelForNode(IOperationNode node) throws Exception {
        if(node instanceof AdditionNode)
            return ADDITION;
        if(node instanceof SubtractionNode)
            return SUBTRACTION;
        if(node instanceof MultiplicationNode)
            return MULTIPLICATION;
        if(node instanceof DivisionNode)
            return DIVISION;
        if(node instanceof ModuloNode)
            return MODULO;

        throw new Exception("Type \"" + node.getClass().getName() + "\" is not supported!");
    }

}
