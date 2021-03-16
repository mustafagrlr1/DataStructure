
/**
 * Customer in the Company
 *
 * @author mustafa Gurler
 *
 */

import java.util.Scanner;

public class Customer extends Company implements Human{

    /**
     * This method take an product from customer request and adds to customers product
     * @param product
     * @return null
     */

    public void _order(Product product){
        Scanner input = new Scanner(System.in);
        try {
            if (_searchProduct(product)) {
                this.products.setOffice_desk(product.getOffice_desk());
                this.products.setMeeting_tables(product.getMeeting_tables());
                this.products.setOffice_cabinets(product.getOffice_cabinets());
                this.products.setBook_cases(product.getBook_cases());
                this.products.setOffice_chair(product.getOffice_chair());
                _updatePrevious(product);
                System.out.println("Product has been added");
            } else {
                System.out.println("There is no available Product");
                System.out.println("Informing admin");
                if (Company.getEmployee_number() == 0) {
                    System.out.println("There is no branch employee");
                    System.out.println("***************************");
                }
                BranchEmployee[] br = Company.getEmployee();
                for (int i = 0; i < Company.getEmployee_number(); i++) {

                    System.out.println((i + 1) + ".Employee");

                    System.out.println(Company.getEmployee()[i].toString());
                }
                System.out.print("Which employee is gonna inform:");
                int number = input.nextInt();
                Company.getEmployee()[number - 1]._informManager(product);

            }
        }catch (NullPointerException e){
            System.out.println("There is no branch");
        }
    }

    /**
     * This method shows previous order of specific customer
     * @return null
     */
    public void _previousOrder(){
        System.out.println("Previous orders...");
        for(int i=0 ; i<previous_order_number ; i++){
            System.out.println(getPrevious_order()[i].toString());
        }
    }

    /**
     * This method updates previous order of specific customer
     * @param product
     */
    public void _updatePrevious(Product product){

        this.previous_order[this.getPrevious_order_number()] = product;
        this.setPrevious_order_number(this.getPrevious_order_number()+1);
    }

    /**
     * This method searching products for given product
     * @param product
     * @return boolean
     * @throws NullPointerException
     */
    public boolean _searchProduct(Product product)throws NullPointerException{
        boolean result = false;
        for(int i=0 ; i<getBranch_number() ; i++){
             result = (Company.getBranches()[i].getProducts()._check_product(product));
        }
        return result;
    }

    /**
     * This method searching products for given product
     * @param product
     * @return boolean
     * @throws NullPointerException
     */
    public boolean _searchProduct(Branch branch, Product product){
        if((branch.getProducts()._check_product(product))) {
            return true;
        }
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Constructor
     * @param name
     * @param surname
     * @param mail
     */
    public Customer(String name, String surname, String mail){
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        idNumber++;
        id = Integer.toBinaryString(idNumber);
    }

    public Product[] getPrevious_order() {
        return previous_order;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPrevious_order(Product[] previous_order) {
        this.previous_order = previous_order;
    }

    public int getPrevious_order_number() {
        return previous_order_number;
    }

    public void setPrevious_order_number(int previous_order_number) {
        this.previous_order_number = previous_order_number;
    }

    /**
     * This method shows all the fields of class
     * @return String
     */

    public String toString(){
        String str = "\nCustomer Name:" + this.name;
        str += "\nCustomer Name:" + this.surname;
        str += "\nCustomer ID  :" + this.id;
        str += "\nCustomer mail:" + this.mail + "\n";

        return str;
    }

    /**
     * This method increases the capacity of product previous product
     */
    public void _set_capacity_order(){
        if(previous_order.length <= getPrevious_order_number()){
            Product[] newProduct = new Product[getPrevious_order_number()+1];
            for(int i=0 ; i < getPrevious_order_number() ; i++){
                newProduct[i] = previous_order[i];
            }
            previous_order = newProduct;

        }
        setPrevious_order_number(getPrevious_order_number()+1);
    }

    private static int idNumber;

    private String name;

    private String surname;

    private String id;

    private String mail;

    private String password;

    private String address;

    private String phoneNumber;
    private int previous_order_number = 0;
    private Product products = new Product();
    private Product[] previous_order = new Product[100];
}
