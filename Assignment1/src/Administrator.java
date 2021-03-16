/**
 * Leader of the Branch's  who is responsible for all company
 *
 * @author Mustafa Gurler
 * @version 1.0
 *
 */


public class Administrator extends Company implements Human{


    /**
    * Add a new branch to company, if it is already exits throws an exception
     * @param ID
     * @param name
     * @return null
     */
    public void _addBranch(String name, String ID){

        Company.setBranch_number(Company.getBranch_number()+1);
        Company.getBranches()[Company.getBranch_number()-1] = new Branch(name, ID);
        System.out.println(name + " has been added");

    }


    /**
     * Removes the selected branch from company
     * @param selectedBranch
     * @return selected Branch Name
     */
    public void _removeBranch(Branch selectedBranch){
        int count = 0;

        for(int i=0 ; i < getBranch_number() ; i++){

            if(Company.getBranches()[i] == selectedBranch){
                for(int j=count ; j<Company.getBranches().length-1; j++){

                    Company.getBranches()[j] = Company.getBranches()[j+1];
                }
                Company.setBranch_number(Company.getBranch_number()-1);
                break;
            }
            count++;
        }

    }

    /*

     */

    /**
     *
     * Add a new employee , if Branch is not
     * on the company throws an exception
     * @param name
     * @param surname
     * @param id
     */
    public void _addBEmployee(String name, String surname,String id){
        Company.setEmployee_number(Company.getEmployee_number()+1);
        BranchEmployee br = new BranchEmployee(name, surname, id);
        Company.getEmployee()[Company.getEmployee_number()-1] = br;
        System.out.println(name + " has been added.");

    }


    /**
     * Remove an employee from selected Branch, if branch is on the list or empty throw an exception
     * @param selectedEmployee
     * @return null
     */
    public void _removeBEmployee(BranchEmployee selectedEmployee){
        int count = 0;
        for(int i=0 ; i < getEmployee_number() ; i++){
            if(Company.getEmployee()[i] == selectedEmployee){
                for(int j=count ; j<Company.getBranch_number() ; j++){

                    Company.getEmployee()[j] = Company.getEmployee()[j+1];
                }
                Company.setEmployee_number(Company.getEmployee_number()-1);
                break;
            }
            count++;
        }

    }

    /**
     * Add product for specific branch
     * @param selected
     * @param newProduct
     */
    public void _addProduct(Branch selected, Product newProduct){
        for(int i=0 ; i < Company.getBranch_number() ; i++) {
            if (Company.getBranches()[i] == selected) {
                Company.getBranches()[i].getProducts()._update(newProduct);
            }
        }
    }

    /*
    *
     */

    /**
     * Quiery to stock if there is needed to add a new product
     * @param selected
     * @param product
     * @return
     */
    public boolean _inquireProduct(Branch selected, Product product){
        for(Branch i : Company.getBranches()) {
            if (i == selected) {
                return i.getProducts()._check_product(product);
            }
        }
        return false;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    /**
     * Constructor
     * @param name
     * @param surname
     */
    public Administrator(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    private String name;

    private String surname;
}
