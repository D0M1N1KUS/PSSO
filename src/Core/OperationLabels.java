package src.Core;

import src.visitor.OperationNodes.*;

import java.lang.reflect.Field;

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

    public static boolean isOperator(String label)
    {
        Field[] fields = OperationLabels.class.getDeclaredFields();

        for(Field field : fields)
        {
            try {
                if((field.get(OperationLabels.class)) instanceof String)
                    if(label.equals(field.get(OperationLabels.class)))
                        return true;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
