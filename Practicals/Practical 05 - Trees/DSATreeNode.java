public class DSATreeNode<T extends Comparable<T>> {
    private T data;
    private DSATreeNode<T> left;
    private DSATreeNode<T> right;

    public DSATreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DSATreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(DSATreeNode<T> left) {
        this.left = left;
    }

    public DSATreeNode<T> getRight() {
        return right;
    }

    public void setRight(DSATreeNode<T> right) {
        this.right = right;
    }
}