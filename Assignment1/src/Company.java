/**
 * Company class which controls the all classes
 * @author Mustafa Gurler
 * @version
 */

import java.util.Scanner;

public class Company implements CompanyInformation{

    protected static Customer[] customers = new Customer[100];

    protected static Branch[] branches = new Branch[100];

    protected static BranchEmployee[] employee = new BranchEmployee[100];


    protected static Administrator admin;

    private static int customer_number = c_number;
    private static int branch_number = b_number;
    private static int employee_number = e_number;

    public static Customer[] getCustomers() {
        return customers;
    }

    public static void setCustomers(Customer[] customers) {
        Company.customers = customers;
    }

    public static Branch[] getBranches() {
        return Company.branches;
    }

    public static void setBranches(Branch[] branches) {
        Company.branches = branches;
    }

    /**
     * This method finds the specific branch employee
     * @return Integer
     */
    public static int getBranchEmployee(){

        if (Company.getEmployee_number() == 0) {
            System.out.println("There is no Employee");
            System.out.println("****************************");
        }
        for (int i = 0; i < Company.getEmployee_number(); i++) {
            System.out.println((i+1) + ".employee");
            System.out.println(Company.getEmployee()[i].toString());
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Which Employee?");
        int choice =  input.nextInt();
        return choice;
    }
    public static BranchEmployee[] getEmployee() {
        return Company.employee;
    }

    public static void setEmployee(BranchEmployee[] employee) {
        Company.employee = employee;
    }

    public static void setAdmin(Administrator admin) {
        Company.admin = admin;
    }

    public static Administrator getAdmin() {
        return admin;
    }

    public Company(){



    }

    public static int getEmployee_number() {
        return employee_number;
    }

    public static void setEmployee_number(int employee_number) {
        Company.employee_number = employee_number;
    }

    public static void setCustomer_number(int customer_number) {
        Company.customer_number = customer_number;
    }

    public static void setBranch_number(int branch_number) {
        Company.branch_number = branch_number;
    }

    public static int getCustomer_number() {
        return customer_number;
    }
    public static int getBranch_number() {
        return branch_number;
    }

    /**
     * This method shows the Company name, id and returns string
     * @return String
     */
    public String toString(){
        String str = "";
        int count = 1;
        if(getBranch_number() == 0) {
            str = "There is no branch\n";
            str += "****************************";
        }
        for(int i=0 ; i<getBranch_number() ; i++){
                str += "***********************************\n";
                str += Integer.toString(count) + "-)Branch Name\n";
                str += getBranches()[i].getBranchID() + "\n";
                str += getBranches()[i].getName() + "\n";
                count++;
        }
        return str;
    }

   /* public static void _set_capacity_employee()throws CloneNotSupportedException{
        if(Company.getEmployee().length <= Company.getEmployee_number()){
            BranchEmployee[] newEmployee = new BranchEmployee[Company.getEmployee_number()+4];
            for(int i=0 ; i < Company.getEmployee_number() ; i++){
                newEmployee[i] = (BranchEmployee) Company.getEmployee()[i].clone();
            }
            Company.setEmployee(newEmployee);

        }
        Company.setEmployee_number(Company.getEmployee_number()+1);

    }

   /* public static void _set_capacity_branch()throws CloneNotSupportedException{
        if(Company.getBranches().length <= Company.getBranch_number()){
            Branch[] newBranch = new Branch[Company.getBranches().length+4];
            for(int i=0 ; i < Company.getBranch_number() ; i++){
                newBranch[i] = (Branch) Company.getBranches()[i].clone();
            }
            Company.setBranches(newBranch);

        }
        Company.setBranch_number(Company.getBranch_number()+1);
    }
    public static void _set_capacity_customer()throws CloneNotSupportedException{
        if(Company.getCustomers().length <= getCustomer_number()){
            Customer[] newCustomer = new Customer[Company.getCustomers().length+4];
            for(int i=0 ; i < Company.getCustomer_number() ; i++){
                newCustomer[i] = (Customer)Company.getCustomers()[i].clone();
            }
            Company.setCustomers(newCustomer);

        }
        Company.setCustomer(Company.getCustomer_number()+1);
    }*/

}
