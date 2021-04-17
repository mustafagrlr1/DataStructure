import java.util.Iterator;

/**
 * Leader of the Branch's  who is responsible for all company
 *
 * @author Mustafa Gurler
 * @version 1.0
 *
 */


public class Administrator extends Human{


    /**
     * Add a new branch to company, if it is already exits throws an exception
     * @param company
     * @param branch
     */
    public void _addBranch(Company company, Branch branch){

        company.setBranch_number(company.getBranch_number()+1);
        company.getBranches().add(branch);
        System.out.println(branch.getName() + " has been added");

    }

    /**
     * Removes the selected branch from company
     * @param company
     * @param selectedBranch
     * @return return branch name which has been removed
     */
    public String _removeBranch(Company company, Branch selectedBranch){


        Iterator<Branch> it = company.getBranches().iterator();
        String branchName = selectedBranch.getName();
        int count = 0;
        while(it.hasNext()) {
            if(it.next() == selectedBranch) {
                company.getBranches().remove(count);
            }
            count++;
        }
        company.setBranch_number(company.getBranch_number()-1);
        return branchName;
    }

    /**
     * Add a new employee , if Branch is not
     * on the company throws an exception
     * @param company
     * @param employee
     */
    public void _addBEmployee(Company company, BranchEmployee employee){
        company.setEmployee_number(company.getEmployee_number()+1);
        company.getEmployee().add(employee);
        System.out.println(employee.name + " has been added.");
    }

    /**
     * Remove an employee from selected Branch, if branch is on the list or empty throw an exception
     * @param company
     * @param selectedEmployee
     */
    public void _removeBEmployee(Company company, BranchEmployee selectedEmployee){
        try {
            company.getEmployee().remove(company.getEmployee().indexOf(selectedEmployee));
            company.setEmployee_number(company.getEmployee_number()-1);
            System.out.println(selectedEmployee.getName() + " has been removed");
        }catch (Exception e){
            System.out.println("There is no existing employee");
        }
    }

    /**
     * Add product for specific branch
     * @param company
     * @param selected
     * @param product
     * @param choice
     */
    public void _addProduct(Company company, Branch selected, Product product, int choice) {
        if(company.getBranches().indexOf(selected) != -1){
            selected.getProducts().add(choice, product);
        }else{
            System.out.println("There is no existing branch");
        }
    }

    /**
     * Removes  selected branch's products
     * @param company
     * @param selected
     * @param product
     * @param choice
     */
    public void _removeProduct(Company company, Branch selected, Product product, int choice) {
        if(company.getBranches().indexOf(selected) != -1){
            selected.getProducts().remove(choice, product);
        }
    }

    /**
     * Quiery to stock if there is needed to add a new product
     * @param company
     * @param selected
     * @param product
     * @param choice
     * @return returns needed product by branch
     */
    public String _inquireProduct(Company company, Branch selected, Product product, int choice){
        if(company.getBranches().indexOf(selected) != -1){
            return  selected.getProducts().toString(choice, product);
        }
        return "There is no branch";
    }

    /**
     * Constructor of class
     * @param name
     * @param surname
     */
    public Administrator(String name, String surname){
        super(name,surname);
    }

    /**
     *
     * @return name and surname about admin
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        return str.toString();
    }

}
