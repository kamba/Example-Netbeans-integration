/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 *
 * @author ANTHONY
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pinneappleCheckBox;
    @FXML private CheckBox baconCheckBox;
    
    public void pizzaOrdderButtonOrderPushed(){
        String order = "Toppings are: ";
        if (pinneappleCheckBox.isSelected()){
            order += "\nPineapple";
        }
        if (pepperoniCheckBox.isSelected()){
            order += "\nPepperoni";
        }
        if (baconCheckBox.isSelected()){
            order += "\nBacon";
        }
        
        this.pizzaOrderLabel.setText(order);
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pizzaOrderLabel.setText("");
    }    
    
}
