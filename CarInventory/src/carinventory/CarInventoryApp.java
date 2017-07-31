
package carinventory;



import carinventory.data.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CarInventoryApp {
    
    private UI ui = new UI();
    private CarInvetoryDBDataStore carDB;
    
    public CarInventoryApp() throws SQLException {
  
        this.carDB = new CarInvetoryDBDataStore();
    }
    
    public void run() throws SQLException {

        ui.displayWelcome();

        int selection = UI.MIN_MENU_ITEM;
        while (selection >= UI.MIN_MENU_ITEM && selection < UI.MAX_MENU_ITEM) {

            selection = ui.getMenuSelection();

            switch (selection) {
                case UI.MENU_LIST:
                    ListCars();
                    break;
                case UI.MENU_ADD:
                    addCar();
                    break;
                case UI.MENU_SELL:
                    sellCar();
                    break;
                case UI.MENU_REMOVE:
                    remove();
                    break;
                case UI.MENU_EDIT:
                    editCarDetails();
                    break;
                case UI.MENU_SEARCH:
                    carSearch();
                    break;
            }
        }

        ui.displayGoodbye();
    }
    
    private void ListCars() throws SQLException {
        carDB.listData();
    }
    
    private void addCar() {
        
        Response result = null;
        
        Car car = ui.createCar();
        
        result = carDB.addData(car);
       
        ui.displayResponse(result);
     }
    
    private void sellCar() {
      
        Buyer buyer = new Buyer();
        
        String vin = ui.getBuyersVin();
        String f_name = ui.getBuyersFirstName();
        String l_name = ui.getBuyersLastName();
        String phoneNumber = ui.getBuyersPhoneNumber();
        int purchasePrice = ui.getBuyersPurchasePrice();
        int totalPaid = ui.getBuyerstotalPaid();
        LocalDate date = buyer.getCreateDate();
        
        Response result = carDB.sell(vin, f_name, l_name, phoneNumber, purchasePrice , totalPaid, date);
        
        ui.displayResponse(result);
       
    }
    
    private void remove() {
       
       String vin = ui.getCarVin();
       
       Response result = carDB.removeData(vin);
       
       ui.displayResponse(result);
    }
    
    private void editCarDetails(){
       
        String vin = ui.getCarVin();
        String editArea = ui.editArea();
        String edit = ui.edit();
        
        Response result = carDB.editingData(vin, editArea, edit);
        
        ui.displayResponse(result); 
        
    }
    
    private void carSearch() {
       
        String vin = ui.getCarVin();
        
        carDB.searchDB(vin);
    }
    

    
    
    
}
