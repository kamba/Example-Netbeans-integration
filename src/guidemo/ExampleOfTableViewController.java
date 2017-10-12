/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */


public class ExampleOfTableViewController implements Initializable {

    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthDayColumn;
    
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private DatePicker birthday;
    @FXML private Button detailedPersonViewButton;
    @FXML private Button deletePersonButton;
    
    //Enable Detailed view and Delete Button
    public void userClickedOnTable(){
        this.deletePersonButton.setDisable(false);
        this.detailedPersonViewButton.setDisable(false);
    }
    //Allow double Click Edit
    public void changeFirstNameCellEvent(CellEditEvent edittedCell){
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setFirstName(edittedCell.getNewValue().toString());
    }
    
    public void changeLastNameCellEvent(CellEditEvent edittedCell){
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setLastName(edittedCell.getNewValue().toString());
    }
    
    public void changeSceneButtonPushed(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    //Pass selected person object to the Detailed view
    public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PersonView.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        //acces controller and call method.
        
        PersonViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthDayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
        
        //load dummy data
        
        tableView.setItems(getPeople());
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //Allow multiple selection of Table
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.detailedPersonViewButton.setDisable(true);
        this.deletePersonButton.setDisable(true);
    }  
    
    //Method to remove the rows
    public void deleteButtonPushed(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        //Loop over selected rows
        for (Person person: selectedRows){
            allPeople.remove(person);
        }
    }
    
    public void newPersonButtonPushed(){
        Person newPerson = new Person(firstNameTextField.getText(), lastNameTextField.getText(), birthday.getValue());
        //Get all the elements ffrom table and add back to table
        
        tableView.getItems().add(newPerson);
        JOptionPane.showMessageDialog(null, "Added " + firstNameTextField.getText() + "to List");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        birthday.setValue(null);
        
    }
    
    public ObservableList<Person> getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Anthony", "Musembi", LocalDate.of(1977, Month.JUNE, 29),new Image("me.jpg")));
        people.add(new Person("Jacqueline", "Njeri", LocalDate.of(1976, Month.MARCH, 10)));
        people.add(new Person("Isaac", "Mshindi", LocalDate.of(2015, Month.APRIL, 9)));
        people.add(new Person("Mark", "Mshindi", LocalDate.of(2017, Month.SEPTEMBER, 29)));
        return people;
    }
    
}
