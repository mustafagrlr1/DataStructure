/**
 * User authentication and sorting methods
 */


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class UserAuthentaciton implements Files {

    /**
     * reads the user file and returns all the user
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<User> userList() throws FileNotFoundException {
        List<User> list = new ArrayList<>();

        String line;
        String split = ";";
        User_State state = User_State.Trader;
        try(BufferedReader br = new BufferedReader(new FileReader(new File("users.txt")))){
            while((line = br.readLine()) != null){
                String[] data = line.split(split);
                for(int i = 0; i < data.length/4 ; i++){
                    if(data[i*4+3].equals("Trader")){
                        state = User_State.Trader;
                        list.add(new Trader(data[i*4+0],data[i*4+1],data[i*4+2],state));
                    }else{
                        state = User_State.Customer;
                        list.add(new Customer(data[i*4+0],data[i*4+1],data[i*4+2],state));
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (ArrayList) list;
    }

    /**
     * searchs one user and the user manages the system
     * @param user
     * @param ID_login
     * @param password_login
     * @return
     */
    public User login(ArrayList<User> user, String ID_login, String password_login){

        for(int i=0; i<user.size() ; i++) {
            if (user.get(i).getID().equals(ID_login) && user.get(i).getPassword().equals(password_login)) {
                return user.get(i);
            }
        }
        return null;
    }


    /**
     * reads the products
     * @return
     */
    public List<Product> csvFileReader(String id){
        ArrayList<Product>  sortedProduct = new ArrayList<>();
        String csvFile = dataFile;
        String line = "";
        String csvSplit = ";";
        int j=0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            while((line = br.readLine()) != null){
                String[] data = line.split(csvSplit);
                for(int i = 0; i < 1 ; i++){
                    if(j==0){
                        j++;
                    }else {
                        int price = Integer.valueOf(data[3]);
                        int discount = Integer.valueOf(data[4]);
                        if (data[6].equals(id)) {
                            sortedProduct.add(new Product(data[0], data[1], data[2], data[5], price, discount, data[6]));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sortedProduct;
    }

    /**
     * switches two indexes of arraylist to create a sorted arraylist
     * @param sortedProduct to be needs to sorted
     * @param i small index
     * @param j bigger index
     * @param max other product
     */
    public void switchNodes(ArrayList<Product> sortedProduct, int i, int j, Product max){
        Product temp = sortedProduct.get(i);
        sortedProduct.set(i , max);
        sortedProduct.set(j , temp);

    }

    /**
     * finds a sorted array
     * @param sortedProduct
     * @param i
     * @param size
     */
    private void heapifyCategory(ArrayList<Product> sortedProduct, int i, int size){

        int right = 2*i+2;
        int left = 2*i+1;
        if(left > size || right > size){
            return;
        }
        Product leftProduct = sortedProduct.get(left);
        Product rightProduct = sortedProduct.get(right);
        Product max;
        int j;

        if(left <= size && (leftProduct.getCategory().compareTo(sortedProduct.get(i).getCategory())) == 1) {
            max = leftProduct;
            j = left;
        }
        else {
            max = sortedProduct.get(i);
            j = i;
        }
        if(right <= size && (rightProduct.getCategory().compareTo(sortedProduct.get(i).getCategory())) == 1) {
            max = rightProduct;
            j = right;
        }
        if(max != sortedProduct.get(i))
        {

            switchNodes(sortedProduct, i, j, max);
            heapifyCategory(sortedProduct, i+1, size);

        }
    }

    /**
     * makes a heap to create a sorted array depend on category name
     * @param product
     */
    public void makeHeapCategory(ArrayList<Product> product)
    {

        for(int i = product.size()/2; i>=0; i--)
            heapifyCategory(product, i, product.size()-1);


    }

    public ArrayList<Product> sortCategory(ArrayList<Product> sortedProduct)
    {

        makeHeapCategory(sortedProduct);
        int sizeOfHeap = sortedProduct.size()-1;
        List<Product> product = new ArrayList<>();
        for(int i = sizeOfHeap; i>0; i--)
        {
            product.add(sortedProduct.get(i));
        }

        return (ArrayList<Product>) product;
    }

    /**
     * finds a sorted array
     * @param sortedProduct
     * @param i
     * @param size
     */
    private void heapifyName(ArrayList<Product> sortedProduct, int i, int size){

        int right = 2*i+2;
        int left = 2*i+1;
        if(left > size || right > size){
            return;
        }
        Product leftProduct = sortedProduct.get(left);
        Product rightProduct = sortedProduct.get(right);
        Product max;
        int j;

        if(left <= size && (leftProduct.getName().compareTo(sortedProduct.get(i).getName())) == 1) {
            max = leftProduct;
            j = left;
        }
        else {
            max = sortedProduct.get(i);
            j = i;
        }
        if(right <= size && (rightProduct.getCategory().compareTo(sortedProduct.get(i).getName())) == 1) {
            max = rightProduct;
            j = right;
        }
        if(max != sortedProduct.get(i))
        {

            switchNodes(sortedProduct, i, j, max);
            heapifyCategory(sortedProduct, i+1, size);

        }
    }

    /**
     * makes a heap to create a sorted array depend on  name
     * @param product
     */
    public void makeHeapName(ArrayList<Product> product)
    {

        for(int i = product.size()/2; i>=0; i--)
            heapifyName(product, i, product.size()-1);


    }

    /**
     * sorts the array depend on name
     * @param sortedProduct
     * @return
     */
    public ArrayList<Product> sortName(ArrayList<Product> sortedProduct)
    {

        makeHeapName(sortedProduct);
        int sizeOfHeap = sortedProduct.size()-1;
        List<Product> product = new ArrayList<>();
        for(int i = sizeOfHeap; i>0; i--)
        {
            product.add(sortedProduct.get(i));
        }

        return (ArrayList<Product>) product;
    }

    /**
     * sorts the array depends on price
     * @param sortedProduct
     * @return
     */
    public ArrayList<Product> sortPrice(ArrayList<Product> sortedProduct){
        for (int unsorted = 1; unsorted < sortedProduct.size(); ++unsorted) {
            Product nextItem = sortedProduct.get(unsorted);
            int loc = unsorted;
            while ((loc > 0) &&(sortedProduct.get(loc-1).getPrice() > (nextItem.getPrice()))) {
                sortedProduct.set(loc, nextItem);
            } // end while
            sortedProduct.set(loc, nextItem);
        }
        return sortedProduct;
    }

    /**
     * sorts the array depend on price between lower and upper bound
     * @param sortedProduct
     * @param lower
     * @param upper
     * @return
     */
    public LinkedList<Product> sortPriceLowerUpper(ArrayList<Product> sortedProduct, int lower, int upper){
        LinkedList<Product> sort = new LinkedList();
        for(int i=0 ; i < sortedProduct.size() ; i++){
            if(sortedProduct.get(i).getPrice() > lower && sortedProduct.get(i).getPrice() < upper){
                sort.add(sortedProduct.get(i));
            }
        }
        return sort;
    }

    /**
     * sorts the array depends on discount
     * @param sortedProduct
     * @return
     */
    public ArrayList<Product> sortDiscount(ArrayList<Product> sortedProduct){
        for (int unsorted = 1; unsorted < sortedProduct.size(); ++unsorted) {
            Product nextItem = sortedProduct.get(unsorted);
            int loc = unsorted;
            while ((loc > 0) &&(sortedProduct.get(loc-1).getDiscount_amount() > (nextItem.getDiscount_amount()))) {
                sortedProduct.set(loc, nextItem);
            } // end while
            sortedProduct.set(loc, nextItem);
        }
        return sortedProduct;
    }

    /**
     * sorts the array depends on discount between lower and upper bound
     * @param sortedProduct
     * @param lower
     * @param upper
     * @return
     */
    public LinkedList<Product> sortDiscountLowerUpper(ArrayList<Product> sortedProduct, int lower, int upper){
        LinkedList<Product> sort = new LinkedList();
        for(int i=0 ; i < sortedProduct.size() ; i++){
            if(sortedProduct.get(i).getDiscount_amount() > lower && sortedProduct.get(i).getDiscount_amount() < upper){
                sort.add(sortedProduct.get(i));
            }
        }
        return sort;
    }


}
