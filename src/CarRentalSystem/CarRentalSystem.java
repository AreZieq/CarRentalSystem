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

import java.util.*;
public class CarRentalSystem {

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        
        boolean validEmployee, validCustomer;
        String usernameEmployee = "";
        String passwordEmployee = "";
        String usernameCustomer = "";
        String passwordCustomer = "";
        
        //create 50 element Car and Rate array
        Car cars[] = new Car [50];
        Rate rates[] = new Rate [50];
        
        //initialize array with Car and Rate
        rates[0] = new Rate (4.5);
        cars[0] = new Available_Car ("Persona", "Economy", 5, rates[0], 150.0);
        rates[1] = new Rate (4.3);
        cars[1] = new Available_Car ("Saga SE", "Economy", 5, rates[1], 120.0);              
        rates[2] = new Rate (4.2);
        cars[2] = new Available_Car ("Ezora", "Family", 7, rates[2], 230.0);             
        rates[3] = new Rate (3.9);
        cars[3] = new Available_Car ("Myvi", "Compact", 5, rates[3], 110.0);               
        rates[4] = new Rate (4.7);
        cars[4] = new Available_Car ("Civic", "Economy", 5, rates[4], 190.0);
        
        rates[5] = new Rate (4.0);
        cars[5] = new Issued_Car ("Waja", "Economy", 5, rates[0], "Brake_Mulfunctioning", 250.00);
        rates[6] = new Rate (4.3);
        cars[6] = new Issued_Car ("Preve", "Economy", 5, rates[1], "Burn_Front_Lamp",120.0);              
        rates[7] = new Rate (4.2);
        cars[7] = new Issued_Car ("Bezza", "Economy", 5, rates[2], "Flat_Tyre", 230.0);             
        rates[8] = new Rate (4.9);
        cars[8] = new Issued_Car ("Alphard", "Family", 7, rates[3], "The_seat_is_torn", 110.0);               
        rates[9] = new Rate (4.8);
        cars[9] = new Issued_Car ("Serena", "Family", 7, rates[4], "Rear_brake_light_is_broken", 190.0);                
        
        System.out.println("======================================================\n\tWELCOME TO VICENZO CAR RENTAL SYSTEM\n======================================================");
        //user login and validate login
        int personType = 0;
        boolean valid_personType =true;
        do{ 
            try{
                System.out.print("1. Employee\t\t2. Customer\nLogin as? = ");
                personType = input.nextInt();
                if (personType > 2)throw new CatchNewError();
                valid_personType=false;
            } catch(InputMismatchException inputMismatchException) {
                input.nextLine();
                System.out.println("\nERROR !! Invalid input (Exp: 1 or 2). Try Again....");
            } catch(CatchNewError inputOutofRange) {
                inputOutofRange.one_two_errorMessage();
            }
        } while (valid_personType);
        
        //switch case for person type 
        switch (personType) {
            case 1:
                System.out.println("\n======================================================\n\t\tEMPLOYEE LOGIN\n======================================================");
                do{
                    System.out.print("Username : ");
                    usernameEmployee = input.next();
                    System.out.print("Password : ");
                    passwordEmployee = input.next();
                    validEmployee = "fakhrul".equals(usernameEmployee) && "fakhrul123".equals(passwordEmployee);
                    if (!validEmployee)
                        System.out.println("Username or password you enterred is incorrect !!");
                }while(!validEmployee);
                
                System.out.printf("\nHi, %s\n", usernameEmployee);
                
                //exception handling for employee name and phone number
                String Employee_name = "";
                long Phone_number = 0;
                boolean continueLoop=true;
                do{ 
                    try {
                        System.out.print("Enter your name\t\t = ");   
                        Employee_name = input.next();
                        System.out.print("Enter your phone number\t = ");
                        Phone_number = input.nextLong();

                        //catch error if user input special caracter
                        if (!Employee_name.matches("^[a-z][a-z ]*[a-z]?$")) throw new CatchNewError();
                        continueLoop = false;
                        
                    } catch (InputMismatchException   inputmismatcheException ) {
                        input.nextLine();
                        System.out.println("\nERROR !! Invalid name or phone number. Try Again.... ");
                    }catch (CatchNewError ior) {
                        ior.specialCaracter_errorMessage();
                    }
                }while (continueLoop);
                
                //exception handling if user input > 5
                int actionEmployee = 0;
                boolean valid_actionEmployee = true;
                do {
                    try {
                        System.out.print("\n1. View Details\t\t2. View Available Car\n3. View Issued Car\t4. Add available car\n5. Add Issued Car\nWhat Action do you want to perform = ");
                        actionEmployee = input.nextInt();
                        if (actionEmployee > 5) throw new CatchNewError();
                        valid_actionEmployee = false;
                    }catch (InputMismatchException ImmE) {
                        input.nextLine();
                        System.out.println("\nERROR !! Invalid input (Exp: 1 or 2 or 3 or 4 or 5). Try again...");
                    } catch (CatchNewError ior) {
                        ior.one_five_errorMessage();
                    } 
                }while (valid_actionEmployee);
                
                //switch case action employee
                switch (actionEmployee) {
                    case 1:
                        Employee employee = new Employee (usernameEmployee, passwordEmployee, Employee_name, Phone_number);
                        System.out.println("\n======================================================\n\t\tEMPLOYEE DETAILS\n======================================================");
                        employee.displayEmployee();
                        break;
                    case 2:
                        System.out.println("\n======================================================\n\t\tAVAILABLE CAR DETAILS\n======================================================");
                        for (int i = 0; i < 5; i++){
                            System.out.printf("\n=====================\n\tCAR %s\n=====================\n",i+1);
                            System.out.println(cars[i]);
                        }
                        break;
                    case 3:
                        System.out.println("\n======================================================\n\t\tISSUED CAR DETAILS\n======================================================");
                        for (int i = 5; i < 10; i++){
                            System.out.printf("\n=====================\n    ISSUED CAR %s\n=====================\n",(i-5)+1);
                            System.out.println(cars[i]);
                        }
                        break;
                    case 4:
                        {
                            System.out.println("\n======================================================\n\t\tADD AVAILABLE CAR\n======================================================");
                            
                            //exception handling for add available car
                            int element = 0;
                            boolean valid_element = true;
                            do {
                                try {
                                    System.out.print("How many car you want to add = ");
                                    element = input.nextInt();
                                    valid_element = false;
                                } catch (InputMismatchException ImmE) {
                                    input.nextLine();
                                    System.out.println("\nERROR !! Invalid number. Try again...");  
                                }
                            }while (valid_element);
                            
                            //exception handling for add available car detail   
                            String car_model, car_type = "";
                            int seater = 0, j = 5;
                            double rate =0, price = 0;
                            boolean valid_addCar = true;
                            do {
                                try {
                                    do{
                                        System.out.print("\nEnter car model\t\t= ");
                                        car_model = input.next();
                                        System.out.print("Enter car type\t\t= ");
                                        car_type = input.next();
                                        System.out.print("Enter seat number\t= ");
                                        seater = input.nextInt();
                                        System.out.print("Enter car rate\t\t= ");
                                        rate = input.nextDouble();
                                        System.out.print("Enter car price\t\t= ");
                                        price = input.nextDouble();
                                        
                                        //catch error if user input special caracter
                                        if (car_model.contains("!@#$%&*()'+,-./:;<=>?[]^_`{|}")) throw new CatchNewError();
                                        if (car_type.contains("!@#$%&*()'+,-./:;<=>?[]^_`{|}")) throw new CatchNewError();
                                        valid_addCar = false;
                                        
                                        rates [j] = new Rate (rate);
                                        cars [j] = new Available_Car (car_model, car_type, seater, rates[j], price);
                                        j++;
                                    } while (j  < element+5);
                                }catch (InputMismatchException ImmE) {
                                    input.nextLine();
                                    System.out.println("\nERROR !! Invalid input !! Try again...");  
                                } catch (CatchNewError ior) {
                                    ior.specialCaracter_errorMessage();
                                }
                            }while (j  < element+5 || valid_addCar);
                            
                            System.out.println("\n======================================================\n UPDATED AVAILABLE CAR DETAILS\n======================================================");
                            //lopping for print output polymorphism
                            for (int i = 0; i < element+5; i++){
                                System.out.printf("\n=====================\n   AVAILABLE CAR %s\n=====================\n",i+1);
                                System.out.println(cars[i]);
                            }
                            break;
                        }
                    case 5:
                        {
                            System.out.println("\n======================================================\n\t\tADD ISSUED CAR\n======================================================");
                            
                            //exception handling for add issued car
                            int elements = 0;
                            boolean valid_elements = true;
                            do {
                                try {
                                    System.out.print("How many car you want to report = ");
                                    elements = input.nextInt();
                                    valid_elements = false;
                                }catch (InputMismatchException ImmE) {
                                    input.nextLine();
                                    System.out.println("\nERROR !! Invalid number. Try Again...");  
                                }
                            }while (valid_elements);
                            
                            //exception handling for add issued car detail
                            String car_model, car_type, damage_info = "";
                            int seater = 0, j = 10;
                            double rate = 0, cost_repair = 0;
                            boolean valid_carRent = true;
                            do {
                                try {
                                    do{
                                        System.out.print("\nEnter car model\t\t= ");
                                        car_model = input.next();
                                        System.out.print("Enter car type\t\t= ");
                                        car_type = input.next();
                                        System.out.print("Enter seat number\t= ");
                                        seater = input.nextInt();
                                        System.out.print("Enter car rate\t\t= ");
                                        rate = input.nextDouble();
                                        System.out.print("Enter damage info\t= ");
                                        damage_info = input.next();
                                        System.out.print("Enter cost repair\t= ");
                                        cost_repair = input.nextDouble();

                                        //catch error if user input special caracter
                                        if (!car_model.matches("^[a-z][a-z ]*[a-z]?$")) throw new CatchNewError();
                                        if (!car_type.matches("^[a-z][a-z ]*[a-z]?$")) throw new CatchNewError();
                                        valid_carRent = false;  
                                        
                                    rates [j] = new Rate (rate);
                                    cars [j] = new Issued_Car (car_model, car_type, seater, rates[j], damage_info, cost_repair);
                                    j++;
                                    } while (j  < elements+10);
                                } catch (InputMismatchException ImmE) {
                                    input.nextLine();
                                    System.out.println("\nERROR !! Invalid input. Try again...");  
                                } catch (CatchNewError ior) {
                                    ior.specialCaracter_errorMessage();
                                }
                             } while (j  < elements+10 || valid_carRent);
                            
                            System.out.println("\n======================================================\n   UPDATED ISSUED CAR DETAILS\n======================================================");
                            //print polymorphism
                            for (int i = 5; i < elements+10; i++){
                                System.out.printf("\n=====================\n   ISSUED CAR %s\n=====================\n",(i-5)+1);
                                System.out.println(cars[i]);
                            }
                            break;
                        }
                    default:
                        System.out.println("ERROR !! Input no. 1 - 3 only ");
                        break;
                }
                break;
            case 2:
                System.out.println("\n======================================================\n\t\tCUSTOMER LOGIN\n======================================================");
                //validate login for customer
                do{
                    System.out.print("\nUsername : ");
                    usernameCustomer = input.next();
                    System.out.print("Password : ");
                    passwordCustomer = input.next();
                    validCustomer = "aiman".equals(usernameCustomer) && "aiman123".equals(passwordCustomer);
                    if (!validCustomer)
                        System.out.println("Username or password you enterred is incorrect !!");
                }while(!validCustomer);
                
                //exception handling for driver details
                String costumer_name = "";
                long phone_number = 0, lisense_no = 0;
                boolean valid_driverInfo = true;
                System.out.printf("\nHi, %s\n", usernameCustomer);
                do {
                    try {
                        System.out.print("Enter driver name\t\t\t = ");
                        costumer_name = input.next();
                        System.out.print("Enter driver phone number\t\t = ");
                        phone_number = input.nextLong();
                        System.out.print("Enter driver Lisense number\t\t = ");
                        lisense_no = input.nextLong();

                        //catch error if user input special caracter
                        if (!costumer_name.matches("^[a-z][a-z ]*[a-z]?$")) throw new CatchNewError();
                        valid_driverInfo = false; 
                        
                    }catch (InputMismatchException ImmE) {
                        input.nextLine();
                        System.out.println("\nERROR !! Invalid input !! Try again...");
                    } catch (CatchNewError ior) {
                        ior.specialCaracter_errorMessage();
                    }
                } while (valid_driverInfo);
                
                //exception handling for customer choice
                int actionCustomer = 0;
                boolean valid_actionCustomer= true;
                do {
                    try {
                        System.out.print("\n1. View Details\t\t2. Booking Car\nWhat Action do you want to perform = ");
                        actionCustomer = input.nextInt();
                        if (actionCustomer > 2) throw new CatchNewError();
                        valid_actionCustomer = false;
                    }catch (InputMismatchException ImmE) {
                        input.nextLine();
                        System.out.println("\nERROR !! Invalid input. (Exp: 1 or 2) Try again...");
                    } catch (CatchNewError ior) {
                        ior.one_two_errorMessage();
                    } 
                }while (valid_actionCustomer);
                
                //if else customer choice
                if (actionCustomer == 1) {
                    Costumer customer = new Costumer (usernameCustomer, passwordCustomer, costumer_name, phone_number, lisense_no);
                    System.out.println("\n======================================================\n\t\tCUSTOMER DETAILS\n======================================================");
                    customer.displayCustomer();
                }
                else if (actionCustomer == 2) {
                    System.out.println("\n======================================================\n\t\tCHOOSE CAR\n======================================================");
                    for (int i = 0; i < 5; i++){
                        System.out.printf("\n=====================\n\tCAR %s\n=====================\n",i+1);
                        System.out.println(cars[i]);
                        System.out.println("");
                    }
                    
                    //exception handling for day rent and car type
                    int day =0, rentCar = 0;
                    boolean valid_rentCar = true;
                    do {
                        try {
                            System.out.print("\nChoose your car\t\t = ");
                            rentCar = input.nextInt();
                            if (rentCar > 5) throw new CatchNewError();
                            System.out.print("How long you want rent\t = ");
                            day = input.nextInt();
                            valid_rentCar = false;
                        } catch (InputMismatchException ImmE) {
                            input.nextLine();
                            System.out.println("\nERROR !! Invalid input. Try again...");
                        } catch(CatchNewError inputOutofRange) {
                            inputOutofRange.error_CarnotAvailable();
                        }
                    } while (valid_rentCar);

                    //switch case invois
                    switch (rentCar) {
                        case 1:
                        {
                            System.out.println("\n======================================================\n\t\tINVOIS\n======================================================");
                            Costumer customer = new Costumer (usernameCustomer, passwordCustomer, costumer_name, phone_number, lisense_no);
                            customer.displayInvoisCustomer();
                            System.out.println(cars[0]);
                            Available_Car availableCar1 = new Available_Car ("Persona", "Economy", 5, rates[0], 150.0, day);
                            availableCar1.displayInvois();
                            availableCar1.calculateRentPrice();
                            break;
                        }
                        case 2:
                        {
                            System.out.println("\n======================================================\n\t\tINVOIS\n======================================================");
                            Costumer customer = new Costumer (usernameCustomer, passwordCustomer, costumer_name, phone_number, lisense_no);
                            customer.displayInvoisCustomer();
                            System.out.println(cars[1]);
                            Available_Car availableCar1 = new Available_Car ("Saga SE", "Economy", 5, rates[1], 120.0, day);
                            availableCar1.displayInvois();
                            availableCar1.calculateRentPrice();
                            break;
                        }
                        case 3:
                        {
                            System.out.println("\n======================================================\n\t\tINVOIS\n======================================================");
                            Costumer customer = new Costumer (usernameCustomer, passwordCustomer, costumer_name, phone_number, lisense_no);
                            customer.displayInvoisCustomer();
                            System.out.println(cars[2]);
                            Available_Car availableCar1 = new Available_Car ("Ezora", "Family", 7, rates[2], 230.0, day);
                            availableCar1.displayInvois();
                            availableCar1.calculateRentPrice();
                            break;
                        }
                        case 4:
                        {
                            System.out.println("\n======================================================\n\t\tINVOIS\n======================================================");
                            Costumer customer = new Costumer (usernameCustomer, passwordCustomer, costumer_name, phone_number, lisense_no);
                            customer.displayInvoisCustomer();
                            System.out.println(cars[3]);
                            Available_Car availableCar1 = new Available_Car ("Myvi", "Compact", 5, rates[3], 110.0, day);
                            availableCar1.displayInvois();
                            availableCar1.calculateRentPrice();
                            break;
                        }
                        case 5:
                        {
                            System.out.println("\n======================================================\n\t\tINVOIS\n======================================================");
                            Costumer customer = new Costumer (usernameCustomer, passwordCustomer, costumer_name, phone_number, lisense_no);
                            customer.displayInvoisCustomer();
                            System.out.println(cars[4]);
                            Available_Car availableCar1 = new Available_Car ("Civic", "Economy", 5, rates[4], 190.0, day);
                            availableCar1.displayInvois();
                            availableCar1.calculateRentPrice();
                            break;
                        }
                        default:
                            System.out.println("Sorry not Available Right Now");
                            break;
                    }
                }   break;
            default:
                System.out.println("Error Input (Choose 1 & 2)");
                break;
        }
     
    }
    
}
