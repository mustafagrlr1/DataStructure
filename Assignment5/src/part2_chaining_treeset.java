import java.util.*;
import java.util.TreeSet;



/**
 * Chaining method of HashTable using TreeSet
 * Comparable class has been extended because K and V needs to be compared by the treeSet
 * @author mustafa Gurler
 * @param <K> type of key
 * @param <V> type of value
 */
public class part2_chaining_treeset<K extends Comparable<K>,V extends Comparable<V>> implements KWHashMap<K,V>{

    private TreeSet<HashNode<K,V>>[] buckets; // bucket of hashmap using treeSet
    private int bucketSize = 11; // initial capacity of buckets, prime number decrements collisions.
    private int size; // size of added hashnode to the buckets
    private int collisions = 0; // calculates how many collisions happen in the hashMap
    private double loadFactor = 0.75; // when this equality occures rehash method recreate the buckets with double size
                                        // loadFactor = size/bucketSize


    /**
     * Entry class of treeset
     * @param <K> type of key
     * @param <V> type of value
     */
    public class HashNode<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<HashNode<K,V>>{
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
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        /**
         * compares two object key
         * @param o other object that needs to be compared
         * @return if they are equal, it is true
         */
        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object o) {
            HashNode<K,V> object = (HashNode<K, V>) o;
            if(key.compareTo(object.getKey()) == 0) {
                return true;
            }
            return false;
        }

        /**
         * hashcode of node
         * @return int hashcode of key and value
         */
        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }


        /**
         * compares key with o's key
         * @param o other node
         * @return 1,0 or -1 depends on keys
         */
        @Override
        public int compareTo(HashNode<K, V> o) {
            HashNode<K,V> object = (HashNode<K, V>) o;
            return key.compareTo(object.getKey());
        }
    }

    /**
     * constructor of chaining_treeset
     */
    public part2_chaining_treeset(){
        size = 0;
        buckets = new TreeSet[11]; // initial capacity is 11 , prime number
    }


    /**
     * gets the value from given key inside of treeSet
     * hash method gives the index of bucket treeSet
     * If head is not null, searches the TreeSet with iterator
     * @param key address of value
     * @return value of node from given key
     */
    @Override
    public V get(K key) {
        if(key == null){
            throw new NullPointerException("key is null");
        }
        int bucketIndex = hash(key);
        TreeSet<HashNode<K,V>> head = buckets[bucketIndex];
        if(head == null){
            return null;
        }else{
            Iterator<HashNode<K,V>> it = head.iterator();
            HashNode<K,V> temp;
            while(it.hasNext()){    // iterates all the treeset
                temp = it.next();
                if(temp.getKey().equals(key)){ // if keys are equal, means given key is in the buckets
                    return temp.getValue();
                }
            }
            return null;
        }

    }

    /**
     * if buckets are empty
     * @return true if buckets are empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
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
        TreeSet<HashNode<K,V>>[] oldBucket = this.buckets;
        this.buckets = new TreeSet[this.bucketSize];

        // Moves all the element to new double capacity bucket treesets.
        for(int i=0 ; i < oldBucket.length ; i++){
            TreeSet<HashNode<K,V>> temp = oldBucket[i];
            if(temp!= null) {
                Iterator<HashNode<K, V>> it = temp.iterator();
                Iterator<HashNode<K, V>> prev = it;
                while (it.hasNext()) {
                    HashNode<K, V> node = it.next();
                    this.put(node.getKey(), node.getValue());
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
    @Override
    public V put(K key, V value) {
        if(key == null || value == null){
            throw new NullPointerException("Key or value is null!!");
        }
        int bucketIndex = hash(key);
        TreeSet<HashNode<K,V>> head = buckets[bucketIndex];
        if(head != null){
            Iterator<HashNode<K,V>> it = head.iterator();
            HashNode<K,V> temp;
            while(it.hasNext()){
                temp = it.next();
                if(temp.equals(new HashNode<>(key, value))){
                    V oldValue = temp.setValue(value);
                    return oldValue;
                }
            }
            collisions+=1;
            size++;
            head.add(new HashNode<>(key,value));
        }else{
            TreeSet<HashNode<K,V>> newNode = new TreeSet<>();
            buckets[bucketIndex] = newNode;
            head = buckets[bucketIndex];
            HashNode<K,V> node = new HashNode<>(key,value);
            head.add(node);
            size++;
            if (this.size > (this.loadFactor * this.bucketSize)) {
                rehash();
            }
        }
        return null;

    }

    /**
     * removes the value from given key
     * @param key address of bucket and treeset
     * @return the removed value
     */
    public V remove(K key){
        if(key == null){
            throw new NullPointerException("key is null!!");
        }
        int bucketIndex = hash(key);
        TreeSet<HashNode<K,V>> head = buckets[bucketIndex];
        if(head == null){
            return null;
        }else{
            Iterator<HashNode<K,V>> it = head.iterator();
            HashNode<K,V> temp;
            for(int i=0 ; i<head.size() ; i++){
                temp = it.next();
                if(temp.getKey().equals(key)){
                    V oldValue = temp.value;
                    size--;
                    head.remove(new HashNode<>(temp.key,temp.value));
                    return oldValue;
                }
            }
        }
        return null;
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
