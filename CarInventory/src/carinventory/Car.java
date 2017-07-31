
package carinventory;

import java.time.LocalDate;


public class Car {
    
    private String carMake, carModel, vin, vehicleDetails, year ;
    private LocalDate createDate = LocalDate.now();
    
    public String getCarMake() {
        return this.carMake;
    }
    
    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }
    
    public String getCarModel() {
        return this.carModel;
    }
    
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    
    public String getVin() {
        return this.vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public String getVehicleDetails() {
        return this.vehicleDetails;
    }
    
    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
    
    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public LocalDate getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    
}
