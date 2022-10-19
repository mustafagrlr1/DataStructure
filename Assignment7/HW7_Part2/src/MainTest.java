

import java.util.Random;

public class MainTest {

    /**
     * @return gives random number
     */
    public static int generateRandomIntIntRange() {
        Random r = new Random();
        return r.nextInt((5000) + 1);
    }

    public static class BSTAVLCheck{

        /**
         * checks if the binary search tree is balanced
         * @param root
         * @return
         */
        public static boolean isBalanced(BinaryTree.Node root){

            int leftHeight;
            int rightHeight;

            if(root == null){
                return true;
            }

            if(Math.abs(height(root.left) - height(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right)){
                return true;
            }
            return false;
        }

        /**
         * gives the height of current node
         * @param root
         * @return
         */
        private static int height(BinaryTree.Node root){
            if(root == null){
                return 0;
            }
            return 1 + Math.max(height(root.left), height(root.right));
        }

    }

    public static void main(String[] args){
        BinarySearchTree<Integer> test = new BinarySearchTree<>();

        for(int i=0 ; i<100 ; i++){
            test.add(generateRandomIntIntRange());
        }

        int max = 75;
        int min = 25;
        int minus = 1;
        int maximus = 1;
        BinarySearchTree<Integer> test1 = new BinarySearchTree<>();
        test1.add(50);
        test1.add(min);
        test1.add(max);
        for(int i=0 ; i<25 ; i++){
                test1.add(min-minus);
                test1.add(max-minus);
                minus++;
                test1.add(min+maximus);
                test1.add(max+maximus);
                maximus++;
        }

        BinarySearchTree<Integer> t2 = new BinarySearchTree<>();
        t2.add(15);
        t2.add(5);
        t2.add(20);
        t2.add(18);
        t2.add(23);
        t2.add(4);
        t2.add(6);



        if(BSTAVLCheck.isBalanced(test.root)){
            System.out.println("It is an AVL tree");
        }else{
            System.out.println("It is not an AVL tree");
        }
        if(BSTAVLCheck.isBalanced(test1.root)){
            System.out.println("It is an AVL tree");
        }else{
            System.out.println("It is not an AVL tree");
        }
        if(BSTAVLCheck.isBalanced(t2.root)){
            System.out.println("It is an AVL tree");
        }else{
            System.out.println("It is not an AVL tree");
        }





    }



}
