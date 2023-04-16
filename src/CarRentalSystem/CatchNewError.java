/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRentalSystem;

/**
 *
 * @author fakhr
 */
class CatchNewError extends Exception {
    
    public CatchNewError () {
        super ("Input number 1 to 5 only !!");
    }
    
    //error message if user input number more than 5
    public void one_five_errorMessage () {
        System.out.println("\n\nERROR !! Invalid input (Exp: 1 or 2 or 3 or 4 or 5). Try Again....");
    }
    
    //error message if user input number more than 2
    public void one_two_errorMessage () {
        System.out.println("\nERROR !! Invalid input (Exp: 1 or 2). Try Again....");
    }
    
    //error message if user input number more than 5
    public void error_CarnotAvailable () {
        System.out.println("\nCar not available!! You can choose another car.");
    }
    
    public void specialCaracter_errorMessage () {
        System.out.println("\nERROR !! Please dont use Special Character such as !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
    }
}
