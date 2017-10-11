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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author ANTHONY
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pinneappleCheckBox;
    @FXML private CheckBox baconCheckBox;
    
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;
    
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;
    
    @FXML private RadioButton radiobtn1;
    @FXML private RadioButton radiobtn2;
    @FXML private RadioButton radiobtn3;
    @FXML private RadioButton radiobtn4;
    @FXML private ToggleGroup  favFoodToggleGroup;
    
    @FXML private Label radioButtonLabel;
    
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
    
    public void choiceBoxWasUpdated(){
        this.choiceBoxLabel.setText("Course selected : \n" + choiceBox.getValue().toString());
    }
    
    public void comboBoxWasUpdated(){
        this.comboBoxLabel.setText("Course selected : \n" + comboBox.getValue().toString());
    }
    
    public void RadioButtonChosen(){
        if (this.favFoodToggleGroup.getSelectedToggle().equals(this.radiobtn1)){
            radioButtonLabel.setText("The Selected Item is Burger");
        }
        
        if (this.favFoodToggleGroup.getSelectedToggle().equals(this.radiobtn2)){
            radioButtonLabel.setText("The Selected Item is Pizza");
        }
        
        if (this.favFoodToggleGroup.getSelectedToggle().equals(this.radiobtn3)){
            radioButtonLabel.setText("The Selected Item is Ugali");
        }
        
        if (this.favFoodToggleGroup.getSelectedToggle().equals(this.radiobtn4)){
            radioButtonLabel.setText("The Selected Item is Madondo");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pizzaOrderLabel.setText("");
        
        choiceBoxLabel.setText("");
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().addAll("Oranges","Pears","Strawberries");
        choiceBox.setValue("Apples");
        
        comboBoxLabel.setText("");
        comboBox.getItems().add("COMP1030");
        comboBox.getItems().addAll("COMP1008","MGMT2003", "MGMT2010");
        
        radioButtonLabel.setText("");
        favFoodToggleGroup = new ToggleGroup();
        this.radiobtn1.setToggleGroup(favFoodToggleGroup);
        this.radiobtn2.setToggleGroup(favFoodToggleGroup);
        this.radiobtn3.setToggleGroup(favFoodToggleGroup);
        this.radiobtn4.setToggleGroup(favFoodToggleGroup);
    }    
    
}
