import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Employee in the company
 *
 * @author mustafa Gurler
 * @version 1.0
 */

public class BranchEmployee extends Company implements Human{

    /**
    * This method add new customer If customer id's is not valid. New Subscription.
    * @param newCustomer
    * @return null
     */
    public void _newSubscripton(Customer newCustomer){

        Company.setCustomer_number(Company.getCustomer_number()+1);
        Company.getCustomers()[Company.getCustomer_number()-1] = newCustomer;

    }
    /**
    * This method tries to update order list for specific client so client
    * can check last his/her order.
    * @param customer
    * @param newProduct
    * @return null
     */
    public void _updatePreviousOrder(Customer customer, Product newProduct){
        for(Customer i : Company.getCustomers()){
            if(i.equals(customer)){
                customer._updatePrevious(newProduct);
            }
        }
    }

    /**
     *
     * This method access to previous order to selected customer
     * @param customer
     * @return null
     */
    public void _accessPreviousOrder(Customer customer){

        for(Product i : customer.getPrevious_order()){
            if(i == null){
                break;

            }
            System.out.println(i.toString());
        }
    }

    /**
    * This method makes sale to client. Interacts with customer
     * @param selected
     * @param customer
     * @param newOrder
     * @return null
     */
    public void _makeSales(Branch selected, Customer customer, Product newOrder){
        for(int i=0 ; i < Company.getCustomer_number() ; i++) {
            if (Company.getCustomers()[i] == customer) {
                Company.getCustomers()[i].getProducts()._update(newOrder);
                System.out.println("Making sales to customer");
            }
        }
    }

    /**
    * This method removes the last order if zero throws an exception
     * @param customer
     * @return null
    */
    public void _removeOrder(Customer customer){
        if(customer.getPrevious_order_number() != 0){
            customer.setPrevious_order_number(customer.getPrevious_order_number()-1);
            System.out.println("Last order has been removed");
        }
    }

    /**
     *
     * @param selected
     * @param product
     * @return boolean
     */

    public boolean _inquireStock(Branch selected, Product product){
        for(Branch i : Company.getBranches()) {
            if (i == selected) {
                return i.getProducts()._check_product(product);
            }
        }
        return false;
    }

    /**
     *
     * @return String
     */

    public String toString(){
        String str = "";
        str += "Customer Name:" + this.name + "\n";
        str += "Customer Name:" + this.surname + "\n";
        str += "Customer ID  :" + this.id + "\n";

        return str ;
    }

    /**
     *
     * @param product
     * @return boolean
     */

    public boolean _informManager(Product product) {
        for (Branch i : Company.getBranches()) {
            return i.getProducts()._check_product(product);
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BranchEmployee(String name, String surname, String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }


    private String id;

    private String name;

    private String surname;

    private Product[] previous_order;

}
