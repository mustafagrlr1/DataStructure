/**
 * Trader class
 * managese all the products
 * takes order from customer
 */


import java.util.*;

public class Trader extends User{

    HashMap<String, Product> products;
    Queue<Order> orders;

    /**
     * constructor of user extended from user class
     * @param ID of trader
     * @param password of trader
     * @param name of trader
     * @param state of trader
     */
    public Trader(String ID, String password, String name, User_State state) {

        super(ID, password, name, state);
        orders = new PriorityQueue<>();
    }

    /**
     * list all the  own products
     */
    public boolean list_products() {
        Iterator<String> it = products.keySet().iterator();
        while(it.hasNext()){
            products.get(it.next());
        }
        return true;
    }

    /**
     * edits  the product with a new product
     * @param product
     * @param editing_product
     */
    public boolean edit_product(Product product, Product editing_product) {
        products.put(product.getID(), editing_product);
        return true;
    }

    /**
     * list customer orders
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
     * removes product from list
     * @param product selected
     */
    @Override
    public boolean remove_product(Product product) {
        products.remove(product.getID());
        return true;
    }

    /**
     * adds product the market
     * @param product to be inserted
     * @return
     */
    @Override
    public boolean add_product(Product product) {
        products.put(product.getID(), product);
        return true;
    }

    /**
     * gets all the products
     * @return
     */
    public HashMap<String, Product> getProducts() {
        return products;
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
     * gets all the customer orders
     * @return
     */
    public Queue<Order> getOrders() {
        return orders;
    }

    /**
     * sets all the customer orders
     * @param orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = (LinkedList<Order>) orders;
    }

    public void add_order(Order order){
        orders.add(order);
    }

    public void accept_order(){
        Order order = orders.peek();
        if(order.getProduct_state() == Order.Ordering.MET){
            orders.remove(order);
        }

    }
    public void remove_order(){

        orders.remove(orders.peek());
    }
}
