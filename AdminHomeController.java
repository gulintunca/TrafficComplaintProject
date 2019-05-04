/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import models.ComplaintsModel;
import utils.ConnectionUtil;

/**
 * FXML Controller class
 *
 * @author oXCToo
 */
public class AdminHomeController implements Initializable {

    @FXML
    private TextField txtFirstname;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtEmail;
    @FXML
    private DatePicker txtDOB;
    @FXML
    private Button btnSearch;
    @FXML
    private ComboBox<String> txtGender;
    @FXML
    private TextField tfSearch;
    @FXML
    Label lblStatus;
    @FXML
    TableView tbData;
    @FXML
    private TableColumn<ComplaintsModel, Integer> ComplaintID;
    @FXML
    private TableColumn<ComplaintsModel, String> Username;
    @FXML
    private TableColumn<ComplaintsModel, String> City;
    @FXML
    private TableColumn<ComplaintsModel, String> District;
    @FXML
    private TableColumn<ComplaintsModel, String> VehicleType;
    @FXML
    private TableColumn<ComplaintsModel, String> MyComplaint;
    @FXML
    private TableColumn<ComplaintsModel, Integer> CarPlate;
    @FXML
    private TableColumn<ComplaintsModel, Integer> InDate;

    /**
     * Initializes the controller class.
     */
    PreparedStatement preparedStatement = null;
    Connection con = null;
    ResultSet resultSet = null;
    private ObservableList<ComplaintsModel> complaintsModels = FXCollections.observableArrayList();
    public AdminHomeController() {
        con= (Connection) ConnectionUtil.conDB();
    }

    public void searchData(){
        clearField();
        ComplaintID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Username.setCellValueFactory(new PropertyValueFactory<>("userID"));
        City.setCellValueFactory(new PropertyValueFactory<>("city"));
        District.setCellValueFactory(new PropertyValueFactory<>("district"));
        VehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicle_type"));
        MyComplaint.setCellValueFactory(new PropertyValueFactory<>("my_complaint"));
        CarPlate.setCellValueFactory(new PropertyValueFactory<>("car_plate"));
        InDate.setCellValueFactory(new PropertyValueFactory<>("in_date"));
        tbData.setItems(complaintsModels);
        if (tfSearch.getText() != "") {
            try{
                preparedStatement = (PreparedStatement) con.prepareStatement("Select c.id,u.user_name,c.city,c.district,c.vehicle_type,c.car_plate,c.in_date,c.my_complaint from complaints c INNER JOIN userlogin u on c.id = u.id where city like ?");
                preparedStatement.setString(1, "%"+tfSearch.getText()+"%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    complaintsModels.add(new ComplaintsModel(resultSet.getInt("c.id"),resultSet.getString("u.user_name"),resultSet.getString("c.city"),
                            resultSet.getString("c.district"),resultSet.getString("c.vehicle_type"),resultSet.getString("c.car_plate"),resultSet.getString("c.in_date"),resultSet.getString("c.my_complaint")));
                }
            }catch (SQLException ex){
                Logger.getLogger(AdminHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO


    }
    public void clearField(){
        for ( int i = 0; i<tbData.getItems().size(); i++) {
            tbData.getItems().clear();
        }
    }
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == btnSearch){
            searchData();
        }
    }


}
