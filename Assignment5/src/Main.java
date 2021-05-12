import java.util.Map;
import java.util.Random;
import java.util.*;

public class Main {

    /**
     * @return gives random number
     */
    public static int generateRandomIntIntRange() {
        Random r = new Random();
        return r.nextInt((5000) + 1);
    }

    public static void main(String[] args){









        long start;
        long end;
        System.out.println("***********************Part1-Iterator****************************************");
        System.out.println("*****************************************************************************");
        MapIterator<Integer, Integer> testIt = new MapIterator<>();
        int[] iteratorArray = new int[10000];
        int[] iteratorArray1 = new int[10000];
        for(int i=0 ; i<1000 ; i++){
            iteratorArray[i] = i;
        }
        for(int i=0 ; i<1000 ; i++){
            iteratorArray1[i] = generateRandomIntIntRange();
        }
        try{
            for(int i=0 ; i<1000 ; i++){
                testIt.put(iteratorArray[i],iteratorArray1[i]);
            }
        }catch(Exception e){
            System.out.println("An error occured");
        }

        MapIterator.MapIteratorClass it = testIt.MapIterator();
        MapIterator.MapIteratorClass prevIt = testIt.MapIterator(iteratorArray[999]);
        try {
            start = System.nanoTime();
            for(int i = 0; i < 999; i++) {
                if ((Integer)it.next() != iteratorArray[i]) {
                    System.out.println(i);
                    throw new Exception();
                }
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for next() method:" + (end-start) + " nanosn");
            start = System.nanoTime();
            for(int i = 998 ; i < 0 ; i--){
                if ((Integer)it.prev() != iteratorArray[i]) {
                    System.out.println("mustafa");
                    throw new Exception();
                }
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for prev() method:" + (end-start) + " nanosn");
            System.out.println("Iterator next, prev and hasNext method passed.");
        }catch(Exception e){
            System.out.println("An error occured");
        }

        System.out.println("***********************Part2-ChainingLinkedList******************************");
        System.out.println("*****************************************************************************");
        System.out.println("Put Method");
        part2_chaining_linkedlist<Integer, Integer> list1000 = new part2_chaining_linkedlist<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<1000 ; i++){
                list1000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");
            System.out.println("Part2 chaining linkedlist class put method passed.(1000 value added)");
            System.out.println("Added new element:" + list1000.getSize() + " Bucket Size:" + list1000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        part2_chaining_linkedlist<Integer, Integer> list3000 = new part2_chaining_linkedlist<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<3000 ; i++){
                list3000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");
            System.out.println("Part2 chaining linkedlist class put method passed.(3000 value added)");
            System.out.println("Added new element:" + list3000.getSize() + " Bucket Size:" + list3000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        part2_chaining_linkedlist<Integer, Integer> list10000 = new part2_chaining_linkedlist<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<10000 ; i++){
                list10000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");
            System.out.println("Part2 chaining linkedlist class put method passed.(10000 value added)");
            System.out.println("Added new element:" + list10000.getSize() + " Bucket Size:" + list10000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        System.out.println("GET METHOD");
        int[] listArray = new int[10000];
        int[] listArray1 = new int[10000];
        for(int i=0 ; i<1000 ; i++){
            listArray[i] = i;
        }
        for(int i=0 ; i<1000 ; i++){
            listArray1[i] = generateRandomIntIntRange();
        }
        part2_chaining_linkedlist<Integer, Integer> listGet1000 = new part2_chaining_linkedlist<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<1000 ; i++){
                listGet1000.put(listArray[i],listArray1[i]);
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for get() method:" + (end-start) + " nanosn");
        }catch(Exception e){
            System.out.println("An error occured");
        }
        try {
            for (int i = 0; i < 1000; i++) {
                if (listGet1000.get(listArray[i]) != listArray1[i]) {
                    throw new Exception();
                }
            }

            System.out.println("Part2 chaining linkedlist class get method passed.(10000 value tries to find)");
            System.out.println("Added new element:" + listGet1000.getSize() + " Bucket Size:" + listGet1000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        System.out.println("REMOVE METHOD");
        int[] listArray2 = new int[10000];
        int[] listArray3 = new int[10000];
        for(int i=0 ; i<1000 ; i++){
            listArray2[i] = i;
        }
        for(int i=0 ; i<1000 ; i++){
            listArray3[i] = generateRandomIntIntRange();
        }
        part2_chaining_linkedlist<Integer, Integer> listRemove1000 = new part2_chaining_linkedlist<>();
        try{
            for(int i=0 ; i<1000 ; i++){
                listRemove1000.put(listArray2[i],listArray3[i]);
            }}catch(Exception e){
            System.out.println("An error occured");
        }
        try {
            start = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                if (listRemove1000.remove(listArray2[i]) != listArray3[i]) {
                    throw new Exception();
                }
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for remove() method:" + (end-start) + " nanosn");

            System.out.println("Part2 chaining treeset class remove method passed.(1000 value tries to remove)");
            System.out.println("Removed all the elements");
            System.out.println("Added new element:" + listRemove1000.getSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }


        System.out.println("***********************Part2-ChainingTreeSet*********************************");
        System.out.println("*****************************************************************************");
        System.out.println("Put Method");
        part2_chaining_treeset<Integer, Integer> treeset1000 = new part2_chaining_treeset<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<1000 ; i++){
                treeset1000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");

            System.out.println("Part2 chaining treeset class put method passed.(1000 value added)");
            System.out.println("Added new element:" + treeset1000.getSize() + " Bucket Size:" + treeset1000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        part2_chaining_treeset<Integer, Integer> treeset3000 = new part2_chaining_treeset<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<3000 ; i++){
                treeset3000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");
            System.out.println("Part2 chaining treeset class put method passed.(3000 value added)");
            System.out.println("Added new element:" + treeset3000.getSize() + " Bucket Size:" + treeset3000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        part2_chaining_treeset<Integer, Integer> treeset10000 = new part2_chaining_treeset<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<10000 ; i++){
                treeset10000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");
            System.out.println("Part2 chaining treeset class put method passed.(10000 value added)");
            System.out.println("Added new element:" + treeset10000.getSize() + " Bucket Size:" + treeset10000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        System.out.println("GET METHOD");
        int[] treesetArray = new int[10000];
        int[] treesetArray1 = new int[10000];
        for(int i=0 ; i<1000 ; i++){
            treesetArray[i] = i;
        }
        for(int i=0 ; i<1000 ; i++){
            treesetArray1[i] = generateRandomIntIntRange();
        }
        part2_chaining_treeset<Integer, Integer> treesetGet1000 = new part2_chaining_treeset<>();
        try{
            for(int i=0 ; i<1000 ; i++){
                treesetGet1000.put(treesetArray[i],treesetArray1[i]);
            }
        }catch(Exception e){
            System.out.println("An error occured");
        }
        try {
            start = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                if (treesetGet1000.get(treesetArray[i]) != treesetArray1[i]) {
                    throw new Exception();
                }
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for get() method:" + (end-start) + " nanosn");
            System.out.println("Part2 chaining treeset class get method passed.(10000 value tries to find)");
            System.out.println("Added new element:" + treesetGet1000.getSize() + " Bucket Size:" + treesetGet1000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        System.out.println("REMOVE METHOD");
        int[] treesetArray2 = new int[10000];
        int[] treesetArray3 = new int[10000];
        for(int i=0 ; i<1000 ; i++){
            treesetArray2[i] = i;
        }
        for(int i=0 ; i<1000 ; i++){
            treesetArray3[i] = generateRandomIntIntRange();
        }
        part2_chaining_treeset<Integer, Integer> treesetRemove1000 = new part2_chaining_treeset<>();
        try{
            for(int i=0 ; i<1000 ; i++){
                treesetRemove1000.put(treesetArray2[i],treesetArray3[i]);
            }
        }catch(Exception e){
            System.out.println("An error occured");
        }
        try {
            start = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                if (treesetRemove1000.remove(treesetArray2[i]) != treesetArray3[i]) {
                    throw new Exception();
                }
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for remove() method:" + (end-start) + " nanosn");

            System.out.println("Part2 chaining treeset class remove method passed.(1000 value tries to remove)");
            System.out.println("Removed all the elements");
            System.out.println("Added new element:" + treesetRemove1000.getSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }

        System.out.println("***********************Part2-OpenAdressing***********************************");
        System.out.println("*****************************************************************************");
        System.out.println("Put Method");
        part2_open_adressing<Integer, Integer> open1000 = new part2_open_adressing<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<1000 ; i++){
                open1000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");
            System.out.println("Part2 open addressing class put method passed.(1000 value added)");
            System.out.println("Added new element:" + open1000.getSize() + " Bucket Size:" + open1000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        part2_open_adressing<Integer, Integer> open3000 = new part2_open_adressing<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<3000 ; i++){
                open3000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");
            System.out.println("Part2 open addressing class put method passed.(3000 value added)");
            System.out.println("Added new element:" + open3000.getSize() + " Bucket Size:" + open3000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        part2_open_adressing<Integer, Integer> open10000 = new part2_open_adressing<>();
        try{
            start = System.nanoTime();
            for(int i=0 ; i<10000 ; i++){
                open10000.put(generateRandomIntIntRange(),generateRandomIntIntRange());
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for put() method:" + (end-start) + " nanosn");
            System.out.println("Part2 open addressing class put method passed.(10000 value added)");
            System.out.println("Added new element:" + open10000.getSize() + " Bucket Size:" + open10000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        System.out.println("GET METHOD");
        int[] array = new int[10000];
        int[] array1 = new int[10000];
        for(int i=0 ; i<1000 ; i++){
            array[i] = i;
        }
        for(int i=0 ; i<1000 ; i++){
            array1[i] = generateRandomIntIntRange();
        }
        part2_open_adressing<Integer, Integer> get1000 = new part2_open_adressing<>();
        try{
            for(int i=0 ; i<1000 ; i++){
                get1000.put(array[i],array1[i]);
            }
        }catch(Exception e){
            System.out.println("An error occured");
        }
        try {
            start = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                if (get1000.get(array[i]) != array1[i]) {
                    throw new Exception();
                }
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for get() method:" + (end-start) + " nanosn");
            System.out.println("Part2 open addressing class get method passed.(10000 value tries to find)");
            System.out.println("Added new element:" + get1000.getSize() + " Bucket Size:" + get1000.getBucketSize());
        }catch(Exception e){
            System.out.println("An error occured");
        }
        System.out.println("*****************************************************************************");
        System.out.println("REMOVE METHOD");
        int[] array2 = new int[10000];
        int[] array3 = new int[10000];
        for(int i=0 ; i<1000 ; i++){
            array2[i] = i;
        }
        for(int i=0 ; i<1000 ; i++){
            array3[i] = generateRandomIntIntRange();
        }
        part2_open_adressing<Integer, Integer> remove1000 = new part2_open_adressing<>();
        try{
            for(int i=0 ; i<1000 ; i++){
                remove1000.put(array2[i],array3[i]);
            }
        }catch(Exception e){
            System.out.println("An error occured");
        }
        try {
            start = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                if (remove1000.remove(array2[i]) != array3[i]) {
                    throw new Exception();
                }
            }
            end = System.nanoTime();
            System.out.println("Time has been passed for remove() method:" + (end-start) + " nanosn");
            System.out.println("Part2 open addressing class remove method passed.(10000 value tries to remove)");
            System.out.println("Removed all the elements");
            System.out.println("Added new element:" + remove1000.getSize());
        }catch(Exception e){
            System.out.println("An error occured");
       }
    }
}
