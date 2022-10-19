import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *	Class for a binary tree that stores type E objects.
 * @param <E> This is type of the data for the BinaryTree.
 */
public class BinaryTree<E> implements Serializable {
    /**
     * Class to encapsulate a tree node.
     * @param <E> This is type of the data for the Node.
     */
    protected static class Node<E> implements Serializable {
        // Data Fields
        /**
         * The information stored in this node.
         */
        protected E data;
        /**
         * Reference to the left child.
         */
        protected Node<E> left;
        /**
         * Reference to the right child.
         */
        protected Node<E> right;

        // Constructors
        /**
         * Construct a node with given data and no children.
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Return a string representation of the node.
         * @return A string representation of the data fields
         */
        public String toString() {
            return data.toString();
        }
    }

    //Data Field
    /**
     * The root of the binary tree
     */
    protected Node<E> root;

    // Constructors
    /**
     * The no-parameter constructor merely sets the root to null.
     */
    public BinaryTree() {
        root = null;
    }
    /**
     * The constructor that takes a Node as a parameter.
     * This is a protected constructor because client classes
     * do not know about the Node class.
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * The constructor takes three parameters
     * @param data to be referenced by the root node
     * @param leftTree it will become its left subtree
     * @param rightTree it will become its right subtree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if(leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if(rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    // Methods

    /**
     * Return the left subtree.
     * @return The left subtree or null if either the root or
     * the left subtree is null.
     */
    public BinaryTree<E> getLeftSubtree() {
        if(root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right subtree.
     * @return The right subtree or null if either the root or
     * the right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if(root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /**
     * This method returns a string representation of the BinaryTree object.
     *
     * @return a string preorder representation of the BinaryTree object.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal.
     * @param node The local root
     * @param depth the depth
     * @param sb The string buffer to save the output
     */
    public void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for(int i=1; i < depth; i++) {
            sb.append("  ");
        }
        if(node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth+1, sb);
            preOrderTraverse(node.right, depth+1, sb);
        }
    }

    /**
     * Return a list that contains the elements of the tree in ascending order.
     * @return list The list of the elements
     */
    public List<E> toList() {
        List<E> list = new ArrayList<E>();
        inOrderTraverse(root, list);
        return list;
    }

    /**
     * Perform a inorder traversal.
     * While traversing the tree, the elements of the tree are added to list.
     * @param node The local root
     * @param list The list contains the elements of the tree
     */
    public void inOrderTraverse(Node<E> node, List<E> list) {
        if(node == null)
            return;
        else {
            inOrderTraverse(node.left, list);
            list.add(node.data);
            inOrderTraverse(node.right, list);
        }
    }

    /**
     * Method to read a binary tree.
     * pre: The input consists of a preorder traversal
     * 		of the binary tree. The line "null" indicates a null tree.
     * @param scan the Scanner attached to the input file.
     * @return The binary tree
     */
    public BinaryTree<String> readBinaryTree(Scanner scan){
        // Read a line and trim leading and trailing spaces.
        String data = scan.next();
        if(data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }

}