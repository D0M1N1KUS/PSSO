package src.nopattern;
//Tree node that contains two children

public class BinaryTreeNode extends TreeNode
{
	private TreeNode left, right;

	public BinaryTreeNode(String label) {
		super(label);
		left = right = null;

	}

	public BinaryTreeNode(String label, TreeNode left, TreeNode right) {
		super(label);
		this.left = left;
		this.right = right;
	}

    public void inFixPrint() {
	    System.out.print("( ");

        left.inFixPrint();
        System.out.print(' ' + label + ' ');
        right.inFixPrint();

        System.out.print(" )");
    }

    @Override
    public void postFixPrint() {
        left.postFixPrint();
        right.postFixPrint();
        System.out.print(label);
    }

    @Override
    public void preFixPrint() {
        System.out.print(label);
        left.postFixPrint();
        right.postFixPrint();
    }

    @Override
    public double evaluate() throws Exception {
        return operation(left.evaluate(), right.evaluate());
    }

    private double operation(double value1, double value2) throws Exception {
        switch (label)
        {
            case "*":
                return value1 * value2;
            case "/":
                return value1 / value2;
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "%":
                return value1 % value2;
            default:
                throw new Exception("Uknown operation \'" + label + "\'");
        }
    }

}
