import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 * Implementation of a Skip-List data structure
 * @author Jacob / Koffman and Wolfgang
 *
 *@param <E> The type of data stored. Must be a Comparable
 */
public class SkipList<E extends Comparable<E>> implements SearchTree<E>{
    // Nested Class

    /**
     * Static class to contain data and links
     * @author Jacob / Koffman & Wolfgang
     *
     * @param <E> The type of data stored. Must be a Comparable
     */
    static class SLNode<E>{
        /**
         * The links of the node.
         */
        SLNode<E>[] links;
        /**
         * The information stored in this node.
         */
        E data;

        /**
         * Create a node of level m
         * @param m The level of the node
         * @param data The data to be stored
         */
        @SuppressWarnings("unchecked")
        public SLNode(int m, E data){
            links = (SLNode<E>[]) new SLNode[m];  // create links
            this.data = data;					  // store item
        }

        /**
         * This method returns a string representation of the SkipList Node object.
         *
         * @return a string representation of the SkipList Node object.
         */
        public String toString(){
            return (data.toString() + " |" + links.length + "|");
        }
    }

    // Data Fields

    /**
     * Head of the skip-list
     */
    public SLNode<E> head;
    /**
     * Size of the skip list
     */
    private int size;
    /**
     * The maximum level of the skip-list
     */
    private int maxLevel;
    /**
     * Smallest power of 2 that is greater than the current skip-list size
     */
    private int maxCap;
    /**
     * Natural log of 2
     */
    static final double LOG2 = Math.log(2.0);
    /**
     * Minimum possible integer value for the head
     */
    static final int MIN = Integer.MIN_VALUE;
    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Constructor
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public SkipList(){
        size = 0;
        maxLevel = 0;
        maxCap = computeMaxCap(maxLevel);
        head = new SLNode(maxLevel, MIN);
    }

    /**
     * Search for an item in the list
     * @param target The item being sought
     * @return An SLNode array which references the predecessors of the target at each level.
     */
    @SuppressWarnings("unchecked")
    private SLNode<E>[] search(E target){
        SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for(int i = current.links.length - 1; i >= 0; i--){
            while(current.links[i] != null
                    && current.links[i].data.compareTo(target) < 0){
                current = current.links[i];
            }
            pred[i] = current;
        }
        return pred;
    }

    /**
     * Find an object in the skip-list
     * @param target The item being sought
     * @return A reference to the object in the skip-list that matches
     * 		   the target. If not found, null is returned
     */
    @Override
    public E find(E target){
        SLNode<E>[] pred = search(target);
        if(pred[0].links[0] != null &&
                pred[0].links[0].data.compareTo(target) == 0){
            return pred[0].links[0].data;
        } else {
            return null;
        }
    }

    /**
     * Inserts the given item
     * @param item The item to add
     * @return true as the item is added
     */
    @Override
    public boolean add(E item){
        size++;
        SLNode<E>[] pred = search(item);
        if(size > maxCap){
            maxLevel++;
            maxCap = computeMaxCap(maxLevel);
            head.links = Arrays.copyOf(head.links, maxLevel);
            pred = Arrays.copyOf(pred, maxLevel);
            pred[maxLevel - 1] = head;
        }
        SLNode<E> newNode = new SLNode<E>(logRandom(), item);
        for(int i = 0; i < newNode.links.length; i++){
            newNode.links[i] = pred[i].links[i];
            pred[i].links[i] = newNode;
        }
        return true;
    }

    /**
     * Removes an instance of the given item
     * @param item The item to remove
     * @return true if the item is removed, false if the item is not in the list
     */
    @Override
    public boolean remove(E item){
        SLNode<E>[] pred = search(item);
        if(pred[0].links != null &&
                pred[0].links[0].data.compareTo(item) != 0){
            return false; //item is not in the list
        } else {
            size--; //don't re-adjust maxCap and level, as we may have nodes at these levels
            SLNode<E> deleteNode = pred[0];
            for(int i = 0; i < deleteNode.links.length; i++){
                if(pred[i].links[i] != null)
                    pred[i].links[i] = pred[i].links[i].links[i];
            }
            return true;
        }
    }

    /**
     * Method to generate a logarithmic distributed integer between 1 and maxLevel.
     *  I.E. 1/2 of the values are 1, 1/4 are 2, etc.
     * @return a random logarithmic distributed int between 1 and maxLevel
     */
    private int logRandom(){
        int r = rand.nextInt(maxCap);
        int k = (int) (Math.log(r + 1) / LOG2);
        if(k > maxLevel - 1)
            k = maxLevel - 1;
        return maxLevel - k;
    }

    /**
     * Recompute the max cap
     * @param level The level
     * @return The max cap
     */
    private int computeMaxCap(int level){
        return (int) Math.pow(2, level) - 1;
    }

    /**
     * This method returns a string representation of the SkipList object.
     *
     * @return a string representation of the SkipList object.
     */
    @SuppressWarnings("rawtypes")
    public String toString(){
        if(size == 0)
            return "Empty";
        StringBuilder sc = new StringBuilder();
        SLNode itr = head;
        sc.append("Head: " + maxLevel);
        int lineMaker = 0;
        while(itr.links[0] != null){
            itr = itr.links[0];
            sc.append(" --> " + itr.toString());
            lineMaker++;
            if(lineMaker == 10){
                sc.append("\n");
                lineMaker = 0;
            }
        }
        return sc.toString();
    }

    /**
     * Add the elements of the tree to list in ascending order.
     * @param list The list should be contain the elements of the skiplist with in-order
     */
    public void inOrderTraverse(ArrayList<E> list) {
        inOrderTraverse(head, list);
    }

    /**
     * Perform a inorder traversal.
     * While traversing the tree, the elements of the tree are added to list.
     * @param node The local root
     * @param list The list contains the elements of the tree
     */
    public void inOrderTraverse(SLNode<E> node, ArrayList<E> list) {
        if(size == 0 || node == null || node.links[0] == null)
            return;
        else {
            list.add(node.data);
            inOrderTraverse(node.links[0], list);
        }
    }

    /**
     * Returns true if target is found in the tree.
     * @param target The object being sought
     * @return true if the object exists in the tree,
     * 			false if the object does not exist
     */
    @Override
    public boolean contains(E target) {
        return find(target) != null;
    }

    /**
     * Removes target (if found) from tree and returns it;
     * otherwise, returns null.
     * @param target The object to be deleted
     * @return The object deleted from the tree
     * 			or null if the object was not in the tree
     */
    @Override
    public E delete(E target) {
        if(!remove(target))
            return null;
        else
            return target;
    }
}