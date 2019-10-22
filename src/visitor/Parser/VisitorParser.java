package src.visitor.Parser;

import src.Core.Miscellaneous;
import src.visitor.BinaryTreeLeaf;
import src.visitor.Visitable;

import java.util.Stack;
import java.util.StringTokenizer;

public class VisitorParser {

    private StringTokenizer lexAnalyser;
    private Stack<Visitable> treeNodeStack;
    private Stack<String> operatorStack;

    private int tokensParsedSoFar;

    public Visitable parse(String inFixExpression) {
        initializeFields(inFixExpression);

        while(lexAnalyser.hasMoreTokens())
        {
            tryToInterpretToken(lexAnalyser.nextToken());
            tokensParsedSoFar++;
        }

        tryToEmptyOperatorStack();
        return treeNodeStack.pop();
    }


    private void initializeFields(String expression)
    {
        treeNodeStack = new Stack<>();
        lexAnalyser = new StringTokenizer(expression);
        operatorStack = new Stack<>();
        tokensParsedSoFar = 0;
    }

    private void tryToEmptyOperatorStack() {
        try {
            while (!operatorStack.empty())
                popConnectPush();
        }
        catch (Exception e)
        {
            System.out.println("Unable to empty operator stack!");
            e.printStackTrace(System.out);
        }
    }

    private void tryToInterpretToken(String token)
    {
        try
        {
            interpretToken(token);
        }
        catch (Exception e)
        {
            System.out.println("Failed to parse inFixExpressiont at token #" + (tokensParsedSoFar + 1) +
                    " \"" + token + "\"");
            e.printStackTrace(System.out);
        }
    }

    private void interpretToken(String token) throws Exception
    {
        if (token.equals(OtherTokens.OPEN_BRACKET))
            operatorStack.push(token);
        else if (token.equals(OtherTokens.CLOSE_BRACKET))
            popGroup();
        else if (Miscellaneous.isInteger(token))
            treeNodeStack.push(new BinaryTreeLeaf(Integer.parseInt(token)));
        else if(Miscellaneous.isOperator(token))
            pushNewOperator(token);
        else
            throw new Exception("Unrecognized token: \"" + token + "\"");
    }

    private void popGroup() throws Exception {
        while(!operatorStack.peek().equals(OtherTokens.OPEN_BRACKET))
            popConnectPush();
        operatorStack.pop();
    }

    private void popConnectPush() throws Exception {
        Visitable right = treeNodeStack.pop();
        Visitable left = treeNodeStack.pop();
        treeNodeStack.push(BinaryTreeNodeFactory.get(operatorStack.pop(), left, right));
    }

    private void pushNewOperator(String operator) throws Exception {
        if(operatorStackIsEmptyOrHasOpenBracketOnTop() ||
                operatorHasLowerPriorityThanTopOfOperatorStack(operator))
            operatorStack.push(operator);
        else
            clearOperatorStackAndPushNewOneOntoIt(operator);
    }

    private void clearOperatorStackAndPushNewOneOntoIt(String operator) throws Exception {
        do
        {
            popConnectPush();
        }
        while (!operatorStackIsEmptyOrHasOpenBracketOnTop() &&
                operatorHasLowerPriorityThanTopOfOperatorStack(operator));

        operatorStack.push(operator);
    }

    private boolean operatorHasLowerPriorityThanTopOfOperatorStack(String operator) {
        return Miscellaneous.getOperatorPriority(operator) >
                Miscellaneous.getOperatorPriority(operatorStack.peek());
    }

    private boolean operatorStackIsEmptyOrHasOpenBracketOnTop() {
        return operatorStack.empty() || operatorStack.peek().equals(OtherTokens.OPEN_BRACKET);
    }
}
