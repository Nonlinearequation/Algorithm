package 数据结构实现.大话数据结构.二叉树;

/**
 * @author xi553
 */
public class BiNode<E> {

    private E data;

    private BiNode<E> leftChild;

    private BiNode<E> rightNode;

    private BiNode<E> parentNode;

    public BiNode(E data) {
        this.data = data;
    }

    public BiNode(E data, BiNode<E> leftChild, BiNode<E> rightNode) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightNode = rightNode;
    }

    public BiNode() {
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BiNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BiNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public BiNode<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BiNode<E> rightNode) {
        this.rightNode = rightNode;
    }

    public BiNode<E> getParentNode() {
        return parentNode;
    }

    public void setParentNode(BiNode<E> parentNode) {
        this.parentNode = parentNode;
    }
}
