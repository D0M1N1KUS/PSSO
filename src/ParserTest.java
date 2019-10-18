package src;

public class ParserTest
{
    public static void main(String[] args)	{
        Parser parser = new Parser();
        TreeNode rootNode = parser.parse("1 + ( 2 - 3 * 4 ) / 5");// spaces are vital!!;
        TreeNode otherRootNode = parser.parse("1 + 5 % 3");

        System.out.println("inFixPrint:");
        rootNode.inFixPrint();
        System.out.println("\npostFixPrint:");
        rootNode.postFixPrint();
        System.out.println();

        try{
            System.out.println("Evaluation: " + String.valueOf(rootNode.evaluate()));
            System.out.println("Evaluation: " + String.valueOf(otherRootNode.evaluate()));
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
//		System.out.println("");
//		rootNode.preFixPrint();
//		System.out.println("");
//		rootNode.postFixPrint();
//		System.out.println("");
//		System.out.println("result: " + rootNode.evaluate());
    }
}
