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

public abstract class Car {
    
    //define instace variable
    private String car_model;
    private String car_type;
    private int seater;
    private Rate rate;
    
    //define default constructor
    public Car(){
        
    }
    
    //define 2nd contructor
    public Car(String car_model, String car_type, int seater, Rate rate){
        //initialize contructor
        setCar_model(car_model);
        setCar_type(car_type);
        setSeater(seater);
        setRate(rate);
    }
    
    //define setter & getter
    public String getCar_model(){
        return (this.car_model);
    }
    
    public void setCar_model(String car_model){
        this.car_model = car_model;
    }
    
    public String getCar_type(){
        return (this.car_type);
    }
    
    public void setCar_type(String car_type){
        this.car_type = car_type;
    }
    
    public int getSeater(){
        return (this.seater);
    }
    
    public void setSeater(int seater){
        this.seater = seater;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
    
    //display output  in capital letter
    @Override
    public String toString(){
        return String.format("Car Model\t\t= %s \nCar type\t\t= %s \nSeat Number\t\t= %d\n%s", getCar_model().substring(0, 1).toUpperCase() + getCar_model().substring(1), 
                getCar_type().substring(0, 1).toUpperCase() +  getCar_type().substring(1), getSeater(), getRate());
    }
}
