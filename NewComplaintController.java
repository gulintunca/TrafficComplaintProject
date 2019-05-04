package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.ComplaintsModel;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewComplaintController implements Initializable{

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfDiscrict;

    @FXML
    private TextField tfPlate;

    @FXML
    private TextField tfDate;

    @FXML
    private TextArea taComplaints;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnExit;

    @FXML
    private RadioButton cbTaxi;

    @FXML
    private RadioButton cbCar;
    @FXML
    private TextField tfVehicleType;
    @FXML
    private RadioButton cbMotor;
    @FXML
    private RadioButton cbBus;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    public void handleButtonAction(javafx.event.ActionEvent event) throws IOException {
        if(event.getSource() == btnExit){
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/UserHomePage.fxml")));
            stage.setScene(scene);
            stage.show();
        }else if(event.getSource() == btnSubmit){
            AddData();
        }
    }

    public void AddData(){

        try {
            preparedStatement = con.prepareStatement("INSERT INTO complaints (userId,city,district,vehicle_type,car_plate,in_date,my_complaint)" +
                    "values (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,tfCity.getText());
            preparedStatement.setString(3,tfDiscrict.getText());
            preparedStatement.setString(4,tfVehicleType.getText());
            preparedStatement.setString(5,tfPlate.getText());
            preparedStatement.setString(6,tfDate.getText());
            preparedStatement.setString(7,taComplaints.getText());
            int i = preparedStatement.executeUpdate();
            if(i == 1){
                tfCity.clear();
                tfDiscrict.clear();
                tfVehicleType.clear();
                tfPlate.clear();
                tfDate.clear();
                taComplaints.clear();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    private ObservableList<ComplaintsModel> complaintsModels = FXCollections.observableArrayList();
}

