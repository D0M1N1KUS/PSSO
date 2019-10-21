/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * This file is part of the design patterns project at UBC
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * either http://www.mozilla.org/MPL/ or http://aspectj.org/MPL/.
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is ca.ubc.cs.spl.aspectPatterns.
 *
 * For more details and the latest version of this code, please see:
 * http://www.cs.ubc.ca/labs/spl/projects/aodps.html
 *
 * Contributor(s):
 */
/**
 * Implements the driver for the Visitor design pattern example.<p>
 *
 * Intent: <i>Represents an operation to be performed on the elements of an
 * object structure. Visitor lets you define a new operation without changing
 * the classes of the elements on which it operates</i><p>
 *
 * Participating classes are <code>SummationVisitor</code> and
 * <code>TraversalVisitor</code> as <i>ConcreteVisitor</i>s, implementing the
 * <code>BinaryTreeVisitor</code> interface. <BR>
 *
 * <code>BinaryTreeNode</code> and <code>BinaryTreeLeaf</code> are
 * <i>ConcreteElement</i>s, implementing the <code>Visitable</code> interface.
 * <p>
 *
 * In this example, a binary tree is built that has
 * int values as leafs. <code>SummationVisitor</code> is a <i>Visitor</i>
 * that collects the sum of the leaf values (should be 6).
 *
 * TraversalVisitor is a visitor that
 * collects a description of the tree like {{1,2},3}
 *
 * <p><i>This is the Java version.</i><p>
 *
 * Note that <UL>
 * <LI> Every visitor (even the interface) has to know of each possible element
 *      type in the object structure.
 * <LI> Nodes need to know of the visitor interface; they have to implement the
 *      accept(NodeVisitor) method.
 * </UL>
 *
 * @author  Jan Hannemann
 * @author  Gregor Kiczales
 * @version 1.1, 02/17/04
 */

package src;

import src.nopattern.Parser;
import src.nopattern.TreeNode;
import src.visitor.Parser.VisitorParser;
import src.visitor.Visitable;

public class Main
{
    /**
     * @param args the command-line parameters, unused
     */
    public static void main(String[] args)	{
        //Parser();
        Client();
    }

    private static void Parser() {
        Parser parser = new Parser();
        TreeNode rootNode = parser.parse("1 + ( 2 - 3 * 4 ) / 5");// spaces are vital!!;
        TreeNode otherRootNode = parser.parse("1 + 5 % 3");

        System.out.println("inFixPrint:");
        rootNode.inFixPrint();
        System.out.println("\npostFixPrint:");
        rootNode.postFixPrint();
        System.out.println("\npreFixPrint:");
        rootNode.preFixPrint();
        System.out.println();

        try{
            System.out.println("Evaluation: " + String.valueOf(rootNode.evaluate()));
            System.out.println("Evaluation: " + String.valueOf(otherRootNode.evaluate()));
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }


    /**
     * Implements the driver for the Visitor design pattern example.<p>
     */
    private static void Client()
    {
        VisitorParser parser = new VisitorParser();
        Visitable rootNode = parser.parse("1 + ( 2 - 3 * 4 ) / 5");// spaces are vital!!;
        Visitable otherRootNode = parser.parse("1 + 5 % 3");

        //System.out.println("inFixPrint:");
        //rootNode.accept();
    }
}
