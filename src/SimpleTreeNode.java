package src;
//Define tree element with no children

public class SimpleTreeNode extends TreeNode	{

	public SimpleTreeNode(String label) {
		super(label);
	}

	public void inFixPrint()	{
	    System.out.print(label);
	}

    @Override
    public void postFixPrint() {
        System.out.print(label);
    }

    @Override
    public double evaluate() {
        return (double)Integer.parseInt(label);
    }

}