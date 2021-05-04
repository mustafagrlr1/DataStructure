/**
 * MaxHeap class
 * @author Mustafa Gurler
 */


import java.util.*;

public class Heap<E extends Comparable<E>> implements Iterable<E> {

    private E[] heap;// an arraylist for heap
    private int n; // the size of heap
    private final int INITIAL_CAPACITY = 3;


    /**
     * Constructor for heap class initial capacity is 3
     */
    @SuppressWarnings("unchecked")
    public Heap(){
        n=0;
        heap = (E[]) new Comparable[INITIAL_CAPACITY+1];
    }

    /**
     * @return size of heap
     */
    public int getSize(){
        return n;
    }

    /**
     *
     * @param size new size of the heap
     */
    public void setSize(int size){
        this.n = size;
    }

    /**
     * @return checks if heap is empty
     */
    public boolean isEmpty(){
        return (n == 0);
    }

    /**
     * extends the length of heap
     * @param capacity extended size of heap
     */
    private void resize(int capacity){
        heap = Arrays.copyOf(heap, capacity);
    }

    /**
     * Insert a new data to next heap index
     * and checks if there is a reheapify
     * @param data needs to be inserted in heap
     */
    public void insert(E data){
        if(n == heap.length-1){
            resize(heap.length*2);
        }
        n++;
        heap[n] = data;
        swim(n);
    }

    /**
     * reheapify the heap bottom-up
     * @post (k/2) can not be 0.
     * @param k size of heap
     */
    private void swim(int k){
        if(k/2 == 0){
            return;
        }
        int i = heap[k/2].compareTo(heap[k]);
        while(k > 1 && i < 0){
            E temp = heap[k/2];
            heap[k/2] = heap[k];
            heap[k] = temp;
            k = k/2;
            if(k/2 == 0){
                return;
            }
            i = heap[k/2].compareTo(heap[k]);
        }
    }

    /**
     * sorts the heap for every possibility
     */
    private void sortHeap(){
        for(int i=1 ; i<=n ; i++){
            swimBottom(i);
        }
    }

    /**
     * carries the smaller element to bottom from top
     * if the element is not the right position
     * @param k the hill of the tree needs to be changed
     */
    private void swimBottom(int k){
        if((k*2)+1 > n){
            return;
        }
        int j = heap[(k*2)].compareTo(heap[(k*2)+1]);// compares left and right child // 1 yada -1 gelcek
        int i = heap[(k*2)].compareTo(heap[k]); // compares left child and parent // 1 olursa gircek
        int m = heap[(k*2)+1].compareTo(heap[k]); //compares the right child and parent // 1 olursa gircek
        if(j == 1 && i == 1){ // if left child is bigger than parent switch them
            E temp = heap[k*2];
            heap[k*2] = heap[k];
            heap[k] = temp;
            swimBottom(k*2);
        }else if(j == -1 && i == 1){ // if right child is bigger than parent switch them.
            E temp = heap[(k*2)+1];
            heap[(k*2)+1] = heap[k];
            heap[k] = temp;
            swimBottom((k*2)+1);
        }
    }

    /**
     * shows the heap top to bottom
     */
    public void print(){
        for(int i=1 ; i <= getSize() && heap[i] != null ; i++){
            System.out.print(heap[i] + " ");
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
     * finds the depth of given heap's data
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

    private E get(int i){
        return heap[i];
    }

    @SuppressWarnings("unchecked")
    /**
     * Searchs the max heap to find the data
     * @param data needs to be find
     * @return true if data has been found
     */
    public boolean search(E data){
        for(int i=1 ; i<=getSize() ; i++){
            if(heap[i].compareTo(data) == 0){
                int j = getDepth(i);
                System.out.println(j + ".depth" + " " + i + ".number" );
                return true;
            }
        }
        return false;
    }

    /**
     * Merges heap with another heap
     * @param other other heap
     * @return true if merge operation is successful
     */
    public boolean mergeHeap(Heap<E> other){
        for(int i=1 ; i <= other.getSize() ; i++){
            this.insert(other.get(i));
        }
        return true;
    }

    /**
     * removes the ith largest element in the heap
     * @param i place of the element
     * @return data's of the elemet
     */
    public E remove(int i){
        if(i < 0 || i > n){
            throw new NoSuchElementException("Index is wrong");
        }
        if(n == 0){
            throw new NoSuchElementException("Heap is empty");
        }
        E result = get(i);
        if(n == 1){
            setSize(0);
        }else{
            heap[i] = heap[n];
            setSize(getSize()-1);
            swimBottom(i);
        }
        return result;
    }

    /**
     * gets heap array
     * @return
     */
    public E[] getHeap() {
        return heap;
    }

    /**
     * Iterator class for Heap class
     */
    public class ArrayIterator implements Iterator<E> {
        int current = 1;  // the current element we are looking at
        // starts with first array

        // return whether or not there are more elements in the array that
        public boolean hasNext() {
            return current < n;
        }

        // return the next element of the iteration and move the current
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return heap[current++];
        }

        /**
         * items need to be inserted to heap , starts from end and change the
         * last value of heap
         * @param item the data needs to be inserted
         * @return last value of heap
         */
        public E setValue(E item){
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = heap[n];
            heap[n] = item;
            swim(n);
            return result;
        }
    }

    /**
     * iterator method for Heap class
     * @return iterator
     */
    @Override
    public ArrayIterator iterator() {
        return new ArrayIterator();
    }





}
