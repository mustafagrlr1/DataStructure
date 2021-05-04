/**
 * Binary Search Tree MaxHeap class
 * @author Mustafa Gurler
 */

import java.util.Random;

public class BSTHeapTree<E extends Comparable>{

    private Node root;
    private int totalNodes;
    private int height;
    private int leftNode = 0;
    private int rightNode = 0;

    /**
     * inner class of BSTHeap Tree
     * @param <E>
     */
    public static class Node<E extends Comparable<E>>{
        protected Node left, right;
        private HeapBST<E> data;// data is gonna be inserted hear
        protected int height; // depth of bst
        protected int sizeOfHeap; // size of only one heap
        private final int MAXIMUM_HEAP_SIZE = 7;  // maximum size of heap

        /**
         * Constructor of heapBST
         */
        public Node(){
            this( null, null, 0, 0);
            data = new HeapBST<>();
        }

        private Node(Node<E> left, Node<E> right, int h, int sf){
            this.left = left;
            this.right = right;
            this.height = h;
            this.sizeOfHeap = sf;
        }
    }
    public BSTHeapTree(){
        root = new Node();
        totalNodes = 0;
        height = 0;
    }


    /**
     * remove method starts in hear and jumps to private remove
     * @param item the needs to be removed
     * @return returns the removed value in the heap
     */
    public int remove(E item){
        Node current = root;
        return remove(current, item);
    }

    /**
     * traverse the heaps and finds the item
     * @param current parent, left and right child of the bst
     * @param item the needs to be removed
     * @return returns the removed value in the heap
     */
    private int remove(Node current, E item){
        if(current == null){
            return -1;
        }
        if((current.data.traverse(item))){// traverse the heap tries to find the item
            current.data.remove(current.data.getPosition());
            return find(item);
        }
        int result1 = 0, result2 = 0;

        // compares the items if item is smaller than heap
        if(current.left != null && current.data.getBiggest().compareTo(item) == 1){
            result1 = remove(current.left, item);
        }
        // compares the item if item is bigger than heap biggest number
        if(current.right != null && current.data.getBiggest().compareTo(item) == -1) {
            result2 = remove(current.right, item);
        }
        if(result1 != -1){
            return result1;
        }else{
            return result2;
        }
    }

    /**
     * adds item to heap
     * @param item needs to be inserted
     * @return the value of occurence of heap
     */
    public int add(E item){
        Node current = root;
        return add(current, item);
    }

    /**
     * adds item to heap
     * @param current root or left and right child of root
     * @param item needs to be inserted
     * @return the value of occurence of heap
     */
    private int add(Node current, E item) {
        // if heap is full there is no needed to be added of heap
        if(current.sizeOfHeap != (current.MAXIMUM_HEAP_SIZE)) {
            if(!(current.data.traverse(item))){
                current.sizeOfHeap++;
            }
            current.data.insert(item);
            return (Integer) current.data.getOccurence();
        }
        // if heap has same value with item increments to number of this item
        if(current.sizeOfHeap == (current.MAXIMUM_HEAP_SIZE) && (current.data.traverse(item))){
            current.data.insert(item);
            return (Integer) current.data.getOccurence();
        }
        // compares the items if item is smaller than heap
        if(current.left != null && current.data.getBiggest().compareTo(item) == 1){
            return add(current.left, item);
        }
        // compares the items if item is smaller than heap
        else if(current.right != null && current.data.getBiggest().compareTo(item) == -1){
            return add(current.right, item);
        }else if(current.data.getBiggest().compareTo(item) == 1){
            Node left = new Node();
            current.left = left;
            current = current.left;
            current.sizeOfHeap++;
            current.data.insert(item);
            return (Integer) current.data.getOccurence();
        }else if(current.data.getBiggest().compareTo(item) == -1){
            Node right = new Node();
            current.right = right;
            current = current.right;
            current.data.insert(item);
            current.sizeOfHeap++;
            return (Integer) current.data.getOccurence();
        }
        return 0;
    }

    /**
     * finds the item in the if it is added before.
     * @param item needs to be searched
     * @return to number of occurence in the heap
     */
    public int find(E item){
        if(root == null){
            return 0;
        }
        Node current = root;
        return find(current, item);
    }

    /**
     * finds the item in the if it is added before
     * @param current root or left and right child of root
     * @param item needs to be searched
     * @return to number of occurence in the heap
     */
    public int find(Node current, E item){
        if(current == null){
            return 0;
        }
        if(current.data.traverse(item)){
            return (Integer) current.data.getOccurence();
        }
        int result = find(current.left, item);
        int result2 = find(current.right, item);
        if(result != 0){
            return result;
        }else if(result2 != 0){
            return result2;
        }else{
            return 0;
        }
    }

    /**
     * finds the biggest occurence in the heap
     * @return biggest occurence
     */
    public int find_mode(){
        Node current = root;
        int maxNumber = 0;
        int max = 0;
        if(root == null){
            return -1;
        }
        return find_mode(current, max);
    }

    /**
     * finds the biggest occurence in the heap
     * @param current root or left and right child of root
     * @param max max number of occurence. starts with zero
     * @return biggest occurence
     */
    public int find_mode(Node current, int max){
        if(current == null){
            return max;
        }
        int maxHeapData = 0;
        //searches the heap if there is more biggest occurence than before
        for(int i=1 ; i <= current.sizeOfHeap ; i++){
            current.data.setPosition(i);
            maxHeapData = current.data.getOccurence();
            current.data.setPosition(i);
            if(maxHeapData > max){
                max = maxHeapData;
            }
        }
        //tries to reach left and right child if there is more biggest occurence than before
        int max1 = (int)find_mode(current.left, max);
        int max2 = (int)find_mode(current.right, max);
        if(max1 > max2){
            return max1;
        }else{
            return max2;
        }
    }

    /**
     * depth of bst
     * @return depth
     */
    public int getDepth(){
        Node current = root;
        height = 0;
        return getDepth(current , height);
    }

    /**
     * depth of bst
     * @param current root or left and right child of
     * @param max tries to find depth
     * @return max depth of heap
     */
    public int getDepth(Node current, int max){
        if(current == null){
            return max;
        }
        int result =  getDepth(current.left, max++);
        int result2 = getDepth(current.right, max++);
        if(result > result2){
            return result;
        }else{
            return result2;
        }

    }

    /**
     * generates random number for adding
     * @return
     */
    public static int generateRandomIntIntRange() {
        Random r = new Random();
        return r.nextInt(5000);

    }

    /**
     * sort number for test cases
     * @param array
     */
    public static void sortNumber(int[] array){
        for(int i=0 ; i<3000 ; i++){
            for(int j=0 ; j<3000 ; j++){
                if(array[j] > array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }


    public static void main(String[] args){

        BSTHeapTree<Integer> bst = new BSTHeapTree<>();
        System.out.println(bst.add(37));
        System.out.println(bst.add(23));
        System.out.println(bst.add(10));
        System.out.println(bst.add(10));
        System.out.println(bst.add(10));
        System.out.println(bst.add(16));
        System.out.println(bst.add(19));
        System.out.println(bst.add(9));
        System.out.println(bst.add(10));
        System.out.println(bst.add(9));
        System.out.println(bst.add(3));
        System.out.println(bst.add(31));
        System.out.println(bst.add(15));
        System.out.println(bst.add(29));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(124));
        System.out.println(bst.add(52));
        System.out.println(bst.add(13));
        System.out.println(bst.add(9));
        System.out.println(bst.add(9));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(124));
        System.out.println(bst.add(13));System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));System.out.println(bst.add(13));System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));System.out.println(bst.add(13));System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println(bst.add(13));System.out.println(bst.add(13));System.out.println(bst.add(13));
        System.out.println(bst.add(13));
        System.out.println("remove");

        System.out.println(bst.remove(13));
        System.out.println(bst.remove(13));
        System.out.println(bst.remove(13));
        System.out.println(bst.remove(13));
        System.out.println(bst.remove(13));
        System.out.println("mustafa "  +  bst.find(124));
        System.out.println(bst.find(13));
        System.out.println(15 + " " + bst.remove(15));
        System.out.println(bst.remove(15));
        System.out.println(bst.find(52));
        System.out.println(bst.remove(52));
        System.out.println(bst.remove(52));

        System.out.println(bst.add(13));
        System.out.println(bst.remove(13));

        System.out.println(bst.find_mode());






    }
}
