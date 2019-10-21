package src.nopattern;

import src.Core.Miscellaneous;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author adam
 */
public class Parser {

	private StringTokenizer lexAnalyser;
	private String[] operators = new String[]{"+", "-", "*", "/", "%"};
	private Stack<TreeNode> treeStack;
	private Stack<String> operatorStack;

	public TreeNode parse(String inFixExpression) {

	    treeStack = new Stack<>();
        operatorStack = new Stack<>();
        lexAnalyser = new StringTokenizer(inFixExpression);

        while (lexAnalyser.hasMoreTokens()) {

            String token = lexAnalyser.nextToken();

            if (token.equals("("))
            {
                //src.nopattern.BinaryTreeNode tree = new src.nopattern.BinaryTreeNode(token);
                operatorStack.push(token);
            }
            else if (Miscellaneous.isInteger(token))
            {
                SimpleTreeNode tree = new SimpleTreeNode(token);
                treeStack.push(tree);
            }
            else if (Miscellaneous.isOperator(token))
            {
                //src.nopattern.BinaryTreeNode tree = new src.nopattern.BinaryTreeNode(token);
                if (operatorStack.empty() || operatorStack.peek().equals("(") ||
                        Miscellaneous.getOperatorPriority(operatorStack.peek()) <
                                Miscellaneous.getOperatorPriority(token))
                {
                    operatorStack.push(token);
                }
                else
                { // clear operator stack and push new one onto it
                    do
                    {
                        PopConnectPush();
                    }
                    while (!operatorStack.empty() && !operatorStack.peek().equals("(") &&
                            Miscellaneous.getOperatorPriority(operatorStack.peek()) <
                                    Miscellaneous.getOperatorPriority(token));

                    operatorStack.push(token);
                }
            }
            else if (token.equals(")"))
            {
                while (!operatorStack.peek().equals("("))
                    PopConnectPush();

                operatorStack.pop(); //Pop the opening bracket off the stack.
            }
            else
            {
                System.out.println("Unrecognized token: \'" + token + "\'");
            }
        }

        while (!operatorStack.empty())
            PopConnectPush(); // pointer to root of final tree is on top of the tree stack
        return treeStack.pop();
    }

	private void PopConnectPush() {
        TreeNode right = treeStack.pop();
        TreeNode left = treeStack.pop();
        BinaryTreeNode tree = new BinaryTreeNode(operatorStack.pop(), left, right);
        treeStack.push(tree);
    }
}
