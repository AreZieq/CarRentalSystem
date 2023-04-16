/**
 *  ----------------------------------------------------------------
 *  @author :Group 11
 *  Program Name :Car Rental System
 *  Description  :To calculate the price.
 *  Creation Date:5/5/2021
 *  Modified date:None
 *  Version      :Version 1.00
 * ----------------------------------------------------------------
 * 
 */
package CarRentalSystem;

public class Rate {
    
    // define instance variable
    private double rate;

    public Rate(double rate) {
        this.rate = rate;
    }

    // Define setter & getter
    public void setrate(double rate) {
        this.rate = rate;
    }
    
    public double getrate(){
        return(this.rate);
    }
    
    // Utility method to confirm proper rate value
    public double checkDate(double rates){
        if (getrate() > 5.0) 
          return rates =5.0;
        else if (getrate() < 0.0)
            return rates = 0.0;
        return rates;
    }
    
    // Display output
    public String toString() {
        return String.format("%s", checkDate(rate));   
    }
}
