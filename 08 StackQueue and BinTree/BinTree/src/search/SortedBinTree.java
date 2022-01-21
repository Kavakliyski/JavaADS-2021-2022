/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author Niky
 * @param <E> - Comparable class
 */
public class SortedBinTree<E extends Comparable> extends BinTree<E> {

    public SortedBinTree() {
        super();
    }

    public SortedBinTree(Node<E> node) {
        root = node;
    }

    public SortedBinTree(E value) {
        this(new Node<E>(value));
    }

    public void add(E value) {

        if (isEmpty()) {
            root = new Node<>(value);
            return;
        }

        if (value.compareTo(root.key) < 0) {
            if (root.left == null) {
                root.left = new Node<E>(value);
            } else {
                SortedBinTree<E> l = new SortedBinTree<>(root.left);
                l.add(value);
            }
        } else if (root.right == null) {
            root.right = new Node<>(value);
        } else {
            SortedBinTree<E> r = new SortedBinTree<>(root.right);
            r.add(value);
        }
    }

    @Override
    public boolean contains(E value) {
        if (isEmpty()) {
            return false;
        }
        if (root.key.equals(value)) {
            return true;
        }

        if (value.compareTo(root.key) < 0) {
            return new SortedBinTree<>(root.left).contains(value);
        } else {
            return new SortedBinTree<>(root.right).contains(value);
        }
    }

    /**
     * Only if not Empty!!!
     *
     * @return min value
     */
    public E getMin() {
        if (root.left == null) {
            return root.key;
        }
        return new SortedBinTree<E>(root.left).getMin();
    }

    /**
     * Only if not Empty!!!
     *
     * @return max value
     */
    public E getMax() {
        if (root.right == null) {
            return root.key;
        }
        return new SortedBinTree<E>(root.right).getMax();
    }

    public void remove(E value) {
        if (isEmpty()) {
            return;
        }
        if (root.left != null && root.left.isLeaf() && root.left.key.equals(value)) {
            root.left = null;
            return;
        }
        if (root.right != null && root.right.isLeaf() && root.right.key.equals(value)) {
            root.right = null;
            return;
        }

        if (root.key.equals(value)) {
            if (root.isLeaf()) {
                root = null;
                return;
            }
            
            if (root.left != null) {
                SortedBinTree<E> l = new SortedBinTree<>(root.left);
                root.key = l.getMax();
                if (root.key.equals(l.root.key))
                    root.left = null;
                l.remove(root.key);
            } else {
                SortedBinTree<E> r = new SortedBinTree<>(root.right);
                root.key = r.getMin();
                if (root.key.equals(r.root.key))
                    root.right = null;
                r.remove(root.key);
            }
        } else if (value.compareTo(root.key) < 0) {
            if (root.left != null) {
                SortedBinTree<E> l = new SortedBinTree<>(root.left);
                l.remove(value);
            }
        } else if (root.right != null) {
            SortedBinTree<E> r = new SortedBinTree<>(root.right);
            r.remove(value);
        }

    }
}
