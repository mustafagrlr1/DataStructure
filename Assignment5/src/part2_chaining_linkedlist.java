
import java.util.LinkedList;

/**
 * Chaining method of HashTable using linkedlist
 * @author mustafa Gurler
 * @param <K> key of hashmap
 * @param <V> value of hashmap
 */
public class part2_chaining_linkedlist<K,V> implements KWHashMap<K,V>{


    private LinkedList<HashNode<K,V>>[] buckets;  //array of hashmap
    private int bucketSize = 10; // size of hashmap // it should be 11 but test methods are more easiy with 10 size
    private int size; // size of inserted element
    private double loadFactor = 0.75; // when this equality occures rehash method recreate the buckets with double size
                                     // loadFactor = size/bucketSize
    private int collisions = 0; // calculates collision in the buckets

    /**
     * Entry class of linkedlist
     * @param <K> type of key
     * @param <V> type of value
     */
    public class HashNode<K,V>{
        private K key;
        private V value;

        /**
         * constructor of the HashNode
         * @param key value adress
         * @param value the data
         */
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        /**
         * returns the key of node
         * @return key of node
         */
        public K getKey() { return key; }

        /**
         * returns the value of node
         * @return value of node
         */
        public V getValue() { return value; }

        /**
         * sets the old value to new value
         * @param value new value
         * @return the old value of the node
         */
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
    /**
     * constructor of chaining_linkedlist
     */
    public part2_chaining_linkedlist(){
        size = 0;
        buckets = new LinkedList[10];
    }

    /**
     * gets the value from given key inside of linkedlist
     * hash method gives the index of bucket linkedList
     * If head is not null, searches the linkedlist with equals method
     * @param key address of value
     * @return value of node from given key
     */
    @Override
    public V get(K key) {
        if(key == null){
            throw new IllegalArgumentException("Key is null!!");
        }
        int bucketIndex = hash(key);
        LinkedList<HashNode<K,V>> head = buckets[bucketIndex];
        if(head != null) {
            for(int i=0 ; i<head.size() ; i++){
                if(head.get(i).key.equals(key)){
                    return head.get(i).getValue();
                }
            }

        }
        return null;
    }



    /**
     * if buckets are empty
     * @return true if buckets are empty
     */
    @Override
    public boolean isEmpty() {
        return bucketSize == 0;
    }

    /**
     * hash method gives a specific index for the buckets fixed array
     * @param key address of value
     * @return hashCode of the key
     */
    public int hash(K key){
        int result = key.hashCode()%this.bucketSize;
        if(result < 0){
            result += this.bucketSize;
        }
        return result;
    }

    /**
     * rehash gives guarantee about get and put method that they
     * are going to run always O(1) time complexity.
     */
    public void rehash(){
        this.collisions = 0;
        this.size = 0;
        this.bucketSize = this.bucketSize*2;
        LinkedList<HashNode<K,V>>[] oldBucket = this.buckets;
        this.buckets = new LinkedList[this.bucketSize];
        for(int i=0 ; i < oldBucket.length ; i++){
            LinkedList<HashNode<K,V>> temp = oldBucket[i];
            if(temp != null) {
                for (int j = 0; j < temp.size(); j++) {
                    this.put(temp.get(j).key,temp.get(j).value);
                }
            }
        }
    }

    /**
     * puts value inside the bucket treeset with given specific key
     * @param key address of bucket
     * @param value the data needs to be inserted
     * @return the old value if there is exist
     */
    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        if(key == null || value == null){
            throw new IllegalArgumentException("Key , value is null!!");
        }
        int bucketIndex = hash(key);
        LinkedList<HashNode<K, V>> head = buckets[bucketIndex];

        if(head != null) {

            for(int i=0 ; i<head.size() ; i++){
                if (head.get(i).key.equals(key)) {
                    V oldValue = head.get(i).getValue();
                    head.get(i).setValue(value);
                    return null;
                }
            }
            collisions += 1;
            head.addFirst(new HashNode<>(key, value));
            size++;
            if (this.size > (this.loadFactor * this.bucketSize)) {
                rehash();
            }
            return null;
        }
        else {

            LinkedList<HashNode<K, V>> newNode = new LinkedList<>();
            buckets[bucketIndex] = newNode;
            head = buckets[bucketIndex];
            HashNode<K, V> node = new HashNode<>(key, value);
            head.addFirst(node);
            size++;
            if (this.size > (this.loadFactor * this.bucketSize)) {
                rehash();
            }
            return null;
        }
    }

    /**
     * removes the value from given key
     * @param key address of bucket and treeset
     * @return the removed value
     */
    public V remove(K key){
        if(key == null){
            throw new NullPointerException("Key is null");
        }
        int bucketIndex = hash(key);
        LinkedList<HashNode<K,V>> head = buckets[bucketIndex];
        if(head == null){
            return null;
        }else{
            for(int i=0 ; i<head.size() ; i++){
                if(head.get(i).key.equals(key)){
                    V oldValue = head.get(i).value;
                    head.remove(i);
                    size--;
                    collisions--;
                    return oldValue;
                }
            }
            return null;
        }
    }

    /**
     * gets the collisions in the element
     * to show collision number of hashmap
     * @return
     */
    public int getCollisions() {
        return collisions;
    }
    /**
     * inserted element size in the hashmap
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * bucket size of hashmap
     * @return
     */
    public int getBucketSize() {
        return bucketSize;
    }
}
