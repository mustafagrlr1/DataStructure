
public interface SearchTree<E> {
    /**
     * Inserts item where it belongs in the tree.
     * Return true if the item is inserted;
     * false if it is not (already in tree):
     * @param item The object being inserted
     * @return true if the object is inserted, false
     * 			if the object already exists in the tree
     */
    boolean add(E item);
    /**
     * Returns true if target is found in the tree.
     * @param target The object being sought
     * @return true if the object exists in the tree,
     * 			false if the object does not exist
     */
    boolean contains(E target);
    /**
     * Returns a reference to the data in the node
     * that is equal to target. If no such node
     * is found, returns null.
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    E find(E target);
    /**
     * Removes target (if found) from tree and returns it;
     * otherwise, returns null.
     * @param target The object to be deleted
     * @return The object deleted from the tree
     * 			or null if the object was not in the tree
     */
    E delete(E target);
    /**
     * Removes target (if found) from tree and returns true;
     * otherwise, returns false.
     * @param target The object to be removed
     * @return true if the object is removed,
     * 			false if the object is not removed
     */
    boolean remove(E target);
}