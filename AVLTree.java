
public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private class Node {
        T key;
        Node left;
        Node right;
        int height;

        Node(T key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    // Helper method to get height of a node (null nodes have height 0)
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Update height of a node
    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }


    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        updateHeight(y);
        updateHeight(x);

        // Return new root
        return x;
    }

    // Left rotation
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        updateHeight(x);
        updateHeight(y);

        // Return new root
        return y;
    }

    @Override
    public boolean insert(T key) {

        if (search(key)) {
            return false;
        }

        // Perform insert and rebalance
        root = insert(root, key);
        size++;
        return true;
    }

    private Node insert(Node node, T key) {
        // 1. Perform standard BST insert
        if (node == null) {
            return new Node(key);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key);
        } else if (cmp > 0) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys are not allowed
            return node;
        }


        updateHeight(node);

        // 3. Get the balance factor to check if this node became unbalanced
        int balance = getBalance(node);

        // Left-Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rightRotate(node);
        }

        // Right-Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return leftRotate(node);
        }

        // Left-Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the unchanged node
        return node;
    }

    @Override
    public boolean delete(T key) {
        if (!search(key)) {
            return false;
        }

        root = delete(root, key);
        size--;
        return true;
    }

    private Node delete(Node root, T key) {
        // Standard BST delete
        if (root == null) {
            return null;
        }

        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = delete(root.left, key);
        } else if (cmp > 0) {
            root.right = delete(root.right, key);
        } else {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children
            // Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.key);
        }


        if (root == null) {
            return null;
        }

        // Update height
        updateHeight(root);


        int balance = getBalance(root);


        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left-Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right-Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right-Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Find minimum value in a tree
    private T minValue(Node root) {
        T minVal = root.key;
        while (root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }

    @Override
    public boolean search(T key) {
        return search(root, key);
    }

    private boolean search(Node node, T key) {
        if (node == null) {
            return false;
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return height(root);
    }
    public void printInorder() {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            printInorder(root);
            System.out.println(); // New line at the end
        }
    }

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.key + " ");
            printInorder(node.right);
        }
    }
}
