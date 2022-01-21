/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author Niky
 * @param <E> - type of node elements
 * @param <BTr> - extension of BinTree
 */
public class Node<E> { 

    protected E key;
    protected Node<E> left, right;

    public Node() {
        super();
    }
    
    public Node(E key) {
        this.key = key;
        left = null;
        right = null;
    }

    public Node(E key, Node<E> left, Node<E> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
      
    public boolean isLeaf() {
        return left == null && right == null;
    }


    /**
     * @return Left-Root-Right
     */
    @Override
    public String toString() {
        return key.toString();
    }

}
