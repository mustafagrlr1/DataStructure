

/**
 * Employee in the company
 *
 * @author mustafa Gurler
 * @version 1.0
 */

public class BranchEmployee extends Human{

    /**
     * This method add new customer If customer id's is not valid. New Subscription.
     * @param company
     * @param newCustomer
     */
    public void _newSubscripton(Company company, Customer newCustomer){
        company.setCustomer_number(company.getCustomer_number()+1);
        company.getCustomers().add(newCustomer);
        System.out.println(newCustomer.getName() + " has been added");
    }

    /**
     * This method tries to update order list for specific client so client
     * can check last his/her order.
     * @param company
     * @param customer
     * @param product
     * @param choice
     */
    public boolean _updatePreviousOrder(Company company, Customer customer, Product product, int choice){
        int index = company.getCustomers().indexOf(customer);
        if(index != -1){
            company.getCustomers().get(index).getProducts().add(choice, product);
            return true;
        }
        return false;

    }
    /**
     * This method access to previous order to selected customer
     * @param company
     * @param customer
     * @param x
     * @param y
     * @return access previous order
     */
    public String _accessPreviousOrder(Company company, Customer customer,int choice, int x, int y){
        int index = company.getCustomers().indexOf(customer);
        if(index != -1){
            return company.getCustomers().get(index).getProducts().previous(choice, x, y);
        }
        return "";
    }

    /**
     * This method removes the last order
     * @param company
     * @param customer
     */
    public void _removeOrder(Company company, Customer customer){
        int index = company.getCustomers().indexOf(customer);
        if(index != -1){
            company.getCustomers().get(index).getProducts().removeLast();
        }
    }

    /**
     * searchs product if it is exist
     * @param company
     * @param selected
     * @param product
     * @param choice
     * @return boolean if it is exits in the branch
     */
    public boolean _searchProduct(Company company, Branch selected, Product product, int choice){
        if(company.getBranches().indexOf(selected) != -1){
            return (selected.getProducts().check(choice, product));
        }
        return false;
    }

    /**
     *
     * @return employee information
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("ID:").append(id).append("\n");
        return str.toString();
    }

    /**
     *
     * @return name of employee
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id of employee
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * constructor about employee information
     * @param name
     * @param surname
     * @param id
     */
    public BranchEmployee(String name, String surname, String id) {
        super(name, surname);
        this.id = id;
    }

    private String id;


}