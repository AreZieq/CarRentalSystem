/**
 *  ----------------------------------------------------------------
 *  @author :Group 11
 *  Program Name :Car Rental System
 *  Description  :To calculate the price.
 *  Creation Date:29/5/2021
 *  Modified date:None
 *  Version      :Version 1.00
 * ----------------------------------------------------------------
 * 
 */
package CarRentalSystem;

public class Costumer extends Person  {
    
    //define instance variable 
    private String costumer_name;
    private long phone_number;
    private long lisense_no;
    
    
    //define constructor
    public Costumer(String username, String password,String name, long phone_no, long lisense){
        super(username,password);
        //initialize constructor
        setCostumer_name(name);
        setPhone_number(phone_no);
        setLisense_no(lisense);
    }
    
    //define setter & getter
    public String getCostumer_name(){
        return (this.costumer_name);
    }
    
    public void setCostumer_name(String costumer_name){
        this.costumer_name = costumer_name;
    }
    
    public long getPhone_number(){
        return (this.phone_number);
    }
    
    public void setPhone_number(long phone_number){
        this.phone_number = phone_number;
    }
    
    public long getLisense_no(){
        return (this.lisense_no);
    }
    
    public void setLisense_no(long lisense_no){
        this.lisense_no = lisense_no;
    }

    //display customer  in capital letter
    public void displayCustomer(){
        super.displayPerson();
        System.out.printf("\nDriver Name\t\t= %s \nDiver Phone Number\t= %d \nDriver Lisense Number\t= %d\n", getCostumer_name().substring(0, 1).toUpperCase() 
                + getCostumer_name().substring(1), getPhone_number(), getLisense_no());   
    }
    
    //display invois  in capital letter
    public void displayInvoisCustomer(){
        super.displayInvois();
        System.out.printf("\nDriver Name\t\t= %s \nDiver Phone Number\t= %d \nDriver Lisense Number\t= %d\n", getCostumer_name().substring(0, 1).toUpperCase() 
                + getCostumer_name().substring(1), getPhone_number(), getLisense_no());   
    }
}
