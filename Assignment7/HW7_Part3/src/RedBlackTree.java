/**
 * Implementation of a Red-Black Tree Data Structure
 * @author Jacob / Koffman and Wolfgang
 *
 * @param <E> The data type of items stored in the tree. Must be Comparable
 */
public class RedBlackTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> {

    /**
     * Class to represent a Red-Black node
     * @author Jacob / Koffman and Wolfgang
     *
     * @param <E> The data type of items stored in the node. Must be Comparable
     */
    private static class RedBlackNode<E> extends Node<E> {
        // Additional data members
        /**
         * Color indicator. True if red, false if black.
         */
        private boolean isRed;

        // Constructor
        /**
         * Create a RedBlackNode with the default color of red and the given data field.
         * @param item The data field
         */
        public RedBlackNode(E item) {
            super(item);
            isRed = true;
        }

        // Methods
        /**
         * Return a string representation of this object.
         * The color (red or black) is appended to the node's contents.
         * @return String representation of this object
         */
        @Override
        public String toString() {
            if(isRed) {
                return "Red  : " + super.toString();
            } else {
                return "Black: " + super.toString();
            }
        }
    }

    // Data Field
    /** A boolean variable to indicate that the black height was reduced
     by a call to thhe recursive delete method. */
    private boolean fixupRequired;

    /**
     * Starter method add.
     * pre: The object to insert must implement the
     * 		Comparable interface.
     * @param item The object being inserted
     * @return true if the object is inserted, false
     * 			if the object already exists in the tree
     */
    public boolean add(E item) {
        if(root == null) {
            root = new RedBlackNode<E>(item);
            ((RedBlackNode<E>) root).isRed = false; // root is black.
            return true;
        } else {
            root = add((RedBlackNode<E>) root, item);
            ((RedBlackNode<E>) root).isRed = false; // root is always black.
            return addReturn;
        }
    }

    /**
     * Recursive add method.
     * post: The data field addReturn is set true if the item is added to
     * 		the tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the
     * 			inserted item
     */
    private Node<E> add(RedBlackNode<E> localRoot, E item) {
        if(item.compareTo(localRoot.data) == 0) {
            // item already in the tree.
            addReturn = false;
            return localRoot;
        }
        else if(item.compareTo(localRoot.data) < 0) {
            // item < localRoot.data
            if(localRoot.left == null) {
                // Create new left child.
                localRoot.left = new RedBlackNode<E>(item);
                addReturn = true;
                return localRoot;
            } else { // Need to search.
                // Check for two red children, swap colors if found.
                moveBlackDown(localRoot);
                // Recursively add on the left.
                localRoot.left = add((RedBlackNode<E>) localRoot.left, item);
                // See whether the left child is now red
                if(((RedBlackNode<E>) localRoot.left).isRed) {
                    if(localRoot.left.left != null
                            && ((RedBlackNode<E>) localRoot.left.left).isRed) {
                        // Left-left grandchild is also red.
                        // Single rotation is necessary.
                        ((RedBlackNode<E>) localRoot.left).isRed = false;
                        localRoot.isRed = true;
                        return rotateRight(localRoot);
                    }
                    else if(localRoot.left.right != null
                            && ((RedBlackNode<E>) localRoot.left.right).isRed) {
                        // Left-right grandchild is also red.
                        // Double rotation is necessary.
                        localRoot.left = rotateLeft(localRoot.left);
                        ((RedBlackNode<E>) localRoot.left).isRed = false;
                        localRoot.isRed = true;
                        return rotateRight(localRoot);
                    }
                }
                return localRoot;
            }
        }
        else { // item > localRoot.data
            if(localRoot.right == null) {
                // Create new right child.
                localRoot.right = new RedBlackNode<E>(item);
                addReturn = true;
                return localRoot;
            } else { // Need to search.
                // Check for two red children, swap colors if found.
                moveBlackDown(localRoot);
                // Recursively add on the right.
                localRoot.right = add((RedBlackNode<E>) localRoot.right, item);
                // See whether the right child is now red
                if(((RedBlackNode<E>) localRoot.right).isRed) {
                    if(localRoot.right.right != null
                            && ((RedBlackNode<E>) localRoot.right.right).isRed) {
                        // Right-right grandchild is also red.
                        // Single rotation is necessary.
                        ((RedBlackNode<E>) localRoot.right).isRed = false;
                        localRoot.isRed = true;
                        return rotateLeft(localRoot);
                    }
                    else if(localRoot.right.left != null
                            && ((RedBlackNode<E>) localRoot.right.left).isRed) {
                        // Right-left grandchild is also red.
                        // Double rotation is necessary.
                        localRoot.right = rotateRight(localRoot.right);
                        ((RedBlackNode<E>) localRoot.right).isRed = false;
                        localRoot.isRed = true;
                        return rotateLeft(localRoot);
                    }
                }
                return localRoot;
            }
        }
    }

    /**
     * Check to see whether both children of the given node are red.
     * If so, make them black and change the localRoot's color to red.
     * @param localRoot The node to check whether both children are red or not
     */
    private void moveBlackDown(RedBlackNode<E> localRoot) {
        // see if both children are red
        if(localRoot.left != null && localRoot.right != null ) {
            if( ((RedBlackNode<E>) localRoot.left).isRed && ((RedBlackNode<E>) localRoot.right).isRed) {
                // make them black and myself red
                ((RedBlackNode<E>) localRoot.left).isRed = false;
                ((RedBlackNode<E>) localRoot.right).isRed = false;
                ((RedBlackNode<E>) localRoot).isRed = true;
            }
        }
    }

}
