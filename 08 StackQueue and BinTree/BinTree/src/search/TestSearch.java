/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author Niky
 */
public class TestSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test Node
        Node<Integer> myNode = new Node<>(5);
        myNode.left = new Node<>(3);
        myNode.right = new Node<>(8);
        myNode.left.left = new Node<>(1);
        myNode.left.right = new Node<>(4);
        myNode.right.left = new Node<>(7);
        myNode.right.right = new Node<>(10);

        BinTree<Integer> myTree = new BinTree<>(myNode);
        System.out.println("Bin Tree: " + myTree);
        System.out.println("Height: " + myTree.height());

        System.out.println("Contains 4: " + myTree.contains(4));
        System.out.println("Contains 3: " + myTree.contains(3));
        System.out.println("Contains 2: " + myTree.contains(2));

        //Test SortedBinTree
        SortedBinTree<Integer> mySortedTree = new SortedBinTree<>(8);
        mySortedTree.add(3);
        mySortedTree.add(10);
        mySortedTree.add(1);
        mySortedTree.add(6);
        mySortedTree.add(14);
        mySortedTree.add(4);
        mySortedTree.add(7);
        mySortedTree.add(13);
        System.out.println("Sorted: " + mySortedTree);

        System.out.println("Contains 8: " + mySortedTree.contains(8));
        System.out.println("Contains 3: " + mySortedTree.contains(3));
        System.out.println("Contains 2: " + mySortedTree.contains(2));

        System.out.println("Min: " + mySortedTree.getMin());
        System.out.println("Max: " + mySortedTree.getMax());

        mySortedTree.remove(8);
        System.out.println("Removed 8: " + mySortedTree);
        mySortedTree.remove(3);
        System.out.println("Removed 3: " + mySortedTree);
        mySortedTree.remove(2);
        System.out.println("Removed 2: " + mySortedTree);
        mySortedTree.remove(1);
        System.out.println("Removed 1: " + mySortedTree);
        mySortedTree.remove(7);
        System.out.println("Removed 7: " + mySortedTree);
                mySortedTree.remove(10);
        System.out.println("Removed 10: " + mySortedTree);

    }

}
