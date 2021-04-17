
/**
 * Customer in the Company
 *
 * @author mustafa Gurler
 *
 */

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Customer extends Human{

    /**
     * This method take an product from customer request and adds to customers product
     * @param company
     * @param selected
     * @param product
     */
    public boolean _order(Company company, Branch selected, Product product){
        if(company.getBranches().indexOf(selected) != -1){
            if(selected.getProducts().check(product.getChoice(), product)){
                this.products.add(product.getChoice(),product);
                selected.getProducts().remove(product.getChoice(), product);
                order_product_number++;
                return true;
            }
            System.out.println("There is no enough product!!!!");
            return false;
        }
        System.out.println("Branch is not in the list");
        return false;
    }

    /**
     * This method shows previous order of specific customer
     * @param company
     * @param x model number
     * @param y color number
     * @return to show previous order
     */
    public String _previousOrder(Company company,int x, int y,int choice){
        int index = company.getCustomers().indexOf(this);
        if(index != -1){
            return company.getCustomers().get(index).getProducts().previous(choice,x, y);
        }
        return "";
    }


    /**
     * This method searching products for given product
     * @param company
     * @param selected
     * @param product
     * @return true if it is exist in the customer product
     * @throws NullPointerException
     */
    public boolean _searchProduct(Company company, Branch selected, Product product){
        if(company.getBranches().indexOf(selected) != -1){
            return  selected.getProducts().check(product.getChoice(), product);
        }
        System.out.println("There is no branch");
        return false;
    }


    /**
     * Constructor for customer information
     * @param name
     * @param surname
     * @param mail
     */
    public Customer(String name, String surname, String mail, String ID){
        super(name,surname);
        this.mail = mail;
        this.id = ID;
    }


    /**
     * products of customer previous
     * @return
     */
    public Product getProducts() {
        return products;
    }

    /**
     * ID of customer
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * If customer wants to change the ID
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * password of customer
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * if customer wants to change the password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }



    /**
     * This method shows customer information
     * @return
     */

    public String toString(){

        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("Customer ID  :" + this.id + "\n");
        str.append("\nCustomer mail:" + this.mail + "\n");

        return str.toString();
    }

    private int order_product_number;

    private String id;

    private String mail;

    private String password;


    private Product products = new Product();

}
