package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;

public class ComplaintsModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty userID;
    private SimpleStringProperty city;
    private SimpleStringProperty district;
    private SimpleStringProperty vehicle_type;
    private SimpleStringProperty car_plate;
    private SimpleStringProperty in_date;
    private SimpleStringProperty my_complaint;

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getUserID() {
        return userID.get();
    }


    public void setUserID(String userID) {
        this.userID.set(userID);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getDistrict() {
        return district.get();
    }

    public void setDistrict(String district) {
        this.district.set(district);
    }

    public String getVehicle_type() {
        return vehicle_type.get();
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type.set(vehicle_type);
    }

    public String getCar_plate() {
        return car_plate.get();
    }

    public void setCar_plate(String car_plate) {
        this.car_plate.set(car_plate);
    }

    public String getIn_date() {
        return in_date.get();
    }

    public void setIn_date(String in_date) {
        this.in_date.set(in_date);
    }

    public String getMy_complaint() {
        return my_complaint.get();
    }

    public void setMy_complaint(String my_complaint) {
        this.my_complaint.set(my_complaint);
    }

    public ComplaintsModel(Integer id, String userID, String city, String district, String vehicle_type
    , String car_plate, String in_date, String my_complaint){
        this.id = new SimpleIntegerProperty(id);
        this.userID = new SimpleStringProperty(userID);
        this.city = new SimpleStringProperty(city);
        this.district = new SimpleStringProperty(district);
        this.vehicle_type = new SimpleStringProperty(vehicle_type);
        this.car_plate = new SimpleStringProperty(car_plate);
        this.in_date = new SimpleStringProperty(in_date);
        this.my_complaint = new SimpleStringProperty(my_complaint);
    }
}
