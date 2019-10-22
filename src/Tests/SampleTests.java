package src.Tests;

import org.junit.Test;
import org.junit.Assert;
import src.visitor.BinaryTreeLeaf;
import src.visitor.BinaryTreeNode;
import src.visitor.OperationNodes.AdditionNode;
import src.visitor.Visitors.SummationVisitor;
import src.visitor.Visitors.TraversalVisitor;

public class SampleTests {

    @Test
    public void testVisitorSumCollector()
    {
        int expectedSum = 6;
        BinaryTreeNode root = getBinaryTree();
        SummationVisitor sumVisitor = new SummationVisitor();
        root.accept(sumVisitor);

        int actualSum = Integer.parseInt(sumVisitor.report());

        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testTraversalVisitorOutput()
    {
        String expectedOutput = "{{1,2},3}";
        BinaryTreeNode root = getBinaryTree();
        TraversalVisitor traversalVisitor = new TraversalVisitor();

        root.accept(traversalVisitor);
        String actualOutput = traversalVisitor.report();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    private BinaryTreeNode getBinaryTree() {
        BinaryTreeLeaf one   = new BinaryTreeLeaf(1);
        BinaryTreeLeaf two   = new BinaryTreeLeaf(2);
        BinaryTreeLeaf three = new BinaryTreeLeaf(3);
        BinaryTreeNode regN = new AdditionNode(one, two);
        return new AdditionNode(regN, three);
    }


}
