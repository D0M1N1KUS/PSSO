package src.nopattern;
//Define tree element with no children

public class SimpleTreeNode extends TreeNode	{

	public SimpleTreeNode(String label) {
		super(label);
	}

	public void inFixPrint()	{
	    printLabel();
	}

    @Override
    public void postFixPrint() {
        printLabel();
    }

    @Override
    public void preFixPrint() {
        printLabel();
    }

    private void printLabel()
    {
	    System.out.print(label);
    }

    @Override
    public double evaluate() {
        return (double)Integer.parseInt(label);
    }

}