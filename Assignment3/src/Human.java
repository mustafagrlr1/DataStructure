
/**
 *
 * Human interface getter and setter for name and surname
*
*   @author Mustafa Gurler
*
*
 */
public abstract class Human {

    String name;
    String surname;

    /**
     * Human constructor
     * @param name
     * @param surname
     */
    public Human(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    /**
     *
     * @return name and surname about human
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Name:").append(name).append("\n");
        str.append("Surname:").append(surname).append("\n");
        return str.toString();
    }

    /**
     * name could be changed
     * @param name
     */
    public void setName(String name){this.name = name;}

    /**
     * surname could be changed
     * @param surname
     */
    public void setSurname(String surname){this.name = name;}

    /**
     * @return name of human
     */
    public String getName(){return name;}

    /**
     * @return surname of product
     */
    public String getSurname(){return surname;}
    
}
