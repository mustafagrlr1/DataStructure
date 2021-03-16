/**
 * Branch in the Company
 * @author Mustafa Gurler
 *
 */

public class Branch implements CompanyInformation {


    private Product products;

    private String branchID;

    private String name;


    /**
     * Constructor
     * @param name
     * @param ID
     */

    public Branch(String name, String ID){
        this.branchID = ID;
        this.name = name;
        this.products = new Product();
        this.products.setOffice_chair();
        this.products.setBook_cases();
        this.products.setOffice_cabinets();
        this.products.setMeeting_tables();
        this.products.setOffice_desk();

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method shows to Branches name and id,
     * @return
     */
    public String toString(){
        String str = "";
        str += getBranchID() + "\n";
        str += getName() + "\n";
        return str;
    }
}
