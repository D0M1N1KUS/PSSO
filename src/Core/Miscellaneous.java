package src.Core;

public class Miscellaneous {
    public static boolean isInteger(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
    }

    public static boolean isOperator(String op) {
        return OperationLabels.isOperator(op);
    }

    public static int getOperatorPriority(String operator)
    {
        switch (operator)
        {
            case OperationLabels.MODULO:
                return 3;
            case OperationLabels.MULTIPLICATION:
                return 2;
            case OperationLabels.DIVISION:
                return 2;
            case OperationLabels.ADDITION:
                return 1;
            case OperationLabels.SUBTRACTION:
                return 1;
            default:
                return -1;
        }
    }
}
