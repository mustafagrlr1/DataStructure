/**
 * Main class of the company
 */


import java.io.File;
import java.util.*;

public class E_Shopping extends UserAuthentaciton {

    private ArrayList<User> listUsers;// takes all user from file
    private User user; // one user only user
    private HashMap<String,Product> products; // products of trader or customer
    private User customer;

    /**
     * constructor finds the user from users.txt
     * @param ID of user
     * @param password of user
     */
    public  E_Shopping(String ID, String password) {
        try{
            listUsers = userList();
            sortUser();
            user = login(listUsers, ID, password);
            customer = login(listUsers, "23241232","234567");

        }catch(Exception e) {
            System.err.println("Wrong ID and password!!");
        }
    }

    /**
     * gives the opportunity to user to add, remove, edit
     * or list all the products
     */
    public void menu(){
        Product product = new Product("SRTEH2FF9KEDEFGF","Alisha Solid Women's Cycling Shorts","Alisha Solid Women's Cycling Shorts","Key Features of Alisha Solid Women's Cycling Shorts Cotton Lycra Navy, Red, Navy,Specifications of Alisha Solid Women",999,379,"Alisha");
        System.out.println("Welcome the E-Shopping");
        int choice;
        String productID = null;
        ArrayList<Product> productList = (ArrayList<Product>) csvFileReader("BigCompany");

        switch (user.getState()){
            case Trader:
                user = (Trader) user;
                ((Trader) user).setProducts(productList.get(0).getID(), productList);
                System.out.println("Welcome to trader menu");
                System.out.println("1-)Add product");
                System.out.println("2-)Remove product");
                System.out.println("3-)Edit product");
                System.out.println("4-)List product");
                System.out.println("5-)List Orders");
                switch(1){
                    case 1:
                        try{
                            product = new Product("SRTEH2FF9KEDEFGF","Alisha Solid Women's Cycling Shorts","Alisha Solid Women's Cycling Shorts","Key Features of Alisha Solid Women's Cycling Shorts Cotton Lycra Navy, Red, Navy,Specifications of Alisha Solid Women",999,379,"Alisha");
                            if(user.add_product(product) == true){
                                System.out.println("Added trader product passed.");
                            }else{
                                System.out.println("Added trader product failed");
                            }

                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 3:
                        try {
                            if(((Trader) user).edit_product(((Trader) user).getProducts().get(product.getID()), product) == true){
                                System.out.println("Editing trader product passed");
                            }else{
                                System.out.println("Editing trader product failed");
                            }

                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 2:
                        try {
                            if(user.remove_product(((Trader) user).getProducts().get("SRTEH2FF9KEDEFGF")) == true){
                                System.out.println("Removing trader product passed");
                            }else{
                                System.out.println("Removing trader product failed");
                            }

                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 4:
                        try {
                            if(((Trader) user).list_products() == true){
                                System.out.println("Listing trader product passed");
                            }else{
                                System.out.println("Listing trader product failed");
                            }

                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 5:
                        try{
                            if(user.list_orders() == true){
                                System.out.println("Listing trader order passed");
                            }else{
                                System.out.println("Listing trader order failed");
                            }

                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                }
            case Customer:

                ((Customer) customer).setProducts(productList.get(0).getID(), productList);
                System.out.println("Welcome to Customer menu");
                System.out.println("1-)Add product");
                System.out.println("2-)Remove product");
                System.out.println("3-)List product");
                System.out.println("4-)List Orders");
                System.out.println("5-)Search by price increasing order");
                System.out.println("6-)Search by price decreasing order");
                System.out.println("7-)Search by discount amount increasing order");
                System.out.println("8-)Search by discount amount decreasing order");
                System.out.println("9-)Search by name");
                System.out.println("10-)Search by category");
                switch(1){
                    case 1:
                        try {
                            if(((Customer) customer).add_product(product) == true){
                                System.out.println("Adding customer product passed");
                            }else{
                                System.out.println("Adding customer product failed");
                            }

                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 2:
                        try{
                            if(((Customer) customer).remove_product(product) == true){
                                System.out.println("Removing customer product passed");
                            }else{
                                System.out.println("Removing customer product failed");
                            }

                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 3:
                        try {
                            if(((Customer) customer).list_products() == true){
                                System.out.println("Listing customer product passed");
                            }else{
                                System.out.println("Listing customer product failed");
                            }


                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 4:
                        try{
                            if(((Customer) customer).list_orders() == true){
                                System.out.println("Listing customer order passed");
                            }else{
                                System.out.println("Listing customer order failed");
                            }

                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 5:
                        try{
                            sortPriceLowerUpper(((Customer) customer).getProducts(),100,200);
                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 6:
                        try{
                            sortPriceLowerUpper(((Customer) customer).getProducts(),100,200);
                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 7:
                        try{
                            sortDiscountLowerUpper(((Customer) customer).getProducts(),100,200);
                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 8:
                        try{
                            sortDiscountLowerUpper(((Customer) customer).getProducts(),100,200);
                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 9:
                        try{
                            sortName(((Customer) customer).getProducts());
                        }catch(Exception e){
                            System.out.println("gives an error");
                        }
                    case 10:
                        try{
                            sortCategory(((Customer) customer).getProducts());
                        }catch(Exception e) {
                            System.out.println("gives an error");
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: ");
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user.getState());
        }

    }


    public User getUser() {
        return user;
    }

    private ArrayList<User> sortUser(){
        for(int i=0 ; i<listUsers.size() ; i++){
            for(int j=0 ; j<listUsers.size() ; j++){
                if(listUsers.get(i).equals(listUsers.get(j))){
                    User temp = listUsers.get(i);
                    listUsers.set(i, listUsers.get(j));
                    listUsers.set(i, temp);
                }
            }
        }
        return listUsers;
    }
}
