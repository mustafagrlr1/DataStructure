import java.util.Arrays;

/**
 * HashTable using Coalesced hashing technique
 * @param <K> key of node(address of value)
 * @param <V> value of node
 */
public class part2_open_adressing<K,V> implements KWHashMap<K,V> {

    private HashNode<K,V>[] buckets;// buckets the nodes are going to be inserted
    private int size; // size of inserted elements
    private int bucketSize = 10; // size of buckets
    private int collisions; // all the collisions
    private final double loadFactor = 0.75;
    private int lastkeyIndex;
    private boolean[] dumbValue;


    /**
     * Every node represent a key-value in the buckets
     * @param <K> key of node(address of value
     * @param <V> value of node
     */
    public class HashNode<K,V>{

        V value;
        K key;
        int next;

        /**
         * Constructor of HashNode, it needs to be created with one key
         * one value, otherwise it is useless.
         * @param key key to be inserted
         * @param value value to be inserted
         */
        public HashNode(K key, V value){
            this.value = value;
            this.key = key;
            this.next = -1;
        }

        /**
         * returns the value of node
         * @return
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
         * returns the key of node
         * @return key of node
         */
        public K getKey() { return key; }

        /**
         * it need to be returned, it makes program more easy
         * @return
         */
        public int getNext() { return next; }

        /**
         * sets the next null or new value, remove method can run fine.
         * @param next
         */
        public void setNext(int next) { this.next = next; }
    }

    public part2_open_adressing(){
        size = 0;
        buckets = new HashNode[bucketSize];
        dumbValue = new boolean[bucketSize];
        Arrays.fill(dumbValue, false);
    }
    /**
     * finds the index from hashcode
     * @param key
     * @return
     */
    public int getBucketIndex(K key){
        int result = key.hashCode() % this.bucketSize;
        if(result < 0){
            result = result + this.bucketSize;
        }
        return result;
    }

    @Override
    public V get(K key) {
        if(key == null){
            throw new NullPointerException("key is null");
        }
        int bucketIndex = findEmptyIndex(key);
        if(buckets[bucketIndex] == null || !dumbValue[bucketIndex]){
            return buckets[bucketIndex].getValue();
        }else{
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == bucketSize;
    }

    public void rehash(){
        this.collisions = 0;
        this.size = 0;
        this.bucketSize = this.bucketSize*2;
        HashNode<K,V>[] oldBucket = this.buckets;
        this.buckets = new HashNode[this.bucketSize];
        this.dumbValue = new boolean[this.bucketSize];
        Arrays.fill(dumbValue, false);
        for(int i=0 ; i<oldBucket.length ; i++){
            if(oldBucket[i] != null){
                this.put(oldBucket[i].getKey(), oldBucket[i].getValue());
            }
        }
    }

    public int findEmptyIndex(K key){
        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> head = buckets[bucketIndex];
        int firstIndex = bucketIndex;
        if(head == null || head.key.equals(key)){
            lastkeyIndex = -1;
            return bucketIndex;
        }else{
            for(int i=1 ; i < this.bucketSize ; i++){
                if(buckets[bucketIndex] != null && firstIndex == getBucketIndex(buckets[bucketIndex].key)){
                    lastkeyIndex = bucketIndex;
                }
                bucketIndex = (firstIndex+(i*i))%this.bucketSize;
                head = buckets[bucketIndex];
                if(head == null || head.key.equals(key) || dumbValue[bucketIndex] == true){
                    return bucketIndex;
                }

            }
        }
        rehash();
        return findEmptyIndex(key);
    }

    @Override
    public V put(K key, V value) {
        if(key == null || value == null){
            throw new NullPointerException("key or value is null");
        }
        int firstKey = getBucketIndex(key);
        int bucketIndex = findEmptyIndex(key);
        HashNode<K,V> head = buckets[bucketIndex];
        if(firstKey == bucketIndex){
            size++;
            HashNode<K,V>  node = new HashNode<>(key, value);
            buckets[bucketIndex] = node;
            dumbValue[bucketIndex] = false;
            if((this.size > (this.loadFactor * this.bucketSize))){
                rehash();
            }
            return null;
        }else{
            size++;
            collisions++;
            if(head != null && dumbValue[bucketIndex] == false){
                V oldValue = head.setValue(value);
                dumbValue[bucketIndex] = false;
                if(lastkeyIndex == -1){
                    lastkeyIndex = bucketIndex;
                    buckets[lastkeyIndex].setNext(-1);
                }else{
                    buckets[lastkeyIndex].setNext(bucketIndex);
                }
                if((this.size > (this.loadFactor * this.bucketSize))){
                    rehash();
                }
                return oldValue;
            }else{
                HashNode<K,V>  node = new HashNode<>(key, value);
                buckets[bucketIndex] = node;
                dumbValue[bucketIndex] = false;
                if(lastkeyIndex == -1){
                    lastkeyIndex = bucketIndex;
                    buckets[lastkeyIndex].setNext(-1);
                }else{
                    buckets[lastkeyIndex].setNext(bucketIndex);
                }

                if((this.size > (this.loadFactor * this.bucketSize))){
                    rehash();
                }
                return null;
            }
        }
    }

    public V remove(K key){
        if(key == null){
            throw new NullPointerException("key is null");
        }
        int firstIndex = getBucketIndex(key);
        int bucketIndex = findEmptyIndex(key);
        int nextIndex;
        if(buckets[firstIndex] == null){
            return null;
        }else{
            if(buckets[bucketIndex] == null){
                return null;
            }else{
                V oldValue = buckets[bucketIndex].getValue();
                while(buckets[bucketIndex] != null || dumbValue[bucketIndex] != false){
                    if(buckets[bucketIndex].getNext() == -1){
                        break;
                    }
                    nextIndex = buckets[bucketIndex].getNext();
                    buckets[bucketIndex] = buckets[nextIndex];
                    bucketIndex = nextIndex;
                }
                dumbValue[bucketIndex] = true;
                size--;
                return oldValue;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBucketSize() {
        return bucketSize;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }
}
