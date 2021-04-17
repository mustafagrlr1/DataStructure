/**
 * Branch in the Company
 * @author Mustafa Gurler
 *
 */

public class Branch implements CompanyInformation {

    Product products;

    private String branchID;

    private String name;


    /**
     * Constructor of branch information
     * @param name
     * @param ID
     */

    public Branch(String name, String ID){
        this.branchID = ID;
        this.name = name;
        this.products = new Product();
    }

    /**
     * products of branch
     * @return
     */
    public Product getProducts() {
        return products;
    }

    /**
     * ID of branch
     * @return
     */
    public String getBranchID() {
        return branchID;
    }

    /**
     * if admin wants to change ID of branch
     * @param branchID
     */
    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    /**
     * branch name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * if admin wants to change name of branch
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method shows to Branches name and id,
     * @return
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(getBranchID() + "\n");
        str.append(getName() + "\n");
        str.append(products.toString(true));
        return str.toString();
    }
}
