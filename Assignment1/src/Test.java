/**
 *
 * Driver file for my Automation System program and interactive menu
 *
 * @author Mustafa gurler
 * @version 1.0
 *
 ***/

import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        Administrator admin = new Administrator("Mustafa", "Gurler");
        Company.setAdmin(admin);

        /*
         *Adding branch to Company class
         */
        Company.getAdmin()._addBranch("Konya", "110101");
        Company.getAdmin()._addBranch("Bursa", "101010");
        Company.getAdmin()._addBranch("Berlin", "101010");
        Company.getAdmin()._addBranch("Istanbul", "121010");

        Company.getAdmin()._removeBranch(Company.getBranches()[0]);

        for(int i=0 ; i<Company.getBranch_number() ; i++){
            System.out.println(Company.getBranches()[i].toString());
        }

        /**
         * adding three employee and remove two of them
         */
        Company.getAdmin()._addBEmployee("Adis", "Jahovic","1201");
        Company.getAdmin()._addBEmployee("Mustafa", "Mohammed","1221");
        Company.getAdmin()._addBEmployee("Edin", "Dzeko","1201");
        Company.getAdmin()._addBEmployee("Omer Ali", "Sahiner","1244");

        Company.getAdmin()._removeBEmployee(Company.getEmployee()[0]);
        Company.getAdmin()._removeBEmployee(Company.getEmployee()[1]);

        for(int i=0 ; i<Company.getEmployee_number() ; i++){
            System.out.println(Company.getEmployee()[i].toString());
        }

        /**
        * Automatically addes 1 every product
         */
        Product newProduct = new Product();
        Company.getAdmin()._addProduct(Company.getBranches()[1], newProduct);
        System.out.println(Company.getBranches()[1].getProducts().toString());
        /**
        * inquire products if it is available
         */
        System.out.println(Company.getAdmin()._inquireProduct(Company.getBranches()[1],newProduct));

        Company.getEmployee()[0]._newSubscripton(new Customer("Mesut","Ozil","10100101"));
        Company.getEmployee()[0]._newSubscripton(new Customer("Cenk","Ahmet","11110110"));
        for(int i=0 ; i<Company.getCustomer_number() ; i++){
            System.out.println(Company.getCustomers()[i].toString());
        }
        /**
        * Ordering office desk, meeting tables, office chair for every model and color
        * but it does not ordering any book cases and office cabinet
         */
        newProduct.setOffice_desk();
        newProduct.setMeeting_tables();
        newProduct.setOffice_chair();
        Company.getCustomers()[0]._order(newProduct);
        Company.getCustomers()[0]._order(newProduct);
        Company.getCustomers()[0]._previousOrder();

        Company.getEmployee()[1]._removeOrder(Company.getCustomers()[0]);

        /**
         * Gets previous order for specific customer
         */
        System.out.println(Company.getCustomers()[0].getProducts().toString());
        Company.getCustomers()[0]._previousOrder();

        /**
         * Inquire product for specific product
         */
        try {
            if (Company.getEmployee()[Company.getBranchEmployee()]._inquireStock(Company.getBranches()[0], newProduct)) {
                System.out.println("Products are available");
            }else{
                System.out.println("Products are not available in this branch");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("There is no kind of model and color");
        }

        /**
         * Make sales to selected customer. Default customer=>first customer
         */
        System.out.println(Company.getCustomers()[0].getProducts().toString());
        Company.getEmployee()[0]._makeSales(Company.getBranches()[0],Company.getCustomers()[0], newProduct );
        System.out.println(Company.getCustomers()[0].getProducts().toString());


    }

    /**
     * Interactive menu for Automation system
     */
    public static void menu(){
        Company company = new Company();


        System.out.println("********************************");
        System.out.println("    Automation System Menu  ");

        Administrator admin = new Administrator("Mustafa", "Gurler");

        Company.setAdmin(admin);
        Scanner input = new Scanner(System.in);
        /**
         * choice for switch case
         * Default product
         * Default branch employee. They are going to be changed in the future
         * exit variable for while loop
         * name, id, surname for admin, employee, customer
         */
        int choice = 20;
        Product product;
        BranchEmployee employee;
        boolean exit = true;
        String name, id, surname;
        int number;
        /**
         * Beginning of menu
         */
        while(exit){
            System.out.println("1-)Admin");
            System.out.println("2-)Branch Employee");
            System.out.println("3-)Customer");
            System.out.println("4-)Exit");
            try {
                choice = input.nextInt();
            }
            catch(Exception e) {
                System.out.println("Enter integer value!!");
                input.nextLine();
                break;
            }
            switch (choice){
                case 1:
                    while(true){
                        System.out.println("1-)Add a branch");
                        System.out.println("2-)Remove a branch");
                        System.out.println("3-)Add branch employee");
                        System.out.println("4-)Remove branch employee");
                        System.out.println("5-)Add Product");
                        System.out.println("6-)Inquire Product");
                        System.out.println("7-)Back to main menu");
                        try {
                            choice = input.nextInt();
                        }
                        catch(Exception e) {
                            System.out.println("Enter integer value!!");
                            input.nextLine();
                            choice = 20;

                        }
                        switch (choice) {
                            case 1:
                                System.out.print("Branch name:");
                                name = input.nextLine();
                                System.out.print("Branch ID:");
                                id = input.nextLine();
                                try {
                                    Company.getAdmin()._addBranch(name, id);
                                }catch (Exception e){
                                    System.out.println("Clone method does not work");
                                }
                                break;
                            case 2:
                                if (Company.getBranch_number() == 0) {
                                    System.out.println("There is no branch to remove");
                                    System.out.println("****************************");
                                    break;
                                }
                                for (int i = 0; i < Company.getBranch_number(); i++) {
                                    System.out.println((i+1) + ".Branch");
                                    System.out.println(Company.getBranches()[i].toString());
                                }
                                System.out.println("Which branch to remove?:");
                                number = input.nextInt();
                                try {
                                    Company.getAdmin()._removeBranch(Company.getBranches()[number - 1]);
                                }catch (Exception e){
                                    System.out.println("Clone method does not work");
                                }

                                break;
                            case 3:
                                System.out.print("Employee name:");
                                name = input.nextLine();
                                System.out.print("Employee surname:");
                                surname = input.nextLine();
                                System.out.print("Employee id:");
                                id = input.nextLine();

                                Company.getAdmin()._addBEmployee(name, surname, id);


                                break;
                            case 4:
                                if (Company.getEmployee_number() == 0) {
                                    System.out.println("There is no employee to remove");
                                    System.out.println("****************************");
                                    break;
                                }
                                for (int i = 0; i < Company.getEmployee_number(); i++) {
                                    System.out.println((i+1) + ".employee");
                                    System.out.println(Company.getEmployee()[i].toString());
                                }
                                System.out.println("Which employee to remove?:");
                                number = input.nextInt();
                                Company.getAdmin()._removeBEmployee(Company.getEmployee()[number - 1]);
                                break;
                            case 5:
                                if(Company.getBranch_number() == 0){
                                    System.out.println("There is no branch");
                                    System.out.println("***************************");
                                    break;
                                }
                                for (int i = 0; i < Company.getBranch_number(); i++) {
                                    System.out.println((i+1) + ".Branch");
                                    System.out.println(Company.getBranches()[i].toString());
                                }
                                System.out.println("Which branch to add product:");
                                number = input.nextInt();
                                product = Product._createProduct();
                                Company.getAdmin()._addProduct(Company.getBranches()[number - 1], product);
                                break;
                            case 6:
                                if(Company.getBranch_number() == 0){
                                    System.out.println("There is no branch to inquire");
                                    break;
                                }
                                for (int i = 0; i < Company.getBranch_number(); i++) {
                                    System.out.println((i+1) + ".Branch");
                                }
                                System.out.println("Which branch to inquire product:");
                                number = input.nextInt();

                                try {
                                    product = Product._createProduct();
                                    if (Company.getAdmin()._inquireProduct(Company.getBranches()[number - 1], product)) {
                                        System.out.println("Products are available");
                                    }else{
                                        System.out.println("Products are not available in this branch");
                                    }
                                }catch(ArrayIndexOutOfBoundsException e){
                                    System.out.println("There is no kind of model and color");
                                }
                                catch(Exception e){
                                    System.out.println("There is no branch to inquire");
                                }
                                break;
                        }
                        break;
                    }
                    break;
                case 2:
                    while(true){
                        System.out.println("1-)Access previous order");
                        System.out.println("2-)Remove order");
                        System.out.println("3-)Inquire Stock");
                        System.out.println("5-)Search Product");
                        try {
                            choice = input.nextInt();
                        }
                        catch(Exception e) {
                            System.out.println("Enter integer value!!");
                            input.nextLine();
                            choice = 20;
                        }
                        switch (choice){
                            case 1:
                                if (Company.getCustomer_number() == 0) {
                                    System.out.println("There is no customer previous");
                                    System.out.println("****************************");
                                    break;
                                }
                                for (int i = 0; i < Company.getCustomer_number(); i++) {
                                    System.out.println((i+1) + ".customer");
                                    System.out.println(Company.getCustomers()[i].toString());
                                }
                                System.out.println("Which customer's previous order?:");
                                number = input.nextInt();
                                Company.getCustomers()[number-1]._previousOrder();
                                break;
                            case 2:
                                if (Company.getCustomer_number() == 0) {
                                    System.out.println("There is no customer previous");
                                    System.out.println("****************************");
                                    break;
                                }
                                for (int i = 0; i < Company.getCustomer_number(); i++) {
                                    System.out.println((i+1) + ".customer");
                                    System.out.println(Company.getCustomers()[i].toString());
                                }
                                System.out.println("Which customer's previous order?:");
                                number = input.nextInt();
                                Company.getEmployee()[Company.getBranchEmployee()]._removeOrder(Company.getCustomers()[number-1]);
                                break;
                            case 3:
                            case 4:
                                if(Company.getBranch_number() == 0){
                                    System.out.println("There is no branch to inquire");
                                    break;
                                }
                                for (int i = 0; i < Company.getBranch_number(); i++) {
                                    System.out.println((i+1) + ".Branch");
                                }
                                System.out.println("Which branch to inquire product:");
                                number = input.nextInt();


                                try {
                                    product = Product._createProduct();
                                    if (Company.getEmployee()[Company.getBranchEmployee()]._inquireStock(Company.getBranches()[number - 1], product)) {
                                        System.out.println("Products are available");
                                    }else{
                                        System.out.println("Products are not available in this branch");
                                    }
                                }catch(ArrayIndexOutOfBoundsException e){
                                    System.out.println("There is no kind of model and color");
                                }
                                catch(Exception e){
                                    System.out.println("There is no branch to inquire");
                                }

                                break;

                        }
                        break;
                    }
                    break;
                case 3:
                    while(true){
                        System.out.println("1-)New Subscription");
                        System.out.println("2-)Order Product");
                        System.out.println("3-)Access previous order");

                        try {
                            choice = input.nextInt();
                        }
                        catch(Exception e) {
                            System.out.println("Enter integer value!!");
                            input.nextLine();
                            choice = 20;
                        }
                        switch (choice){
                            case 1:
                                System.out.print("Name:");
                                name = input.nextLine();
                                System.out.print("Surname:");
                                surname = input.nextLine();
                                System.out.print("ID:");
                                id = input.nextLine();
                                if (Company.getEmployee_number() == 0) {
                                    System.out.println("There is no employee");
                                    System.out.println("****************************");
                                    break;
                                }
                                for (int i = 0; i < Company.getEmployee_number(); i++) {
                                    System.out.println((i+1) + ".employee");
                                    System.out.println(Company.getEmployee()[i].toString());
                                }
                                System.out.println("Which employee?:");
                                number = input.nextInt();

                                Company.getEmployee()[number-1]._newSubscripton(new Customer(name,surname,id));


                                break;
                            case 2:
                                if (Company.getCustomer_number() == 0) {
                                    System.out.println("There is no customer");
                                    System.out.println("****************************");
                                    break;
                                }
                                for (int i = 0; i < Company.getCustomer_number(); i++) {
                                    System.out.println((i+1) + ".customer");
                                    System.out.println(Company.getCustomers()[i].toString());
                                }

                                System.out.println("Which customer's order?:");
                                number = input.nextInt();
                                Product pr = Product._createProduct();
                                Company.getCustomers()[number-1]._order(pr);
                                break;
                            case 3:
                                if (Company.getCustomer_number() == 0) {
                                    System.out.println("There is no customer previous");
                                    System.out.println("****************************");
                                    break;
                                }
                                if (Company.getCustomer_number() == 0) {
                                    break;
                                }
                                for (int i = 0; i < Company.getCustomer_number(); i++) {
                                    System.out.println((i+1) + ".customer");
                                    System.out.println(Company.getCustomers()[i].toString());
                                }
                                System.out.println("Which customer's previous order?:");
                                number = input.nextInt();
                                Company.getCustomers()[number-1]._previousOrder();

                                break;
                        }
                        break;
                    }
                    break;

                case 4:
                    exit = false;
                    break;

                default:
                    System.out.println("Wrong choice!!!!");
                    break;
            }
        }
    }

}
