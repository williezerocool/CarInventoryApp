
package carinventory;

import java.util.List;
import java.util.Scanner;



public class UI {

    public static final int MIN_MENU_ITEM = 1;
    public static final int MAX_MENU_ITEM = 7;

    public static final int MENU_LIST = 1;
    public static final int MENU_ADD = 2;
    public static final int MENU_SELL = 3;
    public static final int MENU_REMOVE = 4;
    public static final int MENU_EDIT = 5;
    public static final int MENU_SEARCH = 6;

    private Scanner scanner = new Scanner(System.in);

  //UI display modules
    public void displayWelcome() {
        printLine("=============");
        printLine("");
        printLine("Car Inventory");
        printLine("");
        printLine("=============");
    }

    public void displayNoRecordFound() {
        printLine("");
        printLine("***");
        printLine("No record Found.");
        printLine("***");
        pressEnterToContinue();
    }

    public void displayCars(List<Car> cars) {
        
        printLine("");
        printLine("All Cars:");
        printLine("=========");
        for (Car car : cars) {
             printLine("Make: " + car.getCarMake());
             printLine("Model: " + car.getCarModel());
             printLine("Year: " + car.getYear());
             printLine("Vin: " + car.getVin());
             printLine("");
        }
        pressEnterToContinue();
    }

    public void displayResponse(Response response) {
        printLine("");
        printLine("***");
        if (response.isSuccess()) {
            printLine("Success!");
        } else {
            printLine(response.getMessage());
        }
        printLine("***");
        pressEnterToContinue();
    }

    public void displayGoodbye() {
        printLine("");
        printLine("==========");
        printLine("");
        printLine("Goodbye...");
        printLine("");
        printLine("==========");
    }

    //UI print modules
    public void printLine(String message) {
        print(message + "\n");
    }
    
    private void printMenu() {
        printLine("");
        printLine("===========");
        printLine("Main Menu:");
        printLine("1. List All Cars");
        printLine("2. Add a Car");
        printLine("3. Sell a Car");
        printLine("4. Remove a Car");
        printLine("5. Edit Details on a Car");
        printLine("6. Search for car");
        printLine("7. Exit");
    }
    
    private void print(String message) {
        System.out.print(message);
    }
    
    //UI read modules
    private String readLine(String message) {
        print(message);
        return scanner.nextLine();
    }

    private int readInt(String message) {
        int result = Integer.MIN_VALUE;
        while (result == Integer.MIN_VALUE) {
            try {
                result = Integer.parseInt(readLine(message));
            } catch (NumberFormatException ex) {
            }

        }
        return result;
    }

    //UI module for getting menu selection
    public int getMenuSelection() {
        printMenu();
        return readInt("Choose an option (1 - 5):");
    }
    
    //UI module for controlling UI flow
    private void pressEnterToContinue() {
        printLine("");
        readLine("Press <enter> to continue.");
    }

    /*modules that take info to create objects(car object, and buyer object)
    **addCar() and sellCar() modules in CarInventoryApp are dependent on these modules
    */
    public Car createCar() {
        printLine("");
        printLine("Add a Car");
        printLine("============");

        Car car = new Car();
        car.setCarMake(readLine("Enter car make: "));
        car.setCarModel(readLine("Enter car model: "));
        car.setYear(readLine("Enter car year: "));
        car.setVin(readLine("Enter car vin: "));
        car.setVehicleDetails(readLine("Enter vehicle details: "));
        return car;
    }

    public Buyer createBuyer(String vin) {
        
        Buyer buyer = new Buyer();
        
        buyer.setVin(vin);
        buyer.setFirstName(readLine("Enter Buyer's First Name: "));
        buyer.setLastName(readLine("Enter Buyer's Last Name: "));
        buyer.setAddress(readLine("Enter Buyer's Address: "));
        String purchasePrice = readLine("Enter Buyer's Purchase price: ");
        buyer.setPurchasePrice(Integer.parseInt(purchasePrice));
        String paid = readLine("Enter Buyer's down payment: ");
        buyer.setTotalPaid(Integer.parseInt(paid));
        buyer.getCreateDate();
        
        return buyer;
    }

    /*modules that are for searching and editing 
    **editCarDetails() & carSearch() modules in CarInventoryApp
    **are dependent on these modules
    */
    public String getCarVin() {
        
        String vin = readLine("Enter vehicle vin: ");
        return vin;
    }
    
    public String search() {
        printLine("");
        String search = readLine("Enter Vin for Search:  ");
        return search;
    }
    
    public String getBuyersVin() {
        String vin = readLine("Enter Vin of Vehicle you wish to Sell: ");
        return vin;
    }
    
    public String getBuyersFirstName() {
        String name = readLine("Enter buyers first name: ");
        return name;
    }
    
    public String getBuyersLastName() {
        String name = readLine("Enter buyers last name: ");
        return name;
    }
    
    public String getBuyersAddress() {
        String address = readLine("Enter buyers address: ");
        return address;
    }
    
    public String getBuyersPhoneNumber() {
        String PhoneNumber = readLine("Enter buyers phone number: ");
        return PhoneNumber;
    }
    
    public int getBuyersPurchasePrice() {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter buyers purchase price: ");
        int PurchasePrice = s.nextInt();
        
        return PurchasePrice;
    }
    
    public int getBuyerstotalPaid() {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter buyers total paid: ");
        int totalPaid = s.nextInt();
        
        return totalPaid;
    }
    
    public String editArea() {
        String editArea = readLine("Enter the area of the car you want to edit(Make, Model, Year, Vin, or Details): ");
        return editArea;
    }
    
    public String edit() {
        String edit = readLine("Enter edit: ");
        return edit;
    }
    
    
}