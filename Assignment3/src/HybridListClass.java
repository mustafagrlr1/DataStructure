import java.lang.reflect.Array;
import java.util.*;

/**
 * Class of LinkedList which holds arraylist as a data
 * @param <E>
 */
public class HybridListClass<E>{

    private Node<E> head;

    private Node<E> tail;

    private int size = 0;

    private int sizeLinkedList = 0;

    private final int capacity = 5;
	
    private static class Node<E>{
        private KWArrayList<E> theData;

        private Node<E> next;

        private Node<E> prev;
	
	@SuppressWarnings("unchecked")
        private Node(int size){
            next = null;
            prev = null;
            theData = (KWArrayList<E>) new KWArrayList<>(5);
        }
        private Node(int size, E item){
            this(null, item, null);
        }
	@SuppressWarnings("unchecked")
        private Node(Node<E> prev, E item, Node<E> next){
            this.next = next;
            this.prev = prev;
            theData = (KWArrayList<E>) new KWArrayList<>(5);
            theData.add(item);
        }

    }

    public HybridListClass(){
        head = null;
        tail = null;
    }

    /**Adds new arraylist to linkedlist
     * size is equal to capacity
     */
    public void newNode(){
        Node<E> newNode = new Node<E>(capacity);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        sizeLinkedList++;
    }


    /**Adds item to in to arraylist.
     * Checks if there is needed to be create a new array.
     * @param item
     */
    public void add(E item){
        if(size%capacity == 0){
            newNode();
        }
        Node<E> lastNode = getNode(sizeLinkedList-1);
        lastNode.theData.add(item);
        size++;
    }

    /**
     * Removes last item in the Arraylist.
     * if last arraylist is empty. Also removes the last node of Linkedlist.
     * @throws EmptyStackException Checks if there is no Linkedlist throws an exception
     */
    public void remove(){
        if(sizeLinkedList == 0) throw new NoSuchElementException();
        Node<E> lastNode = getNode(sizeLinkedList-1);
        lastNode.theData.remove(lastNode.theData.getSize()-1);
        size--;
        if(size%capacity == 0) {
            MyIterator<E> it = this.iterator();
            it.remove();
            sizeLinkedList--;
        }
    }

    /**
     * set to last arraylist's last element
     * @param item
     */
    public void setLast(E item){
        Node<E> lastNode = getNode(sizeLinkedList-1);
        lastNode.theData.set(size%capacity, item);
    }

    /**
     * get node from given index
     * @param index
     * @return
     */
    private Node<E> getNode(int index){
        MyIterator<E> it = this.iterator();
        return  it.next(index);
    }

    /**
     * get list from given index
     * @param index
     * @return
     */
    public KWArrayList<E> get(int index){
        return getNode(index).theData;
    }

    /**
     * get last list
     * @return
     */
    public KWArrayList<E> getLast(){
        if(getSizeLinkedList() == 0)throw new NoSuchElementException();
        return get(getSizeLinkedList()-1);
    }

    /**
     * size of arraylist
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * size of linkedlist
     * @return
     */
    public int getSizeLinkedList() {
        return sizeLinkedList;
    }

    /**
     * iterator of the class
     * @return
     */
    public MyIterator<E> iterator() {
        return new MyIterator<E>();
    }
    @SuppressWarnings("unchecked")
    public class MyIterator<E> implements ListIterator{
        private Node<E> currNext = (Node<E>) head;
        int position = 0;

        /**
         *
         * @return true if the current node's next is not null
         */
        public boolean hasNext() {
            return currNext != null;
        }

        /**
         * @return node if there is a next node
         */
        public Node<E> next(){
            try {
                Node<E> node = currNext;
                currNext = currNext.next;
                position++;
                return node;
            }catch(Exception e){
                System.out.println("Null");
                return null;
            }

        }
	@SuppressWarnings("unchecked")
        /**
         * gives node from given index
         * @param index
         * @return
         */
        public Node<E> next(int index){
            try {
                Node<E> node = (Node<E>) head;
                position = 0;
                for(int i=0 ; i<index && node.next!=null ; i++){
                    node = node.next;
                    position++;
                }
                return node;
            }catch(Exception e){
                System.out.println("Null");
                return null;
            }

        }

        /**
         *
         * @return true if there is a previous node
         */
        @Override
        public boolean hasPrevious() {
            return currNext.prev != null;
        }

        /**
         *
         * @return list from one preious node and turn back one node
         */
        @Override
        public Object previous() {
            try {
                KWArrayList<E> node = currNext.prev.theData;
                currNext = currNext.prev;
                position--;
                return node;
            }catch(Exception e){
                System.out.println("Null");
                return null;
            }
        }

        /**
         * gives next node position
         * @return
         */
        @Override
        public int nextIndex() {
            return position+1;
        }

        /**
         * gives the node position
         * @return
         */
        @Override
        public int previousIndex() {
            return position;
        }

        /**
         * delete last node of linkedlist
         */
        @Override
        public void remove() {
            if(sizeLinkedList == 0) throw new NoSuchElementException();
            if(head.next == null){
                head = null;
                tail = null;
            }
            for(int i=0 ; i<sizeLinkedList-2 ;i++){
                currNext = currNext.next;
            }
            currNext.next = null;
        }

        @Override
        public void set(Object o) {

        }

        @Override
        public void add(Object o) {

        }
    }

}
