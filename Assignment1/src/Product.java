/**
 * Products of Company
 *
 * @author Mustafa Gurler
 * @version 1.0
 *
 */

import java.util.Scanner;

public class Product implements OfficeProduct{

    private int[][] office_chair;

    private int[][] office_desk;

    private int[][] meeting_tables;

    private int[] book_cases;

    private int[] office_cabinets;


    /**
     * Constructor
     *
     */

    public Product(){

        office_chair = new int[oc_mn][oc_mc];
        office_desk = new int[od_mn][od_mc];
        meeting_tables = new int[mt_mn][mt_mc];
        book_cases = new int[bc_mn];
        office_cabinets = new int[oca_mn];

    }
    /*Product(ProductBuilder builder) {

        this.office_chair = builder.getOffice_chair();
        this.office_desk = builder.getOffice_desk();
        this.meeting_tables = builder.getMeeting_tables();
        this.office_cabinets = builder.getOffice_cabinets();
        this.book_cases = builder.getBook_cases();
    }*/

    /**
     * This method returns the product of company
     * @return String
     */
    public String toString(){
        String str = "";
        str += _display_chair();
        str += _display_desk();
        str += _display_table();
        str += _display_cases();
        str += _display_cabinet();
        return str;
    }

    /**
     * This method creates a product
     * @return Product
     * @throws IndexOutOfBoundsException
     */
    public static Product _createProduct()throws IndexOutOfBoundsException{
        int q = 1;
        int model, color = 1, amount;
        Scanner input = new Scanner(System.in);
        Product product = new Product();
        System.out.println(Company.branches[0].toString());
        System.out.print("What do you want to look?\n");
        while(q != 6){
            System.out.println("1-)OfficeChair");
            System.out.println("2-)OfficeDesk");
            System.out.println("3-)MeetingTables");
            System.out.println("4-)BookCases");
            System.out.println("5-)OfficeCabinet");
            System.out.println("6-)Exit");
            q = input.nextInt();
            input.nextLine();
            if(q == 6){
                return product;
            }
            System.out.print("Model:");
            model = input.nextInt();
            if(q == 1 || q == 2 || q == 3){
                System.out.print("Color:");
                color = input.nextInt();
            }
            System.out.println("How much?");
            amount = input.nextInt();
            switch(q) {
                case 1:
                    product.office_chair[model-1][color-1] += amount;
                    break;
                case 2:
                    product.office_desk[model-1][color-1] += amount;
                    break;
                case 3:
                    product.meeting_tables[model-1][color-1] += amount;
                    break;
                case 4:
                    product.book_cases[model-1] += amount;
                    break;
                case 5:
                    product.office_cabinets[model-1] += amount;
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
        return product;
    }

    /**
     * This methods adds to new Product to selected customer
     * @param product
     * @return null
     */
    public void _update(Product product){
        setOffice_desk(product.office_desk);
        setBook_cases(product.book_cases);
        setMeeting_tables(product.meeting_tables);
        setOffice_cabinets(product.office_cabinets);
        setOffice_chair(product.office_chair);
    }

    /**
     * This methods substract to product from selected customer
     * @param product
     * @return boolean
     */
    public boolean _reverseUpdate(Product product){
        if(!_check_product(product)){
            return false;
        }
        setOffice_deskMinus(product.office_desk);
        setBook_casesMinus(product.book_cases);
        setMeeting_tablesMinus(product.meeting_tables);
        setOffice_cabinetsMinus(product.office_cabinets);
        setOffice_chairMinus(product.office_chair);
        return true;
    }

    /**
     * This method scans the selected branches product and if there are products enough return true
     * @param product
     * @return boolean
     */
    public boolean _check_product(Product product){
        for(int i=0 ; i<oc_mn ; i++){
            for(int j=0 ; j<oc_mc ; j++){
                if(this.office_chair[i][j] < product.office_chair[i][j]){
                    return false;
                }
            }
        }
        for(int i=0 ; i<od_mn ; i++){
            for(int j=0 ; j<od_mc ; j++){
                if(this.office_desk[i][j] < office_desk[i][j]){
                    return false;
                }
            }
        }
        for(int i=0 ; i<mt_mn ; i++){
            for(int j=0 ; j<mt_mc ; j++){
                if(this.meeting_tables[i][j] < meeting_tables[i][j]){
                    return false;
                }
            }
        }
        for(int i=0 ; i<bc_mn ; i++){
            if(this.book_cases[i] < book_cases[i]){
                return false;
            }
        }
        for(int i=0 ; i<oca_mn ; i++){
            if(this.office_cabinets[i] < office_cabinets[i]){
                return false;
            }
        }
        return true;
    }


    public int[][] getOffice_chair() {
        return office_chair;
    }

    /**
     * This method adds to product as default 1
     */
    public void setOffice_chair() {
        for(int i=0 ; i<oc_mn ; i++){
            for(int j=0 ; j<oc_mc ; j++){
                this.office_chair[i][j] = 1;
            }
        }

    }

    /**
     * This method updates the current product
     * @param office_chair
     * @return null
     */
    public void setOffice_chair(int[][] office_chair) {
        for(int i=0 ; i<oc_mn ; i++){
            for(int j=0 ; j<oc_mc ; j++){
                this.office_chair[i][j] += office_chair[i][j];
            }
        }

    }

    /**
     * This method subtract the the current product from given product
     * @param office_chair
     * @return boolean
     */
    public boolean setOffice_chairMinus(int[][] office_chair) {
        for(int i=0 ; i<oc_mn ; i++){
            for(int j=0 ; j<oc_mc ; j++){
                if(this.office_chair[i][j] < office_chair[i][j]){
                    return false;
                }
                this.office_chair[i][j] -= office_chair[i][j];
            }
        }
        return true;
    }
    public int[][] getOffice_desk() {
        return office_desk;
    }
    /**
     * This method adds to product as default 1
     */
    public void setOffice_desk() {
        for(int i=0 ; i<od_mn ; i++){
            for(int j=0 ; j<od_mc ; j++){
                this.office_desk[i][j] = 1;
            }
        }
    }
    /**
     * This method updates the current product
     * @param office_desk
     * @return null
     */
    public void setOffice_desk(int[][] office_desk) {
        for(int i=0 ; i<od_mn ; i++){
            for(int j=0 ; j<od_mc ; j++){
                this.office_desk[i][j] += office_desk[i][j];
            }
        }
    }

    /**
     * This method subtract the the current product from given product
     * @param office_desk
     * @return null
     */
    public void setOffice_deskMinus(int[][] office_desk) {
        for(int i=0 ; i<od_mn ; i++){
            for(int j=0 ; j<od_mc ; j++){
                this.office_desk[i][j] -= office_desk[i][j];
            }
        }
    }
    public int[][] getMeeting_tables() {
        return meeting_tables;
    }
    /**
     * This method adds to product as default 1
     */
    public void setMeeting_tables() {
        for(int i=0 ; i<mt_mn ; i++){
            for(int j=0 ; j<mt_mc ; j++){
                this.meeting_tables[i][j] = 1;
            }
        }
    }
    public void setMeeting_tables(int[][] meeting_tables) {
        for(int i=0 ; i<mt_mn ; i++){
            for(int j=0 ; j<mt_mc ; j++){
                this.meeting_tables[i][j] += meeting_tables[i][j];
            }
        }
    }

    /**
     * This method updates the current product
     * @param meeting_tables
     */
    public void setMeeting_tablesMinus(int[][] meeting_tables) {
        for(int i=0 ; i<mt_mn ; i++){
            for(int j=0 ; j<mt_mc ; j++){
                this.meeting_tables[i][j] -= meeting_tables[i][j];
            }
        }
    }
    public int[] getBook_cases() {
        return book_cases;
    }
    public void setBook_cases() {
        for(int i=0 ; i<oc_mn ; i++){
            this.book_cases[i] = 1;
        }
    }
    public void setBook_cases(int[] book_cases) {
        for(int i=0 ; i<oc_mn ; i++){
            this.book_cases[i] += book_cases[i];
        }
    }
    public void setBook_casesMinus(int[] book_cases) {
        for(int i=0 ; i<oc_mn ; i++){
            this.book_cases[i] -= book_cases[i];
        }
    }
    public int[] getOffice_cabinets() {
        return office_cabinets;
    }
    public void setOffice_cabinets() {
        for(int i=0 ; i<oc_mn ; i++){
            this.office_cabinets[i] = 1;
        }
    }
    public void setOffice_cabinets(int[] office_cabinets) {
        for(int i=0 ; i<oc_mn ; i++){
            this.office_cabinets[i] += office_cabinets[i];
        }
    }
    public void setOffice_cabinetsMinus(int[] office_cabinets) {
        for(int i=0 ; i<oc_mn ; i++){
            this.office_cabinets[i] -= office_cabinets[i];
        }
    }

    public String _display_chair(){
        String str = "Office Chair:\n";
        for(int i=0 ; i<oc_mn ; i++){
            str += Integer.toString(i + 1);
            str += "st Model:";
            for(int j=0 ; j<oc_mc ; j++){
                if(office_chair[i][j] > 0) {
                    str += Integer.toString(j + 1);
                    str += "st Color:";
                    str += Integer.toString(office_chair[i][j]) + " ";
                }
            }
            str += "\n";
        }
        return str;
    }
    public String _display_desk(){
        String str = "Office Desk:\n";
        for(int i=0 ; i<od_mn ; i++){

            for(int j=0 ; j<od_mc ; j++){
                str += Integer.toString(i + 1);
                str += "st Model:";
                if(office_desk[i][j] > 0) {
                    str += Integer.toString(j + 1);
                    str += "st Color:";
                    str += Integer.toString(office_desk[i][j]) + " ";
                }
            }
            str += "\n";
        }
        return str;
    }
    public String _display_table(){
        String str = "Meeting Table:\n";
        for(int i=0 ; i<mt_mn ; i++) {
            str += Integer.toString(i + 1);
            str += "st Model:";
            for (int j = 0; j < mt_mc; j++) {
               if(meeting_tables[i][j] > 0) {
                   str += Integer.toString(j + 1);
                   str += "st Color:";
                   str += Integer.toString(meeting_tables[i][j] ) + " ";
               }
            }
            str += "\n";
        }
        return str;
    }
    public String _display_cases() {
        String str = "Book Cases:\n";
        for(int i=0 ; i<bc_mn ; i++) {
            if (book_cases[i] > 0) {
                str += Integer.toString(i + 1) + "st Model:";
                str += Integer.toString(book_cases[i] ) + "\n";

            }
        }
        return str;
    }
    public String _display_cabinet(){
        String str = "Office Cabinet:\n";
        for(int i=0 ; i<bc_mn ; i++){
           if(office_cabinets[i] > 0) {
               str += Integer.toString(i + 1) + "st Model:";
               str += Integer.toString(office_cabinets[i]) + "\n";
           }
        }
        return str;
    }
}
