/**
 * Product
 */

import java.util.*;

public class Product extends Products {


    public String default_category = ""; // default category for searching
    public int default_low_price = Integer.MIN_VALUE; // default low price for searching
    public int default_high_price = Integer.MAX_VALUE; // default high price for searching
    public String default_name = ""; // default name for searching

    /**
     * Constructor of Product
     * @param ID of product
     * @param category of product
     * @param name of product
     * @param description of product
     * @param price of product
     * @param discount_amount of product
     */
    public Product(String ID, String category, String name, String description, int price, int discount_amount, String trader_name) {
        super(ID, category, name, description, price, discount_amount, trader_name);
        TreeSet<String> set = new TreeSet<>();
        String[] token = category.split(">>");
        for(String t : token){
            set.add(t);
        }

    }


    /**
     * gives information about product
     * @return product info
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID of Product:"+ ID + "\n");
        sb.append("Category of Product:"+ category + "\n" );
        sb.append("Name of Product" + name + "\n");
        sb.append("Description:" + description + "\n");
        sb.append("discount_amount:" + discount_amount + "\n");

        return sb.toString();

    }



}
