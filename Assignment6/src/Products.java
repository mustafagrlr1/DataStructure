/**
 * abstract class of product
 * they have same data
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public abstract class Products {

    String ID;
    String category;
    String name;
    String description;
    int price;
    int discount_amount;
    ArrayList<TreeSet<String>> categorySet;

    /**
     * Constructor of product
     * @param ID of product
     * @param category of product
     * @param name of product
     * @param description of product
     * @param price of product
     * @param discount_amount
     * @param trader_name
     */
    public Products(String ID, String category, String name, String description, int price, int discount_amount, String trader_name) {
        this.ID = ID;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount_amount = discount_amount;
    }

    /**
     * gets id
     * @return
     */
    public String getID() { return ID; }

    /**
     * sets the id
     * @param ID
     */
    public void setID(String ID) { this.ID = ID; }

    /**
     * gets the category
     * @return
     */
    public String getCategory() { return category; }

    /**
     * sets the category
     * @param category
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * gets the name
     * @return
     */
    public String getName() { return name; }

    /**
     * sets the name
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * gets the description
     * @return
     */
    public String getDescription() { return description; }

    /**
     * sets the description
     * @param description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * gets the price
     * @return
     */
    public int getPrice() { return price; }

    /**
     * sets the price
     * @param price
     */
    public void setPrice(int price) { this.price = price; }

    /**
     * gets the discount amount
     * @return
     */
    public int getDiscount_amount() { return discount_amount; }

    /**
     * sets the discount amount
     * @param discount_amount
     */
    public void setDiscount_amount(int discount_amount) { this.discount_amount = discount_amount; }
}
