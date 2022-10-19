import java.util.Random;

public class MainTest {
    /**
     * @return gives random number
     */
    public static int generateRandomIntIntRange() {
        Random r = new Random();
        return r.nextInt((5000) + 1);
    }

    public static void main(String[] args){

        long start;
        long finish;

        //Binary Search Tree 10000
        BinarySearchTree<Integer>[] binarySearchTree1 = new BinarySearchTree[10];

        //Binary Search Tree 20000
        BinarySearchTree<Integer>[] binarySearchTree2 = new BinarySearchTree[10];

        //Binary Search Tree 40000
        BinarySearchTree<Integer>[] binarySearchTree4 = new BinarySearchTree[10];

        //Binary Search Tree 80000
        BinarySearchTree<Integer>[] binarySearchTree8 = new BinarySearchTree[10];

        //Red Black Tree 10000
        RedBlackTree<Integer>[] redBlackTree1 = new RedBlackTree[10];

        //Red Black Tree 20000
        RedBlackTree<Integer>[] redBlackTree2 = new RedBlackTree[10];

        //Red Black Tree 40000
        RedBlackTree<Integer>[] redBlackTree4 = new RedBlackTree[10];

        //Red Black Tree 80000
        RedBlackTree<Integer>[] redBlackTree8 = new RedBlackTree[10];

        //2-3 Tree 10000
        TwoThreeTree<Integer>[] twoThreeTree1 = new TwoThreeTree[10];

        //2-3 Tree 20000
        TwoThreeTree<Integer>[] twoThreeTree2 = new TwoThreeTree[10];

        //2-3 Tree 40000
        TwoThreeTree<Integer>[] twoThreeTree4 = new TwoThreeTree[10];

        //2-3 Tree 80000
        TwoThreeTree<Integer>[] twoThreeTree8 = new TwoThreeTree[10];

        //Binary Tree 10000
        BTree<Integer>[] binaryTree1 = new BTree[10];

        //Binary Tree 20000
        BTree<Integer>[] binaryTree2 = new BTree[10];
        //Binary Tree 40000
        BTree<Integer>[] binaryTree4 = new BTree[10];
        //Binary Tree 80000
        BTree<Integer>[] binaryTree8 = new BTree[10];

        //Skip List 10000
        SkipList<Integer>[] skipList1 = new SkipList[10];

        //Skip List 20000
        SkipList<Integer>[] skipList2 = new SkipList[10];
        //Skip List 20000
        SkipList<Integer>[] skipList4 = new SkipList[10];
        //Skip List 20000
        SkipList<Integer>[] skipList8 = new SkipList[10];

        for(int i=0 ; i<10 ; i++){
            binarySearchTree1[i] = new BinarySearchTree<>();
            binarySearchTree2[i] = new BinarySearchTree<>();
            binarySearchTree4[i] = new BinarySearchTree<>();
            binarySearchTree8[i] = new BinarySearchTree<>();

            redBlackTree1[i] = new RedBlackTree<>();
            redBlackTree2[i] = new RedBlackTree<>();
            redBlackTree4[i] = new RedBlackTree<>();
            redBlackTree8[i] = new RedBlackTree<>();

            twoThreeTree1[i] = new TwoThreeTree<>();
            twoThreeTree2[i] = new TwoThreeTree<>();
            twoThreeTree4[i] = new TwoThreeTree<>();
            twoThreeTree8[i] = new TwoThreeTree<>();

            binaryTree1[i] = new BTree<>(4);
            binaryTree2[i] = new BTree<>(4);
            binaryTree4[i] = new BTree<>(4);
            binaryTree8[i] = new BTree<>(4);

            skipList1[i] = new SkipList<>();
            skipList2[i] = new SkipList<>();
            skipList4[i] = new SkipList<>();
            skipList8[i] = new SkipList<>();

        }

        int sizeOneThousand = 10000;
        int sizeTwoThousand = 20000;
        int sizefourThousand = 40000;
        int sizeEightThousand = 80000;

        int x;

        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j < sizeOneThousand ; j++){
                x = generateRandomIntIntRange();
                binarySearchTree1[i].add(x);
                redBlackTree1[i].add(x);
                twoThreeTree1[i].add(x);
                binaryTree1[i].add(x);
                skipList1[i].add(x);
            }
        }
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j < sizeTwoThousand ; j++){
                x = generateRandomIntIntRange();
                binarySearchTree2[i].add(x);
                redBlackTree2[i].add(x);
                twoThreeTree2[i].add(x);
                binaryTree2[i].add(x);
                skipList2[i].add(x);
            }
        }
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j < sizefourThousand ; j++){
                x = generateRandomIntIntRange();
                binarySearchTree4[i].add(x);
                redBlackTree4[i].add(x);
                twoThreeTree4[i].add(x);
                binaryTree4[i].add(x);
                skipList4[i].add(x);
            }
        }
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j < sizeEightThousand ; j++){
                x = generateRandomIntIntRange();
                binarySearchTree8[i].add(x);
                redBlackTree8[i].add(x);
                twoThreeTree8[i].add(x);
                binaryTree8[i].add(x);
                skipList8[i].add(x);
            }
        }

        int sumAndAverageTime = 0;
        //generate 100 random numbers
        int[] randomNumber = new int[100];
        for(int i=0 ; i<100 ; i++){
            randomNumber[i] = generateRandomIntIntRange();
        }
        //Adding 100 elements
        System.out.println("*********************************************");
        System.out.println("Adding 100 elements to 10000 added structures");
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                binarySearchTree1[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Binary Search Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                redBlackTree1[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Red Black Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                twoThreeTree1[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("TwoThree Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                binaryTree1[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Binary Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                skipList1[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Skip List => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;

        System.out.println("*********************************************");
        System.out.println("Adding 100 elements to 20000 added structures");
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                binarySearchTree2[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Binary Search Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                redBlackTree2[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Red Black Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                twoThreeTree2[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("TwoThree Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                binaryTree2[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Binary Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                skipList2[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Skip List => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;

        System.out.println("*********************************************");
        System.out.println("Adding 100 elements to 40000 added structures");
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                binarySearchTree4[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Binary Search Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                redBlackTree4[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Red Black Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                twoThreeTree4[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("TwoThree Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                binaryTree4[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Binary Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                skipList4[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Skip List => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;

        System.out.println("*********************************************");
        System.out.println("Adding 100 elements to 80000 added structures");
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                binarySearchTree8[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Binary Search Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                redBlackTree8[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Red Black Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                twoThreeTree8[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("TwoThree Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                binaryTree8[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Binary Tree => " + (sumAndAverageTime/10));
        sumAndAverageTime = 0;
        for(int i=0 ; i<10 ; i++){
            start = System.nanoTime();
            for(int j=0 ; j<100 ; j++){
                skipList8[i].add(randomNumber[j]);
            }
            finish = System.nanoTime();
            sumAndAverageTime += (finish-start);
        }
        System.out.println("Skip List => " + (sumAndAverageTime/10));

    }



}
