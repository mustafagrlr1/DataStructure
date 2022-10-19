/**
 * Ordering class
 * this class takes an order from customer
 * 3 different state have been added, it
 * shows the states of order process
 */

public class Order {

    public enum Ordering{
        MET,// if it is a new order
        ADDED, // order added to product
        REMOVED, // order denied by the trader
    }

    public final String trader;
    public final String customer;
    public final String product;
    public final Ordering product_state;

    /**
     * Constructor of order
     * @param trader owns the product
     * @param customer orders the product
     * @param product
     * @param product_state shows the process about product
     */
    public Order(String trader, String customer, String product, Ordering product_state) {
        this.trader = trader;
        this.customer = customer;
        this.product = product;
        this.product_state = product_state;
    }

    /**
     * gives the order information
     * @return order info
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("**********Orders************");
        sb.append("Trader ID:" + sb.append(trader) + "\n");
        sb.append("Customer ID:" + sb.append(customer) + "\n");
        sb.append("product ID:" + sb.append(product) + "\n");
        switch (product_state){
            case MET:
                sb.append("Order State: Met\n");
                break;
            case ADDED:
                sb.append("Order State: Added\n");
                break;
            case REMOVED:
                sb.append("Order State: Removed\n");
                break;
        }
        return sb.toString();
    }

    public String getTrader() {
        return trader;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public Ordering getProduct_state() {
        return product_state;
    }
}
