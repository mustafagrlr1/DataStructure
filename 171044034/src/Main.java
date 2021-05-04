import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("PART1 TEST CASES OF HOMEWORK4 PART1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserting element for two different Heap:");
        Heap<Integer> k = new Heap<>();
        Heap<Integer> j = new Heap<>();
        int[] array = new int[3000];
        int random;

        //Adding elemet for two different heap
        for(int i=0 ; i<10 ; i++){
            random = Heap.generateRandomIntIntRange();
            j.insert(random);
            array[i] = random;
        }
        for(int i=0 ; i<10 ; i++){
            k.insert(Heap.generateRandomIntIntRange());
        }
        //shows heap for 10 element
        System.out.print("For j:");
        j.print();
        System.out.println();
        System.out.print("For k:");
        k.print();
        System.out.println();
        System.out.println();
        System.out.print("Merging j and k Heap:");
        j.mergeHeap(k);// merging two heap
        j.print();
        System.out.println();
        System.out.println("Search Number");
        System.out.println("number to search:" + array[2]);
        if(j.search(array[2])){
            System.out.println("number has been found");
        }else{
            System.out.println("number has not been found");
        }
        if(j.search(6000)){
            System.out.println("number has been found");
        }else{
            System.out.println("number has not been found");
        }
        System.out.println();
        System.out.println("Removed 3 greatest item in the heap:" + j.remove(3));

        Heap.ArrayIterator iter = j.iterator();
        System.out.println();
        System.out.println("Iterator in the Heap");
        System.out.println("First item in the heap(iterator next method):" + iter.next());
        System.out.println("Second item in the heap(iterator next method):" + iter.next());
        j.print();
        System.out.println();
        System.out.println("iterator set last value in the heap:" + iter.setValue(2700));
        j.print();
        System.out.println();
        System.out.println("Removed 3 greatest item in the heap:" + j.remove(3));
        j.print();
        System.out.println();
        System.out.println();

        // adding strings to heap
        Heap<String> l = new Heap<>();
        System.out.print("Strings in the heap:");
        l.insert("mustafa");
        l.insert("konya");
        l.insert("ronaldo");
        l.insert("bursa");
        l.insert("zonguldak");
        l.insert("hayda");
        l.insert("hatay");
        l.print();

        System.out.println();
        System.out.println();

        System.out.println("PART2 TEST CASES OF HOMEWORK4 PART2");


        BSTHeapTree<Integer> bst = new BSTHeapTree<>();
        int[] array2 = new int[3000];
        int random_number;
        for(int i=0 ; i<3000 ; i++){
            random_number = bst.generateRandomIntIntRange();
            bst.add(random_number);
            array[i] = random_number;
        }
        bst.sortNumber(array2);


        for(int i=0 ; i<100 ; i++){
            System.out.println("Number:" + array[i] + " Before remove:" +  (bst.remove(array[i])+1) + " After remove:" + bst.find(array[i]));
        }
        for(int i=0 ; i<10 ; i++){
            System.out.println((5000+i) + " " + bst.remove(5000+i) + " " + bst.find(5000+i));
            // after 5000 , numbers are not in the bst
        }


        for(int i=0 ; i<3000 ; i++){
            System.out.println(array[i] + " " + bst.find(array[i]));
        }

        for(int i=0 ; i<3000 ; i++){
            System.out.print(array[i] + " " + bst.find(array[i]) + " ");
            if(bst.find(array[i]) == bst.find_mode()){
                System.out.print("Biggest Occurence in bst is this number!!!");
            }
            System.out.println();
        }


        for(int i=0 ; i<100 ; i++){
            System.out.println(array[i] + " " + bst.find(array[i]));
        }
        for(int i=0 ; i<10 ; i++){
            System.out.println((5000+i) + " " + bst.find(5000+i));// after 5000 , numbers are not in the bst
        }



    }


}

