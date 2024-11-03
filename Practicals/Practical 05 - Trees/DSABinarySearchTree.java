import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DSABinarySearchTree<T extends Comparable<T>> implements Serializable  {
    private DSATreeNode<T> root;

    public DSABinarySearchTree() {
        root = null;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private DSATreeNode<T> insert(DSATreeNode<T> node, T value) {
        if (node == null) {
            node = new DSATreeNode<T>(value);
        } else if (value.compareTo(node.getData()) < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

    public void delete(T value) {
        root = delete(root, value);
    }

    private DSATreeNode<T> delete(DSATreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                DSATreeNode<T> temp = findMin(node.getRight());
                node.setData(temp.getData());
                node.setRight(delete(node.getRight(), temp.getData()));
            }
        }
        return node;
    }

    private DSATreeNode<T> findMin(DSATreeNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public boolean find(T value) {
        return find(root, value);
    }

    private boolean find(DSATreeNode<T> node, T value) {
        if (node == null) {
            return false;
        } else if (value.compareTo(node.getData()) == 0) {
            return true;
        } else if (value.compareTo(node.getData()) < 0) {
            return find(node.getLeft(), value);
        } else {
            return find(node.getRight(), value);
        }
    }

    public T min() {
        if (root == null) {
            return null;
        }
        DSATreeNode<T> node = root;
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    public T max() {
        if (root == null) {
            return null;
        }
        DSATreeNode<T> node = root;
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getData();
    }

    public int height() {
        return height(root);
    }

    private int height(DSATreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public double balance() {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        return (double)(leftHeight - rightHeight) / (double)(leftHeight + rightHeight);
    }
    
    public void inorder() {
        inorder(root);
        System.out.println();
		
    }

    void inorder(DSATreeNode<T> node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.print(node.getData() + " ");
            inorder(node.getRight());
        }
    }
    
    public void preorder() {
        preorder(root);
        System.out.println();
		
    }

    void preorder(DSATreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
		
    }

    void postorder(DSATreeNode<T> node) {
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }
    
    
}
