package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML
    private Button btnUser;

    @FXML
    private Button btnAdmin;

    @FXML

    private void handleButtonAction(javafx.event.ActionEvent mouseEvent) throws IOException {
        if(mouseEvent.getSource()== btnUser) {
            Node node=(Node) mouseEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            stage.close();

            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/fxml/UserLogin.fxml")));
            stage.setScene(scene);
            stage.show();
        }
        else if(mouseEvent.getSource()== btnAdmin){
            Node node =(Node) mouseEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            stage.close();

            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/fxml/AdminLogin.fxml")));
            stage.setScene(scene);
            stage.show();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
