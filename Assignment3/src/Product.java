/**
 * Products of Company
 * @author Mustafa Gurler
 */


import java.awt.print.Book;
import java.util.Scanner;

public class Product implements OfficeProduct{

    OfficeChair chair;

    OfficeDesk desk;

    OfficeCabinets cabinet;

    MeetingTables table;

    BookCases cases;

    private int x;
    private int y;
    private int choice;
    private int count;

    private class OfficeChair{
        private HybridListClass<Integer>[] chair = new HybridListClass[oc_mc*oc_mn];

        /**
         * constructor of chair
         * allocates memory for all chairs
         */
        public OfficeChair(){
            for(int i=0 ; i<oc_mc*oc_mn ; i++){
                chair[i] = new HybridListClass<Integer>();
            }
        }

        /**
         *
         * @return model numbers and color numbers of product
         */
        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            str.append("There are " + oc_mn + " model.\n");
            str.append("There are " + oc_mc + " color.\n");
            return str.toString();
        }

        /**
         * @param x model number of chair
         * @param y color number of chair
         * @return specific chair information
         */
        public String toString(int x, int y){
            if(x > oc_mn && y > oc_mc){
                return "Wrong Index";
            }
            int index = (oc_mn*x)+y;
            StringBuilder str = new StringBuilder();
            str.append("Office Chair " + (x+1) + ".Model " + (y+1) + ".Color ==> ");
            for(int i=0 ; i<chair[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = chair[index].get(i);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    str.append(temp.get(j) + " ");
                }
            }
            return str.toString();
        }

        /**
         * sum of all the previous order
         * @param x model number of chair
         * @param y color number of chair
         * @return sum of all chair
         */
        public int sumOf(int x, int y){
            if(x > oc_mn && y > oc_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (oc_mn*x)+y;
            int sum=0;
            for(int i=0 ; i<chair[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = chair[index].get(i);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    sum += temp.get(j);
                }
            }
            return sum;
        }

        /**
         * adds the count of chair to product
         * @param x model number of chair
         * @param y color number of chair
         * @param count how many chair is going to be added
         * @return return true if adding operation is completed
         */
        public boolean add(int x, int y, int count){
            if(x > oc_mn && y > oc_mc){
                System.out.println("Wrong Index");
                return false;
            }
            int index = (oc_mn*x)+y;
            chair[index].add(count);
            return true;
        }

        /**
         * removes last chair of given chair model
         * @param x model number of chair
         * @param y color number of chair
         * @return last chair order
         */
        public int lastProduct(int x,int y){
            if(x > oc_mn && y > oc_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (oc_mn*x)+y;
            KWArrayList<Integer> last = chair[index].getLast();
            int result = last.get(last.getSize()-1);
            chair[index].remove();
            return result;
        }

        /**
         * gets last chair of given chair model
         * @param x model number of chair
         * @param y color number of chair
         * @return last chair order
         */
        public int lastGet(int x,int y){
            if(x > oc_mn && y > oc_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (oc_mn*x)+y;
            KWArrayList<Integer> last = chair[index].getLast();
            return last.get(last.getSize()-1);
        }
    }
    private class OfficeDesk{
        private HybridListClass<Integer>[] desk = new HybridListClass[od_mc*od_mn];
        /**
         * constructor of desk
         * allocates memory for all chairs
         */
        public OfficeDesk(){
            for(int i=0 ; i<od_mc*od_mn ; i++){
                desk[i] = new HybridListClass<Integer>();
            }
        }

        /**
         *
         * @return model numbers and color numbers of product
         */
        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            str.append("There are " + od_mn + " model.\n");
            str.append("There are " + od_mc + " color.\n");
            return str.toString();
        }
        /**
         * @param x model number of desk
         * @param y color number of desk
         * @return specific desk information
         */
        public String toString(int x, int y){
            if(x > od_mn && y > od_mn){
                return ("Wrong Index");
            }
            int index = (od_mn*x)+y;
            StringBuilder str = new StringBuilder();
            str.append("Office Desk " + (x+1) + ".Model " + (y+1) + ".Color ==> ");
            for(int i=0 ; i<desk[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = desk[index].get(index);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    str.append(temp.get(j) + " ");
                }
            }
            return str.toString();
        }
        /**
         * sum of all the previous order
         * @param x model number of desk
         * @param y color number of desk
         * @return sum of all desk
         */
        public int sumOf(int x, int y){
            if(x > od_mn && y > od_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (od_mn*x)+y;
            int sum=0;
            for(int i=0 ; i<desk[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = desk[index].get(index);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    sum += temp.get(j);
                }
            }
            return sum;
        }
        /**
         * adds the count of desk to product
         * @param x model number of desk
         * @param y color number of desk
         * @param count how many desk is going to be added
         * @return return true if adding operation is completed
         */
        public boolean add(int x, int y, int count){
            if(x > od_mn && y > od_mc){
                System.out.println("Wrong Index");
                return false;
            }
            int index = (od_mn*x)+y;
            desk[index].add(count);
            return true;
        }
        /**
         * removes last desk of given chair model
         * @param x model number of desk
         * @param y color number of desk
         * @return last desk order
         */
        public int lastProduct(int x, int y){
            if(x > od_mn && y > od_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (od_mn*x)+y;
            KWArrayList<Integer> last = desk[index].getLast();
            int result = last.get(last.getSize()-1);
            desk[index].remove();
            return result;
        }
        /**
         * gets last desk of given chair model
         * @param x model number of desk
         * @param y color number of desk
         * @return last desk order
         */
        public int lastGet(int x, int y){
            if(x > od_mn && y > od_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (od_mn*x)+y;
            KWArrayList<Integer> last = desk[index].getLast();
            return last.get(last.getSize()-1);
        }

    }
    private class MeetingTables{
        private HybridListClass<Integer>[] table = new HybridListClass[mt_mn*mt_mc];
        /**
         * constructor of table
         * allocates memory for all tables
         */
        public MeetingTables(){
            for(int i=0 ; i<mt_mn*mt_mc ; i++){
                table[i] = new HybridListClass<Integer>();
            }
        }
        /**
         *
         * @return model numbers and color numbers of product
         */
        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            str.append("There are " + mt_mn + " model.\n");
            str.append("There are " + mt_mc + " color.\n");
            return str.toString();
        }
        /**
         * @param x model number of table
         * @param y color number of table
         * @return specific table information
         */
        public String toString(int x, int y){
            if(x > mt_mn && y > mt_mc){
                return ("Wrong Index");
            }
            int index = (mt_mn*x)+y;
            StringBuilder str = new StringBuilder();
            str.append("Meeting table " + (x+1) + ".Model " + (y+1) + ".Color ==> ");
            for(int i=0 ; i<table[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = table[index].get(index);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    str.append(temp.get(j) + " ");
                }
            }
            return str.toString();
        }
        /**
         * sum of all the previous order
         * @param x model number of table
         * @param y color number of table
         * @return sum of all table
         */
        public int sumOf(int x, int y){
            if(x > mt_mn && y > mt_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (mt_mn*x)+y;
            int sum=0;
            for(int i=0 ; i<table[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = table[index].get(index);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    sum += temp.get(j);
                }
            }
            return sum;
        }
        /**
         * adds the count of table to product
         * @param x model number of table
         * @param y color number of table
         * @param count how many table is going to be added
         * @return return true if adding operation is completed
         */
        public boolean add(int x, int y, int count){
            if(x > mt_mn && y > mt_mc){
                System.out.println("Wrong Index");
                return false;
            }
            int index = (mt_mn*x)+y;
            table[index].add(count);
            return true;
        }
        /**
         * removes last table of given chair model
         * @param x model number of table
         * @param y color number of table
         * @return last table order
         */
        public int lastProduct(int x, int y){
            if(x > mt_mn && y > mt_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (mt_mn*x)+y;
            KWArrayList<Integer> last = table[index].getLast();
            int result = last.get(last.getSize()-1);
            last.remove(last.getSize()-1);
            return result;
        }
        /**
         * gets last table of given chair model
         * @param x model number of table
         * @param y color number of table
         * @return last table order
         */
        public int lastGet(int x, int y){
            if(x > mt_mn && y > mt_mc){
                System.out.println("Wrong Index");
                return 0;
            }
            int index = (mt_mn*x)+y;
            KWArrayList<Integer> last = table[index].getLast();
            return last.get(last.getSize()-1);
        }

    }
    private class BookCases{
        private HybridListClass<Integer>[] cases = new HybridListClass[bc_mn];
        /**
         * constructor of book cases
         * allocates memory for all book cases
         */
        public BookCases(){
            for(int i=0 ; i<bc_mn ; i++){
                cases[i] = new HybridListClass<Integer>();
            }
        }
        /**
         *
         * @return model numbers and color numbers of product
         */
        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            str.append("There are " + bc_mn + " model.\n");
            return str.toString();
        }
        /**
         * @param x model number of book case
         * @return specific book case information
         */
        public String toString(int x){
            if(x > bc_mn){
                return ("Wrong Index");
            }
            int index = x;
            StringBuilder str = new StringBuilder();
            str.append("Book Cases " + (x+1) + ".Model ");
            for(int i=0 ; i<cases[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = cases[index].get(index);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    str.append(temp.get(j) + " ");
                }
            }
            return str.toString();
        }
        /**
         * sum of all the previous order
         * @param x model number of book cases
         * @return sum of all book cases
         */
        public int sumOf(int x){
            if(x > bc_mn){
                System.out.println(("Wrong Index"));
                return 0;
            }
            int index = x;
            int sum=0;
            for(int i=0 ; i<cases[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = cases[index].get(index);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    sum += temp.get(j);
                }
            }
            return sum;
        }
        /**
         * adds the count of book cases to product
         * @param x model number of book cases
         * @param count how many book cases is going to be added
         * @return return true if adding operation is completed
         */
        public boolean add(int x,int count){
            if(x > bc_mn){
                System.out.println(("Wrong Index"));
                return false;
            }
            int index = x;
            cases[index].add(count);
            return true;
        }
        /**
         * removes last book cases of given chair model
         * @param x model number of book cases
         * @return last book cases order
         */
        public int lastProduct(int x){
            if(x > bc_mn){
                System.out.println(("Wrong Index"));
                return 0;
            }
            int index = x;
            KWArrayList<Integer> last = cases[index].getLast();
            int result = last.get(last.getSize()-1);
            last.remove(last.getSize()-1);
            return result;
        }
        /**
         * gets last book cases of given chair model
         * @param x model number of book cases
         * @return last book cases order
         */
        public int lastGet(int x){
            if(x > bc_mn){
                System.out.println(("Wrong Index"));
                return 0;
            }
            int index = x;
            KWArrayList<Integer> last = cases[index].getLast();
            return last.get(last.getSize()-1);
        }


    }
    private class OfficeCabinets{
        private HybridListClass<Integer>[] cabinet = new HybridListClass[oca_mn];
        /**
         * constructor of cabinets
         * allocates memory for all cabinets
         */
        public OfficeCabinets(){
            for(int i=0 ; i<oca_mn ; i++){
                cabinet[i] = new HybridListClass<Integer>();
            }
        }
        /**
         *
         * @return model numbers and color numbers of product
         */
        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            str.append("There are " + oca_mn + " model.\n");
            return str.toString();
        }
        /**
         * @param x model number of cabinet
         * @return specific cabinet information
         */
        public String toString(int x){
            if(x > oca_mn){
                return(("Wrong Index"));
            }
            int index = x;
            StringBuilder str = new StringBuilder();
            str.append("Office Cabinets " + (x+1) + ".Model ");
            for(int i=0 ; i<cabinet[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = cabinet[index].get(index);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    str.append(temp.get(j) + " ");
                }
            }
            return str.toString();
        }
        /**
         * sum of all the previous order
         * @param x model number of cabinet
         * @return sum of all cabinet
         */
        public int sumOf(int x){
            if(x > oca_mn){
                System.out.println(("Wrong Index"));
                return 0;
            }
            int index = x;
            int sum=0;
            for(int i=0 ; i<cabinet[index].getSizeLinkedList() ; i++){
                KWArrayList<Integer> temp = cabinet[index].get(index);
                for(int j=0 ; j<temp.getSize() ; j++ ){
                    sum += temp.get(j);
                }
            }
            return sum;
        }
        /**
         * adds the count of cabinet to product
         * @param x model number of cabinet
         * @param count how many cabinet is going to be added
         * @return return true if adding operation is completed
         */
        public boolean add(int x,int count){
            if(x > oca_mn){
                System.out.println(("Wrong Index"));
                return false;
            }
            int index = x;
            cabinet[index].add(count);
            return true;
        }
        /**
         * removes last cabinet of given chair model
         * @param x model number of cabinet
         * @return last book cabinet
         */
        public int lastProduct(int x){
            if(x > oca_mn){
                System.out.println(("Wrong Index"));
                return 0;
            }
            int index = x;
            KWArrayList<Integer> last = cabinet[index].getLast();
            int result = last.get(last.getSize()-1);
            last.remove(last.getSize()-1);
            return result;
        }
        /**
         * gets last cabinet of given chair model
         * @param x model number of cabinet
         * @return last cabinet order
         */
        public int lastGet(int x){
            if(x > oca_mn){
                System.out.println(("Wrong Index"));
                return 0;
            }
            int index = x;
            KWArrayList<Integer> last = cabinet[index].getLast();
            return last.get(last.getSize()-1);
        }

    }

    /**
      Constructor
     */

    public Product(){
        chair = new OfficeChair();
        desk = new OfficeDesk();
        table = new MeetingTables();
        cases = new BookCases();
        cabinet = new OfficeCabinets();
    }
    public Product(int x, int y, int count, int choice){
        this();
        this.x = x;
        this.y = y;
        this.count = count;
        this.choice = choice;
        add(choice, x, y, count);
    }

    /**
     * This method returns the product of company
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Scanner input = new Scanner(System.in);
        System.out.println("Which product do you want to see?");
        System.out.println("1-)Office Chair");
        System.out.println("2-)Office Desk");
        System.out.println("3-)Meeting Tables");
        System.out.println("4-)Book Cases");
        System.out.println("5-)Office Cabinets");
        switch(input.nextInt()){
            case 1:
                str.append(chair.toString());
                break;
            case 2:
                str.append(desk.toString());
                break;
            case 3:
                str.append(table.toString());
                break;
            case 4:
                str.append(cases.toString());
                break;
            case 5:
                str.append(cabinet.toString());
                break;
            default:
                str.append("Nothing to show");
                break;
        }
        return str.toString();
    }

    /**
     * shows all the products
     * @param x
     * @return
     */
    public String toString(boolean x){
        StringBuilder str = new StringBuilder();
        str.append(chair.toString() + "\n");
        str.append(desk.toString() + "\n");
        str.append(table.toString() + "\n");
        str.append(cases.toString() + "\n");
        str.append(cabinet.toString() + "\n");
        return str.toString();
    }

    /**
     * shows given products which has to be added
     * @param choice
     * @param product
     * @return
     */
    public String toString(int choice, Product product){
        this.x = product.x;
        this.y = product.y;
        this.choice = choice;
        StringBuilder str = new StringBuilder();
        if(check(choice,product) == true){
            return "";
        }
        switch (choice){
            case 1:
                str.append((product.count - chair.sumOf(product.x, product.y))  + " chair needs to be added \n") ;
                break;
            case 2:
                str.append((product.count - desk.sumOf(product.x, product.y)) + " desk needs to be added \n" ) ;
                break;
            case 3:
                str.append((product.count - table.sumOf(product.x, product.y)) + " table needs to be added \n") ;
                break;
            case 4:
                str.append((product.count - cabinet.sumOf(product.x)) + " cabinet needs to be added \n") ;
                break;
            case 5:
                str.append((product.count - cases.sumOf(product.x)) + " book cases needs to be added \n") ;
                break;
        }
        return str.toString();
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * adds product to given office product
     * @param choice
     * @param x
     * @param y
     * @param count
     * @return
     */
    public boolean add(int choice, int x, int y, int count){
        this.x = x;
        this.y = y;
        this.choice = choice;
        switch (choice){
            case 1:
                return chair.add(x, y, count);
            case 2:
                return desk.add(x, y, count);
            case 3:
                return table.add(x, y, count);
            case 4:
                return cabinet.add(x , count);
            case 5:
                return cases.add(x , count);
        }
        return false;
    }
    /**
     * adds product to given office product
     * @param choice
     * @param product
     * @return
     */
    public boolean add(int choice, Product product){
        this.x = product.x;
        this.y = product.y;
        this.choice = choice;
        switch (choice){
            case 1:
                return chair.add(product.x, product.y, product.count);
            case 2:
                return desk.add(product.x, product.y, product.count);
            case 3:
                return table.add(product.x, product.y, product.count);
            case 4:
                return cabinet.add(product.x , product.count);
            case 5:
                return cases.add(product.x , product.count);
        }
        return false;
    }

    /**
     * compares if branch product is more than customer product
     * @param choice
     * @param product
     * @return
     */
    public boolean check(int choice, Product product){
        switch (choice){
            case 1:
                return chair.sumOf(product.x, product.y) >= product.chair.sumOf(product.x, product.y);
            case 2:
                return desk.sumOf(product.x, product.y) >= product.desk.sumOf(product.x, product.y);
            case 3:
                return table.sumOf(product.x, product.y) >= product.table.sumOf(product.x, product.y);
            case 4:
                return cabinet.sumOf(product.x) >= product.cabinet.sumOf(product.x);
            case 5:
                return cases.sumOf(product.x) >= product.cases.sumOf(product.x);
        }
        return false;
    }

    public String previous(int choice, int x){
        return previous(choice, x, 0);
    }

    /**
     * reaches the previous orders
     * @param choice
     * @param x
     * @param y
     * @return
     */
    public String previous(int choice, int x, int y){
        switch (choice){
            case 1:
                return chair.toString(x,y);
            case 2:
                return desk.toString(x,y);
            case 3:
                return table.toString(x, y);
            case 4:
                return cabinet.toString(x);
            case 5:
                return cases.toString(x);
        }
        return "";
    }

    /**
     * removes last added item
     * @return
     */
    public int removeLast(){
        switch (choice){
            case 1:
                return chair.lastProduct(x, y);
            case 2:
                return desk.lastProduct(x, y);
            case 3:
                return table.lastProduct(x, y);
            case 4:
                return cabinet.lastProduct(x);
            case 5:
                return cases.lastProduct(x);
        }
        return -1;
    }

    /**
     * removes all the given product from given office product
     * @param choice
     * @param product
     * @return
     */
    public boolean remove(int choice,Product product){
        switch (choice){
            case 1:
                if(chair.lastGet(product.x, product.y) > product.count){
                    int z = chair.lastProduct(x, y);
                    chair.add(product.x, product.y, z-product.count);
                    return true;
                }
                product.count -= chair.lastProduct(x, y);
                return remove(product.choice, product);
            case 2:
                if(desk.lastGet(product.x, product.y) > product.count){
                    int z = desk.lastProduct(x, y);
                    desk.add(product.x, product.y, z-product.count);
                    return true;
                }
                product.count -= desk.lastProduct(x, y);
                return remove(product.choice, product);
            case 3:
                if(table.lastGet(product.x, product.y) > product.count){
                    int z = table.lastProduct(x, y);
                    table.add(product.x, product.y, z-product.count);
                    return true;
                }
                product.count -= table.lastProduct(x, y);
                return remove(product.choice, product);
            case 4:
                if(cabinet.lastGet(product.x) > product.count){
                    int z =cabinet.lastProduct(x);
                    cabinet.add(product.x, z-product.count);
                    return true;
                }
                product.count -= cabinet.lastProduct(x);
                return remove(product.choice, product);
            case 5:
                if(cases.lastGet(product.x) > product.count){
                    int z = cases.lastProduct(x);
                    cases.add(product.x, z-product.count);
                    return true;
                }
                product.count -= cases.lastProduct(x);
                return remove(product.choice, product);
        }
        return false;
    }

}
