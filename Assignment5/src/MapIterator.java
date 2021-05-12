import java.util.*;


/**
 * HashMap class has been extended to use all the
 * methods, so value and key value can be added
 * @param <K> key of hashmap node ==> shows the address
 * @param <V> value of hashmap
 */
public class MapIterator<K, V> extends HashMap<K,V>{


    /**
     * Iterator class that points to hashmap
     * @param <K> key of hashmap node ==> shows the address
     * @param <V> value of hashmap
     */
    public class MapIteratorClass<K,V> implements Iterator<K> {

        Object[] keylist = MapIterator.this.keySet().toArray(); // keeps the all keys in the list
        int size = MapIterator.this.size(); // size of HashMap
        int index; // place of iterator

        /**
         * Constructor of Iterator
         * Starts with zero
         */
        public MapIteratorClass(){
            int index = 0;
        }

        /**
         * Constructor of Iterator
         * Starts with given parameter
         * @param key address of value
         */
        public MapIteratorClass(K key){
            for(int i=0 ; i<size ; i++){ // traverses the iterator until to find the key item in the list
                if(keylist[i].equals(key)){
                    index = i;
                    i = size;
                }
            }
        }

        /**
         * hasNext() method returns if the iterator index
         * is smaller than size of keylist
         * @return true if keylist index is smaller
         */
        @Override
        public boolean hasNext() {
            return keylist[index] != keylist[size-1];
        }

        /**
         * gives the current data and iterates the keylist one more
         * @return key of current keylist
         */
        @Override
        public K next() {
            if(hasNext()){
                return (K) keylist[index++];
            }
            index = 0;
            return (K) keylist[index++]; // if index reaches the size of keylist, turns back to beginning
        }

        /**
         * gives the previous data and iterates the keylist one back
         * @return key of previous index
         */
        public K prev(){
            if(index != 0){
                return (K) keylist[--index];
            }else if(index == 0){
                index = size-1;
                return (K) keylist[size-1]; // if index reaches the beginning of the keylist, turns back to end
            }
            return null;

        }
    }

    /**
     * gives the iterator class to the user
     * @return new iterator
     */
    public MapIteratorClass<K,V> MapIterator(){
        return new MapIteratorClass();
    }

    /**
     * gives the iterator class to the user with a starting index
     * @param key address of starting iterator
     * @return new iterator
     */
    public MapIteratorClass<K,V> MapIterator(K key){
        return new MapIteratorClass(key);
    }



}
