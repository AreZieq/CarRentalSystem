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

public class Issued_Car extends Car {
    
    private String damage_info;
    private double cost_repair;

    public Issued_Car(String car_model, String car_type, int seater, Rate rate, String damage_info, double cost_repair) {
        super(car_model, car_type, seater, rate);
        this.damage_info = damage_info;
        this.cost_repair = cost_repair;
    }

    //define setter and getter for damage info
    public String getDamage_info(){
        return damage_info;
    }
    
    public void setDamage_info(String damage_info){
        this.damage_info=damage_info;
    }
   
    public double getCost_repair(){
        return cost_repair ;
    }
    
    public void setCost_repair(double cost_repair){
        this.cost_repair=cost_repair;
    }
    
    @Override
    public String toString(){ 
        return String.format(super.toString()+"\nDamage info\t\t= %s\nCost repair\t\t= RM %,.2f", getDamage_info().substring(0, 1).toUpperCase() + getDamage_info().substring(1),getCost_repair());
    }
    
}
