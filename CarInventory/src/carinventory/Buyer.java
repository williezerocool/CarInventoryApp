
package carinventory;

import java.time.LocalDate;


public class Buyer {
    
    private String firstName, lastName, address, vin;
    private Integer purchasePrice, payment, totalPaid, downPayment;
    private LocalDate createDate = LocalDate.now();
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getVin() {
        return this.vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public Integer getPurchasePrice() {
        return this.purchasePrice;
    }
    
    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
    public Integer getPaymentHistory() {
        return this.payment;
    }
    
    public void setPaymentHistory(Integer payment) {
        this.payment = payment;
    }
    
    public Integer getTotalPaid() {
        return this.totalPaid;
    }
    
    public void setTotalPaid(Integer totalPaid) {
        this.totalPaid = totalPaid;
    }
    
    public Integer getDownPayment() {
        return this.downPayment;
    }
    
    public void setDownPayment(Integer downPayment) {
        this.downPayment = downPayment;
    }
    
    public LocalDate getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    
}
