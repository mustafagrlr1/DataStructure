/**
 * The user class that makes add or remove or list product in the file
 */

import java.util.ArrayList;
import java.util.Scanner;

public abstract class User{
    String ID;
    String password;
    public User_State state = null;
    String name;

    /**
     * Constructor of user
     * @param ID of user
     * @param password of user
     */
    public User(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    /**
     * Extended Constructor of user
     * @param ID of user
     * @param password of user
     * @param name of user
     * @param state of user, trader or customer
     */
    public User(String ID, String password, String name, User_State state) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.state = state;
    }


    //GETTERS AND SETTERS

    /**
     * gets id
     * @return id
     */
    public String getID() { return ID; }

    /**
     * sets the id with new id
     * @param ID
     */
    public void setID(String ID) { this.ID = ID; }

    /**
     * gets password of user
     * @return password
     */
    public String getPassword() { return password; }

    /**
     * sets the password with new password
     * @param password
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * user can be change
     * @param state
     */
    public void setState(User_State state) {
        this.state = state;
    }

    /**
     * gets name of user
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * sets name of user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    // MUTUAL METHODS

    /**
     * shows all the order from users
     * trader shows the customer orders
     * curtomer shows the own orders
     */
    public abstract boolean   list_orders();

    /**
     *
     * @param product
     * @return
     */
    public abstract boolean add_product(Product product);

    public abstract boolean remove_product(Product product);

    public  User_State getState() {
        return state;
    }

    public abstract void setProducts(String id, ArrayList<Product> productList);
}