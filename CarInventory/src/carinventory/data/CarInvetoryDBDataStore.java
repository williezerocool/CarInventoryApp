package carinventory.data;

import carinventory.Car;
import carinventory.Response;
import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class CarInvetoryDBDataStore {
    
    private final Connection conn;
    

    public CarInvetoryDBDataStore() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_Inventory?autoReconnect=true&useSSL=false", "root", "williemysql");
    }

    
    public void listData() throws SQLException {
        
        Response result = new Response();
        
        try {
        
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * FROM car";
            ResultSet rs = stmt.executeQuery(sql);
              
            while(rs.next()) {
            
               String output = 
               rs.getString(1) + " " + rs.getString(2) +  " " + rs.getString(3) + " " + rs.getString(4);
               
               System.out.println( "\n" + output);
            }
            
            
        }catch (SQLException ex) {
        
            result.setMessage(ex.getSQLState());
            System.out.print(result);
        }
        
    }
   
   
   
    public Response addData(Car car) {
    
        Response result = new Response();
       
        try {
            
            
            
            PreparedStatement statement = conn.prepareStatement("INSERT INTO car (vin, make, model, year, details) VALUES(?, ?, ?, ?, ?)");
            
            statement.setString(1,car.getVin());
            statement.setString(2, car.getCarMake());
            statement.setString(3, car.getCarModel());
            statement.setString(4, car.getYear());
            statement.setString(5, car.getVehicleDetails());
        
            statement.execute();
            result.setMessage("Database upload sucessful!!!!");
            
        }catch(SQLException ex) {
            result.setMessage(ex.getSQLState());
        }
        
        return result;
    }
    
    
    public Response sell(String first_name,String last_name,String address,String phone_number,int Purchase_price,int total_paid,LocalDate date) {
        
        Response result = new Response();
        
        try {
        
            String sql = "INSERT INTO buyer "
                    + "(first_name, last_name, address, phone_number, Purchase_price, total_paid, date)"  +
                    " VALUES(?, ?, ?, ?, ?, ?, ?)";
           
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            
        } catch(SQLException ex) {
        
            result.setMessage(ex.getSQLState());
        }
        
        return result;
    
      }
    

   public Response removeData(String vin) {
   
       Response result = new Response();
       
       try {
           
           PreparedStatement stmt = conn.prepareStatement("DELETE FROM car WHERE vin = ?");
           
           stmt.setString(1, vin);
           
           stmt.execute();
           
           result.setMessage("Data removed");
           
       }catch(SQLException ex) {
       
           result.setMessage(ex.getSQLState());
           
       }
       
       return result;
   }
   
   public Response editingData(String vin, String editArea, String edit) {
   
       Response result = new Response();
       
       
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("UPDATE car SET " + editArea + " = ? WHERE vin = ? ");
       
           stmt.setString(1, edit);
           stmt.setString(2, vin);
           
           stmt.execute();
           
           result.setMessage("Data updated!!!");
       }catch(SQLException ex) {
           
       
           System.out.print(ex.getSQLState());
       }
       
       return result;
       
   }
   
   public void searchDB(String vin) {
   
       try{
           
           PreparedStatement stmt = conn.prepareStatement("SELECT make, model, year, vin, details FROM car WHERE vin = ?");
           
           stmt.setString(1, vin);
           
           ResultSet rs =  stmt.executeQuery();
           
           while(rs.next()) {
           
               String output = 
               rs.getString(1) + ", " + rs.getString(2) +  ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getString(5);
               
               System.out.println(output);
           }
       }catch(SQLException ex ) {
       
           System.out.print(ex.getSQLState());
       }
   }
   
    
}
