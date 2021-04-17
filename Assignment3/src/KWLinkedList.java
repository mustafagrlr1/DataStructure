import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class KWLinkedList<E> {



    private Node<E> head = null;

    private int size = 0;

    private static class Node<E>{
        private E data;

        private Node<E> next;

        /** Creates a new node with a null next field.
         @param dataItem The data stored
         */
        private Node(E dataItem){
            data = dataItem;
            next = null;
        }
        /** Creates a new node that references another node.
         @param dataItem The data stored
         @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef){
            data = dataItem;
            next = nodeRef;
        }
    }
    /**
     *
     * @category iterator function has created.
     * hasNext()
     * next()
     * remove();
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> i = head;
            private int position = 0;
            public boolean hasNext() {
                return i != null;
            }
            public E next() {
                E r = i.data;
                i = i.next;
                position++;
                return r;
            }
            public void remove() {
                removeAfter(i);
                position--;
            }
        };
    }

    /** Add an item to the front of the list.
     @param item The item to be added
     */
     public void addFirst(E item){
         head = new Node<>(item, head);
         size++;
     }

    /** Add a node after a given node
     @param node The node preceding the new item
     @param item The item to insert
    */
     public void addAfter(Node<E> node, E item){
         node.next = new Node<>(item, node.next);
         size++;
     }

     /** Remove the node after a given node
      @param node The node before the one to be removed
      @return The data from the removed node, or null
                if there is no node to remove
      */
     private E removeAfter(Node<E> node){
         Node<E> temp = node.next;
         if(temp != null){
             node.next = temp.next;
             size--;
             return temp.data;
         }else{
             return null;
         }
     }
     public E remove(int index){
         if(index < 0 || index > size){
             throw new ArrayIndexOutOfBoundsException(index);
         }
         if(index == 0){
             return removeFirst();
         }
         Node<E> temp = head;
         for(int i=0 ; i<index-1 ; i++){
             temp = temp.next;
         }
         Node<E> tempp = temp;
         if(temp != null){
             temp.next = temp.next.next;
             size--;
             return tempp.data;
         }else{
             return null;
         }

     }

     /** Remove the first node from the list
      @return The removed node's data or null if the list is empty
      */
     private E removeFirst(){
         Node<E> temp = head;
         if(head != null){
             head = head.next;
         }
         if(temp != null){
             size--;
             return temp.data;
         }else{
             return null;
         }
     }

    /** Find the node at a specified position
     @param index The position of the node sought
     @return The node at index or null if it does not exist
     */
    public Node<E> getNode(int index){
        Node<E> node = head;
        for(int i=0 ; i < index && node != null ; i++){
            node = node.next;
        }
        return node;
    }

    /** Get the data at index
     @param index The position of the data to return
     @return The data at index
     @throws IndexOutOfBoundsException if index is out of range
     */

    public E get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> node = getNode(index);
        return node.data;
    }
    /** Store a reference to anEntry in the element at position index.
     @param index The position of the item to change
     @param newValue The new data
     @return The data previously at index
     @throws IndexOutOfBoundsException if index is out of range
     */
    public E set(int index, E newValue){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> node = getNode(index);
        E value = node.data;
        node.data = newValue;
        return value;
    }

    /** Insert the specified item at index
     @param index The position where item is to be inserted
     @param item The item to be inserted
     @throws IndexOutOfBoundsException if index is out of range
     */
    public void add(int index, E item){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(index == 0){
            addFirst(item);
        }else{
            Node<E> node = getNode(index-1);
            addAfter(node, item);
        }
    }
    /** Append item to the end of the list
     @param item The item to be appended
     @return true (as specified by the Collection interface)
     */
    public boolean add(E item){
        add(size, item);
        return true;
    }

    /** Get the index of node
      @param target The target node
      @return the node index
     */
    public int indexOf(E target){
        Node<E> node = head;
        int count = 0;
        while(node != null){
            if(node.data == target){
                return count;
            }
            count++;
            node = node.next;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }
}
