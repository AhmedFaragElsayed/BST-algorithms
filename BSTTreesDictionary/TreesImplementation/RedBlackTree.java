package BSTTreesDictionary.TreesImplementation;
public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        T key;
        Node left, right, parent;
        boolean color;

        Node(T key, boolean color, Node parent) {
            this.key = key;
            this.color = color;
            this.parent = parent;
        }
    }

    private Node root;
    private int size = 0;

    @Override
    public boolean insert(T key) {
        if (key == null) return false;
        Node insertedNode = bstInsert(key);
        if (insertedNode == null) return false;
        fixAfterInsertion(insertedNode);
        size++;
        return true;
    }

    private Node bstInsert(T key) {
        Node current = root, parent = null;
        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return null; // Duplicate key
        }
        Node newNode = new Node(key, RED, parent);
        if (parent == null) root = newNode;
        else if (key.compareTo(parent.key) < 0) parent.left = newNode;
        else parent.right = newNode;
        return newNode;
    }

    private void fixAfterInsertion(Node x) {
        while (x != null && x != root && x.parent.color == RED) {
            if (x.parent == x.parent.parent.left) {
                Node y = x.parent.parent.right;
                if (y != null && y.color == RED) {
                    x.parent.color = BLACK;
                    y.color = BLACK;
                    x.parent.parent.color = RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.right) {
                        x = x.parent;
                        rotateLeft(x);
                    }
                    x.parent.color = BLACK;
                    x.parent.parent.color = RED;
                    rotateRight(x.parent.parent);
                }
            } else {
                Node y = x.parent.parent.left;
                if (y != null && y.color == RED) {
                    x.parent.color = BLACK;
                    y.color = BLACK;
                    x.parent.parent.color = RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.left) {
                        x = x.parent;
                        rotateRight(x);
                    }
                    x.parent.color = BLACK;
                    x.parent.parent.color = RED;
                    rotateLeft(x.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;
        y.right = x;
        x.parent = y;
    }

    @Override
    public boolean delete(T key) {
        Node node = searchNode(root, key);
        if (node == null) return false;
        deleteNode(node);
        size--;
        return true;
    }

    private void deleteNode(Node z) {
        Node y = z;
        Node x;
        boolean yOriginalColor = y.color;
        if (z.left == null) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == null) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                if (x != null) x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                if (y.right != null) y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            if (y.left != null) y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == BLACK) fixAfterDeletion(x);
    }

    private void transplant(Node u, Node v) {
        if (u.parent == null) root = v;
        else if (u == u.parent.left) u.parent.left = v;
        else u.parent.right = v;
        if (v != null) v.parent = u.parent;
    }

    private Node minimum(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private void fixAfterDeletion(Node x) {
        while (x != root && getColor(x) == BLACK) {
            if (x == x.parent.left) {
                Node w = x.parent.right;
                if (getColor(w) == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if (getColor(w.left) == BLACK && getColor(w.right) == BLACK) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (getColor(w.right) == BLACK) {
                        if (w.left != null) w.left.color = BLACK;
                        w.color = RED;
                        rotateRight(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    if (w.right != null) w.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                Node w = x.parent.left;
                if (getColor(w) == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if (getColor(w.right) == BLACK && getColor(w.left) == BLACK) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (getColor(w.left) == BLACK) {
                        if (w.right != null) w.right.color = BLACK;
                        w.color = RED;
                        rotateLeft(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    if (w.left != null) w.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        if (x != null) x.color = BLACK;
    }

    private boolean getColor(Node node) {
        return node == null ? BLACK : node.color;
    }

    @Override
    public boolean search(T key) {
        return searchNode(root, key) != null;
    }

    private Node searchNode(Node node, T key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return computeHeight(root);
    }

    private int computeHeight(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(computeHeight(node.left), computeHeight(node.right));
    }

    public void printInorder() {
    printInorder(root);
    System.out.println();
}

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.key + " ");
            printInorder(node.right);
        }
    }
    
}
