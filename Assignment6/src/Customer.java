/**
 * Customer class
 */

import java.util.*;

public class Customer extends User {

    HashMap<String, Product> products;
    LinkedList<Order> orders;

    /**
     * Constructor of customer class
     * @param ID of customer
     * @param password of customer
     * @param name of customer
     * @param state of customer
     */
    public Customer(String ID, String password, String name, User_State state) {

        super(ID, password, name, state);
        orders = new LinkedList<>();
    }


    /**
     * list customer own orders
     */
    @Override
    public boolean list_orders() {
        Iterator<Order> it = orders.iterator();
        while(it.hasNext()){
            it.next().toString();
        }
        return true;
    }

    /**
     * adds new product
     * @param product
     * @return
     */
    @Override
    public boolean add_product(Product product) {
        products.put(product.getID(), product);
        return true;
    }

    /**
     * removes product inside the products
     * @param product
     */
    @Override
    public boolean remove_product(Product product) {
        products.remove(product.getID());
        return true;
    }

    /**
     * list all the old products
     */
    public boolean list_products() {
        Iterator<String> it = products.keySet().iterator();
        while(it.hasNext()){
            products.get(it.next());
        }
        return true;
    }


    /**
     * gets all the products
     * @return
     */
    public ArrayList<Product> getProducts() {
        Iterator<String> it = products.keySet().iterator();
        ArrayList<Product> order = new ArrayList<>();
        for(int i=0 ; i<products.size() ; i++){
            order.add(products.get(it.next()));
        }
            return order;
    }

    /**
     * sets with new market
     * @param ID
     * @param list
     */
    public void setProducts(String ID, ArrayList<Product> list) {
        products = new HashMap<>();
        for(int i=0 ; i<list.size() ; i++){
            products.put(ID, list.get(0));
        }
    }

    /**
     * getter of all orders
     * @return
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * setter of all orders
     * @param orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = (LinkedList<Order>) orders;
    }
}
