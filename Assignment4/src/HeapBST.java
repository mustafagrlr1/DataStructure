/**
 * MaxHeapBST class
 * @author Mustafa Gurler
 * 1. 2. 3. parti yaptin 4. part icin setLast methoduna bakman lazim
 */


import java.util.*;

public class HeapBST<E extends Comparable<E>> implements Iterator {

    E[] HeapBST;// an arraylist
    private int n; // the size of HeapBST
    private final int INITIAL_CAPACITY = 7;
    private Integer[] occurences;
    /**
     * Constructor for HeapBST class initial capacity is 3
     */
    @SuppressWarnings("unchecked")
    public HeapBST(){
        n=0;
        HeapBST = (E[]) new Comparable[INITIAL_CAPACITY+1];
        occurences = new Integer[INITIAL_CAPACITY+1];
    }

    /**
     * get occurences of heap
     * @return
     */
    public Integer[] getOccurences() {
        return occurences;
    }

    /**
     * get only one occurence item of heap
     * @return
     */
    public int getOccurence(){
        return getOccurences()[getPosition()];
    }

    /**
     * gets what item in the heap index
     * @param index index of heap to be got
     * @return returns the number in the heap
     */
    public E getNumber(int index){
        return HeapBST[index];
    }

    /**
     * occurences may be change during the addition
     * if numbers are same
     * @param occurences
     */
    public void setOccurences(Integer[] occurences) {
        this.occurences = occurences;
    }

    /**
     * gets the biggest number in the heap
     * @return
     */
    public E getBiggest(){
        return HeapBST[1];
    }

    /**
     * @return size of HeapBST
     */
    public int getSize(){
        return n;
    }

    /**
     *
     * @param size new size of the HeapBST
     */
    public void setSize(int size){
        this.n = size;
    }

    /**
     * @return checks if HeapBST is empty
     */
    public boolean isEmpty(){
        return (n == 0);
    }

    /**
     * extends the length of HeapBST
     * @param capacity extended size of HeapBST
     */
    private void resize(int capacity){
        HeapBST = Arrays.copyOf(HeapBST, capacity);
        occurences = Arrays.copyOf(occurences, capacity);
    }

    /**
     * Insert a new data to next HeapBST index
     * and checks if there is a reHeapBSTify
     * @param data needs to be inserted in HeapBST
     */
    @SuppressWarnings("unchecked")
    public void insert(E data){
        if(HeapBST == null){
            HeapBST = (E[]) new Comparable[INITIAL_CAPACITY+1];
        }
        if(n == HeapBST.length-1){
            resize(HeapBST.length*2);
        }
        
        // increments number if data is in the heap
        if(traverse(data)){
            occurences[getPosition()] += 1;
        }else {// adds the number to heap
            n++;
            HeapBST[n] = data;
            traverse(data);
            occurences[n] = 1;
        }
        swim(n); // heaptify to heap if it is needs to be go up
    }


    /**
     * Traversing the HeapBST to find if there is an equal item
     * @param data needs to be added
     * @return if data is in the HeapBST returns true
     */
    public boolean traverse(E data){
       if(HeapBST == null){
           return false;
       }
       position = 1;
       for(int i=1 ; i <= getSize() ; i++){
           setPosition(i);
           if(HeapBST[i].compareTo(data) == 0 ){
               return true;
           }
       }
       return false;
    }

    /**
     * reHeapBSTify the HeapBST bottom-up
     * @post (k/2) can not be 0.
     * @param k size of HeapBST
     */
    private void swim(int k){
        if(k/2 == 0){
            return;
        }
        int i = HeapBST[k/2].compareTo(HeapBST[k]);
        while(k > 1 && i < 0){
            E temp = HeapBST[k/2];
            HeapBST[k/2] = HeapBST[k];
            HeapBST[k] = temp;
            int temp1 = occurences[k/2];
            occurences[k/2] = occurences[k];
            occurences[k] = temp1;
            k = k/2;
            if(k/2 == 0){
                return;
            }
            i = HeapBST[k/2].compareTo(HeapBST[k]);
        }
    }

    /**
     * sorts the HeapBST for every possibility
     */
    private void sortHeapBST(){
        for(int i=1 ; i<=n ; i++){
            swimBottom(i);
        }
    }

    /**
     * carries the smaller element to bottom from top
     * if the element is not the right position
     * @param k
     */
    private void swimBottom(int k){
        if((k*2)+1 > n){
            return;
        }
        int j = HeapBST[(k*2)].compareTo(HeapBST[(k*2)+1]);// compares left and right child // 1 yada -1 gelcek
        int i = HeapBST[(k*2)].compareTo(HeapBST[k]); // compares left child and parent // 1 olursa gircek
        int m = HeapBST[(k*2)+1].compareTo(HeapBST[k]); //compares the right child and parent // 1 olursa gircek
        if(j == 1 && i == 1){ // if left child is bigger than parent switch them
            E temp = HeapBST[k*2];
            HeapBST[k*2] = HeapBST[k];
            HeapBST[k] = temp;
            int temp2 = occurences[k*2];
            occurences[k*2] = occurences[k];
            occurences[k] = temp2;
            swimBottom(k*2);
        }else if(j == -1 && i == 1){ // if right child is bigger than parent switch them.
            E temp = HeapBST[(k*2)+1];
            HeapBST[(k*2)+1] = HeapBST[k];
            HeapBST[k] = temp;
            int temp2 = occurences[k*2];
            occurences[k*2] = occurences[k];
            occurences[k] = temp2;
            swimBottom((k*2)+1);
        }
    }

    /**
     * shows the HeapBST top to bottom
     */
    private void print(int size){
        for(int i=1 ; i <= size && HeapBST[i] != null ; i++){
            System.out.print(HeapBST[i] + " ");
        }
    }

    /**
     * @return gives random number
     */
    public static int generateRandomIntIntRange() {
        Random r = new Random();
        return r.nextInt((5000) + 1);
    }

    /**
     * finds the depth of given HeapBST 's data
     * @param i given data
     * @return returns the depth of given data
     */
    private int getDepth(int i){
        for(int j = 0 ; j < i ; j++){
            if((int)(i/Math.pow(2,j)) == 1){
                return j+1;
            }
        }
        return 0;
    }

    /**
     * gets the item from given index
     * @param i
     * @return
     */
    private E get(int i){
        return HeapBST[i];
    }

    /**
     * searches the max HeapBST to find the data
     * @param data needs to be find
     * @return true if data has been found
     */
    public boolean search(E data){
        for(int i=1 ; i<=getSize() ; i++){
            if(HeapBST[i].compareTo(data) == 0){
                int j = getDepth(i);
                return true;
            }
        }
        return false;
    }

    /**
     * merges two heap
     * @param other heap needs to be added 
     * @return true if merging operation has been completed
     */
    public boolean mergeHeapBST(HeapBST<E> other){
        for(int i=1 ; i <= other.getSize() ; i++){
            this.insert(other.get(i));
        }
        return true;
    }

    /**
     * removes the ith largest element in the HeapBST
     * @param i place of the element
     * @return data's of the element
     */
    public int remove(int i){
        if(i < 0 || i > n){
            throw new NoSuchElementException("Index is wrong");
        }
        if(n == 0){
            throw new NoSuchElementException("HeapBST is empty");
        }
        if(occurences[i] > 1) {
            occurences[i] = occurences[i] - 1;
            return occurences[i];
        }
        occurences[i] = 0;
        HeapBST[i] = HeapBST[n];
        occurences[i] = occurences[n];
        return occurences[n];
    }

    /**
     * iterators position set method
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * gets method for iterator position
     * @return
     */
    public int getPosition() {
        return position;
    }

    private int position = 1; // iterator position starts with 1
    
    @Override
    /**
     * returns null if heap has next value
     */
    public boolean hasNext() {
        return position < n;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * increments the heap iterator position and returns the current position
     */
    public E next() {
        if(hasNext()) {
            E result = HeapBST[position];
            position++;
            return result;
        }
        return null;
    }

}
