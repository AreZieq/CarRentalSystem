
package CarRentalSystem;

/****************************************************************************
 * Author: Group 11 (K2)
 * Program Name: Employee.java
 * Description: To implement Employee class that can get the information of the
 *              employee.
 * Date: 29 May 2021
 * Modified Date: None
 * Version: 1.0
 ****************************************************************************/

public class Employee extends Person {

    // Define instance variables
    private String Employee_name;
    private long Phone_number;
    
    // Define default constructor for employee class
    public Employee(String username, String password,  String Employee_name,  long Phone_number) {
         super(username,password); 
         setEmployee_name(Employee_name);
         setPhone_no(Phone_number);
      }

    // Define setter & getter...
    public String getEmployee_name() {
        return (this.Employee_name);
    }
    
    public void setEmployee_name(String Employee_name) {
        this.Employee_name = Employee_name;
    }
    
    public long getPhone_no() {
        return (this.Phone_number);
    }
    
    public void setPhone_no(long Phone_number) {
        this.Phone_number = Phone_number;
    }
   
    // Display employee information in capital letter
    public void displayEmployee() {
        super.displayPerson();
        System.out.printf("\nName\t\t\t= %s \nPhone Number\t\t= %d\n", getEmployee_name().substring(0, 1).toUpperCase() + getEmployee_name().substring(1), getPhone_no());
    }
    
}
