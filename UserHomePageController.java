package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserHomePageController implements Initializable {
    @FXML
    private Button btnNew;

    @FXML
    private Button btnMyComp;
    @FXML
    private Label asda;
    @FXML
    private Button btnExit;
    //private UserLoginController userLoginController;
    //private int userID = userLoginController.userID;
    public void handleButtonAction(javafx.event.ActionEvent event) throws IOException {

        if (event.getSource() == btnNew) {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/NewComplaint.fxml")));
            stage.setScene(scene);
            stage.show();

        } else if (event.getSource() == btnMyComp) {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/myComplaints.fxml")));
            stage.setScene(scene);
            stage.show();
        }
        else {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/HomePage.fxml")));
            stage.setScene(scene);
            stage.show();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //asda.setText(String.valueOf(userID));
    }
}
