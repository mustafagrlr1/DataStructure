
/**
  Company class which controls the all classes
  @author Mustafa Gurler
 */


import java.util.Scanner;

public class Company implements CompanyInformation{

    protected KWArrayList<Customer> customers = new KWArrayList<Customer>();

    protected KWLinkedList<Branch> branches = new KWLinkedList<Branch>();

    protected KWArrayList<BranchEmployee> employee = new KWArrayList<BranchEmployee>();

    protected Administrator admin;

    private int customer_number = c_number;
    private int branch_number = b_number;
    private int employee_number = e_number;

    /**
     *
     * @return company information
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0 ; i<branch_number ; i++){
            str.append("Branch name :"  + branches.get(i).getName() + " Branch ID:" + branches.get(i).getBranchID() + "\n");
        }
        for(int i=0 ; i<employee_number ; i++){
            str.append("Employee name :"  + employee.get(i).getName() + " Employee ID:" + employee.get(i).getId() + "\n");
        }

        return str.toString();
    }


    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }


    /**
     *
     * @return customer list
     */
    public KWArrayList<Customer> getCustomers() {
        return customers;
    }

    /**
     * @return branch list
     */
    public KWLinkedList<Branch> getBranches() {
        return branches;
    }

    /**
     *
     * @return employee list
     */
    public KWArrayList<BranchEmployee> getEmployee() {
        return employee;
    }

    /**
     * @return customers number in the company
     */
    public int getCustomer_number() {
        return customer_number;
    }

    /**
     * customer added or removed
     * @param customer_number
     */
    public void setCustomer_number(int customer_number) {
        this.customer_number = customer_number;
    }

    /**
     *
     * @return branches number in the company
     */
    public int getBranch_number() {
        return branch_number;
    }

    /**
     * branch added or removed
     * @param branch_number
     */
    public void setBranch_number(int branch_number) {
        this.branch_number = branch_number;
    }

    /**
     *
     * @return branches number in the company
     */
    public int getEmployee_number() {
        return employee_number;
    }

    /**
     * employee added or removed
     * @param employee_number
     */
    public void setEmployee_number(int employee_number) {
        this.employee_number = employee_number;
    }


}
