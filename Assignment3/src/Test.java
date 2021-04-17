/**
 *
 * Driver file for my Automation System program and interactive menu
 *
 * @author Mustafa gurler
 * @version 1.0
 *
 ***/

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Test {



    public static void main(String[] args){



        /****************************Product Class ****************************/

        Product product = new Product();
        Product product1 = new Product(3,2, 30, 1);
        Product product2 = new Product(3,3,50,2);
        Product product3 = new Product(2,1,4,3);
        System.out.print(product.toString(product1.getChoice(),product1));
        System.out.print(product.toString(product2.getChoice(),product2));
        System.out.print(product.toString(product3.getChoice(),product3));

        if(product.add(product1.getChoice(), product1) == true){
            System.out.println("Add method has passed");
        }else{
            System.out.println("Add method did not work");
        }

        if(product.check(product2.getChoice(), product2) == false){
            System.out.println("Check method has passed");
        }else{
            System.out.println("Check method did not work");
        }
        product.add(product2.getChoice(), product2);
        if(product.check(product1.getChoice(), product2) == true){
            System.out.println("Check method has passed");
        }else{
            System.out.println("Check method did not work");
        }

        product.add(product1.getChoice(),product1);
        System.out.println("Previous Method==>" + product.previous(product1.getChoice(),3,2));// two times product has been added

        product.removeLast();
        System.out.println("Remove Last element method" + product.previous(product1.getChoice(),3,2));


        for(int i=0 ; i<20 ; i++){
            product.add(product1.getChoice(),product1);
        }
        Product product4 = new Product(3,2, 253, 1);
        System.out.println("Added element" + product.previous(product4.getChoice(), 3,2));
        product.remove(product4.getChoice(),product4);

        /***********************************Administrator Class*******************************/
        Company company = new Company();

        Administrator admin = new Administrator("mustafa", "Gurler");

        company.setAdmin(admin);

        Branch branch = new Branch("Konya", "10101010");
        Branch branch2 = new Branch("Istanbul", "10101001");
        Branch branch3 = new Branch("Bursa", "10101010");
        Branch branch4 = new Branch("Sinop", "10101010");
        Branch branch5 = new Branch("Ankara", "10101010");

        admin._addBranch(company, branch);
        admin._addBranch(company, branch2);
        admin._addBranch(company, branch3);
        admin._addBranch(company, branch4);
        admin._addBranch(company, branch5);

        System.out.println();
        System.out.println();

        System.out.println(admin._removeBranch(company, branch) + " removed");
        System.out.println(admin._removeBranch(company, branch3) + " removed");

        System.out.println();
        System.out.println();

        BranchEmployee employee1 = new BranchEmployee("can","duyar","101010");
        BranchEmployee employee2 = new BranchEmployee("canberk","arici","111010");
        BranchEmployee employee3 = new BranchEmployee("muhammed","kartal","111010");
        BranchEmployee employee4 = new BranchEmployee("tuncay","coskun","101111");

        admin._addBEmployee(company, employee1 );
        admin._addBEmployee(company, employee2 );
        admin._addBEmployee(company, employee3 );
        admin._addBEmployee(company, employee4 );

        System.out.println();
        System.out.println();

        admin._removeBEmployee(company, employee2);
        admin._removeBEmployee(company, employee1);
        BranchEmployee employee5 = new BranchEmployee("mustafa","gurler","101100");
        admin._removeBEmployee(company, employee5);

        System.out.println();
        System.out.println();
        admin._addProduct(company, branch5, product, product.getChoice());

        System.out.println();
        System.out.println();

        for(int i=0 ; i< 12 ; i++){
            admin._addProduct(company, branch2, product1, product1.getChoice());
        }
        System.out.println(branch2.getProducts().previous(product1.getChoice(), product1.getX(),product1.getY()));
        System.out.println();
        admin._addProduct(company, branch, product1, product1.getChoice());
        System.out.println();
        System.out.println();


        Product product6 = new Product(3,2, 75, 1);
        System.out.println(branch2.getProducts().previous(product1.getChoice(), product1.getX(),product1.getY()));
        admin._removeProduct(company, branch2, product6, product6.getChoice());
        System.out.println(branch2.getProducts().previous(product1.getChoice(), product1.getX(),product1.getY()));

        System.out.println();
        System.out.println();

        Customer customer = new Customer("Cristiano","Ronaldo","ronaldo@gmail.com","10100101");
        Customer customer1 = new Customer("Lionel","Messi","messi@gmail.com","1011111");
        Customer customer2 = new Customer("KevinDe","Bruyne","bruyne@gmail.com","10101101");
        Customer customer3 = new Customer("Zlatan","Ibrahimovic","ronaldo@gmail.com","11110101");
        Customer customer4 = new Customer("Sergio","Aguero","aguero@gmail.com","11110100");

        employee2._newSubscripton(company, customer);
        employee2._newSubscripton(company, customer1);
        employee2._newSubscripton(company, customer2);
        employee2._newSubscripton(company, customer3);

        System.out.println();
        System.out.println();

        if(employee2._updatePreviousOrder(company, customer1, product6, product6.getChoice()) == true){
            System.out.println("Previous order update passed");
        }else{
            System.out.println("Previous order update not passed");
        }

        if(employee2._updatePreviousOrder(company, customer4, product6, product6.getChoice()) == true){
            System.out.println("Previous order update passed");
        }else{
            System.out.println("Previous order update not passed");
        }
        System.out.println();
        System.out.println();


        for(int i = 0; i < 10 ; i++){
            employee2._updatePreviousOrder(company, customer1, product6, product6.getChoice());
        }
        System.out.println(employee2._accessPreviousOrder(company, customer1,product6.getChoice(), 3, 2));

        for(int i = 0; i < 3 ; i++){
            employee2._removeOrder(company, customer1);
        }
        System.out.println("Removing last order ==> " +  employee2._accessPreviousOrder(company, customer1,product6.getChoice(), 3, 2));

        System.out.println();
        System.out.println();

        for(int i = 0; i < 5 ; i++){
            admin._addProduct(company,branch2, product6, product6.getChoice());
        }


        if(employee2._searchProduct(company, branch2, product6, product6.getChoice()) == true){
            System.out.println("Product has been found");
        }else{
            System.out.println("Product has been not found");
        }
        if(employee2._searchProduct(company, branch4, product4, product4.getChoice()) == true){
            System.out.println("Product has been found");
        }else{
            System.out.println("Product has been not found");
        }
        System.out.println();
        System.out.println();


        System.out.println(employee2.toString());

        System.out.println();
        System.out.println();
        System.out.println("****First Customer Order");
        if(customer._order(company, branch2, product6) == true){
            System.out.println("Customer order has been added");
        }else{
            System.out.println("Customer order has not been added");
        }
        System.out.println("****Second Customer Order");
        if(customer._order(company, branch, product6) == true){
            System.out.println("Customer order has been added");
        }else{
            System.out.println("Customer order has not been added");
        }
        System.out.println("****Third Customer Order");
        Product product7 = new Product(2,3,1000,2);
        if(customer._order(company, branch2, product7) == true){
            System.out.println("Customer order has been added");
        }else{
            System.out.println("Customer order has not been added");
        }


        System.out.println();
        System.out.println();

        System.out.println(customer._previousOrder(company,product6.getX(), product6.getY(),product6.getChoice()));

        System.out.println();
        System.out.println();
        System.out.println("****First Product search");
        if(customer._searchProduct(company, branch2, product6)){
            System.out.println("Product has been found");
        }else{
            System.out.println("Product has been not found");
        }
        System.out.println("****Second Product Search");
        if(customer._searchProduct(company, branch, product6)){
            System.out.println("Product has been found");
        }else{
            System.out.println("Product has been not found");
        }
        System.out.println("****Third Product Search");
        if(customer._searchProduct(company, branch2, product7)){
            System.out.println("Product has been found");
        }else{
            System.out.println("Product has been not found");
        }



        //  System.out.println(product.toString());

      //  System.out.println(product.toString(true));

    }

}
