package search;

/**
 *
 * @author Niky
 * @param <E> type of the root's key
 */
public class BinTree<E> {

    protected Node<E> root;

    public BinTree() {
        root = null;
    }

    public BinTree(Node<E> node) {
        root = node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public boolean contains(E value) {
        if (isEmpty()) {
            return false;
        }
        if (root.key.equals(value)) {
            return true;
        }

        BinTree<E> lTree = new BinTree<>(root.left);
        BinTree<E> rTree = new BinTree<>(root.right);

        return lTree.contains(value) || rTree.contains(value);
    }

    public int height() {
        if (isEmpty()) {
            return 0;
        }

        BinTree<E> l = new BinTree<>(root.left);
        BinTree<E> r = new BinTree<>(root.right);
        return 1 + Math.max(l.height(), r.height());
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        String s = "";
        if (root.left != null) {
            s += new BinTree<E>(root.left).toString() + " ";
        }
        s += root;
        if (root.right != null) {
            s += " " + new BinTree<E>(root.right).toString();
        }
        return s;
    }

}
