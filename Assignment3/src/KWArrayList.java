import java.util.Arrays;
import java.util.Objects;

public class KWArrayList<E>{

    private static final int INITIAL_CAPACITY = 5;

    private E[] theData;

    private int size = 0;

    private int capacity = 0;


    public KWArrayList(){
        this(INITIAL_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public KWArrayList(int size){
        capacity = size;
        theData = (E[]) new Object[capacity];
    }

    /**
     * adds an element in the arraylist if arraylist is full
     * capacity has been doubled
     * @param anEntry
     * @return true if adding operation has been completed
     */
    public boolean add(E anEntry){
        if(size == capacity){
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * adds element to given index and shifted next elements
     * @param index
     * @param anEntry
     */
    public void add(int index, E anEntry){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(size == capacity){
            reallocate();
        }
        for(int i=size ; i<index ; i--){
            theData[i] = theData[i-1];
        }
        theData[index] = anEntry;
        size++;
    }

    /**
     * gets the data from given index
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * finds the index of given item
     * @param item
     * @return
     */
    public int indexOf(E item){
        for(int i=0 ; i < size ; i++){
            if(theData[i] == item){
                return i;
            }
        }
        return -1;
    }

    /**
     * set the given index with a given element
     * @param index
     * @param anEntry
     * @return
     */
    public E set(int index, E anEntry){
        if(index < 0 || index > 0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = anEntry;
        return oldValue;
    }

    /**
     * removes from given index and shift left all the elements from given index
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E value = theData[index];
        for(int i=index+1 ; i<size ; i++){
            theData[i-1] = theData[i];
        }
        size--;
        return value;
    }

    /**
     * if size equals capacity, doubles to capacity
     */
    private void reallocate(){
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }

    /**
     * size of arraylist
     * @return
     */
    public int getSize() {
        return size;
    }
	
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KWArrayList<?> that = (KWArrayList<?>) o;
        return size == that.size && capacity == that.capacity && Arrays.equals(theData, that.theData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(theData);
        return result;
    }
}
