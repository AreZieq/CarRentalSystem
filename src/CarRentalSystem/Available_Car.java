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

public class Available_Car extends Car {
    
    //define instance variable 
    private double price;
    private int day;

    public Available_Car(String car_model, String car_type, int seater, Rate rate, double price) {
        super(car_model, car_type, seater, rate);
        this.price = price;
    }
    public Available_Car(String car_model, String car_type, int seater, Rate rate, double price, int day) {
        super(car_model, car_type, seater, rate);
        this.price = price;
        this.day = day;
    }
    
    //define setter and getter for price
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price=price;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    public void calculateRentPrice() {
        System.out.printf("\n======================================================\n\t\t\t      "
                + "Total price =  RM %,.2f\n======================================================\n", getPrice() * getDay());
    }
    
    public void displayInvois() {
        System.out.printf("Day Rent\t\t= %d", getDay());    
    }
    
    @Override
    public String toString() {
        return String.format(super.toString()+"\nPrice perDay\t\t= RM %,.2f",getPrice());
        
    }
}
