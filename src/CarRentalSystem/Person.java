
package CarRentalSystem;

/****************************************************************************
 * Author: Group 11 (K2)
 * Program Name: Person.java
 * Description: To implement Person class that can verify identity user to login
 *              the system.
 * Date: 29 May 2021
 * Modified Date: None
 * Version: 1.0
 ****************************************************************************/

public class Person {

    // Define instance variables
    private String username;
    private String password;
    
    // Define default constructor for person class
    public Person() {
        
    }
    // Define 2nd constructor for person class
    public Person (String username, String password) {
        
        setUsername(username);
        setPassword(password);
        
    }
    
    // Define setter & getter...
    public String getUsername() {
        return (this.username);
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return (this.password);
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Display login_status
    public void displayPerson() {
        System.out.printf("Username\t\t= %s \nPassword\t\t= %s", getUsername(), getPassword());
    }
    
    //display invois
    public void displayInvois() {
        System.out.printf("Username\t\t= %s ", getUsername());
    }
}
