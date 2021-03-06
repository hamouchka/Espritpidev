/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easy.ride.GUI;

import easy.ride.Utils.DataBase;
import easy.ride.entities.Utilisateur;
import easy.ride.service.ServiceUtilisateur;
import easy.ride.service.UserSession;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author suare
 */
public class SettingsController implements Initializable {
 @FXML
    private PasswordField password;
 @FXML
    private PasswordField passwordrepeat;
 
    @FXML
    private Label labelpassword = new Label();
    @FXML
    private Label labelpasswordrepeat = new Label();
    
  @FXML
    private Button button;

    public void initialize(URL url, ResourceBundle rb) {
      

    }

    /*public void update(ActionEvent event) {

        String tfpassword = password.getText();
        String tfpasswordrepeat = passwordrepeat.getText();
        ServiceUtilisateur ser = new ServiceUtilisateur();

        if(tfpassword.equals(tfpasswordrepeat)){
               try {
                   System.out.println("PAssowrd match");
            ser.update(tfpassword, 2);
            
        } catch (SQLException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            System.out.println("PAssowrd Mismatch");
        }
        
     

    }
    */
    @FXML
    public void update(ActionEvent event)  {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Paramètres");
        alert.setHeaderText("Mot de passes:");
        alert.setContentText("Modifications avec succés!");
 
       
        String tfpassword = password.getText();
        String tfpasswordrepeat = passwordrepeat.getText();
        ServiceUtilisateur ser = new ServiceUtilisateur();
        labelpassword.setText("");
        labelpassword.setTextFill(Color.web("#ff0000"));
         labelpasswordrepeat.setText("");
        labelpasswordrepeat.setTextFill(Color.web("#ff0000"));
        
        if( tfpassword.isEmpty() || tfpassword.length() <6 || tfpassword.length() >30 ){
              labelpassword.setText("Champ Invalide");
        }else if (!tfpassword.equals(tfpasswordrepeat)) {
            System.out.println("PAssowrd Mismatch");
            labelpasswordrepeat.setText("Password Mismatch");
        } else {
            System.out.println("PAssowrd match");
            try {
                ser.update(tfpassword, UserSession.getInstace("", "",0).getId());
                 alert.showAndWait();
            } catch (SQLException ex) {
                Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
