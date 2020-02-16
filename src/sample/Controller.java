//Arsoon Shiwani
package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<Employee> employeeListView;
@FXML
private TextField firstNameTextField;
@FXML
private TextField lastNameTextField;
@FXML
private CheckBox isActiveCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                        ObservableValue< ? extends Worker> ov, Worker old_val, Worker new_val)->
        {
            Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();
            firstNameTextField.setText(((Employee)selectedItem).firstName);//try this in try and catch box
            lastNameTextField.setText(((Employee)selectedItem).lastName);
            isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);//type casting
        }
        );

        ObservableList<Employee> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.firstName = "Robert";
        employee1.lastName = "Smith";
        employee2.firstName = "Lisa";
        employee2.lastName = "Smith";


        items.add(employee1);
        items.add(employee2);


        for(int i = 0; i <10; i++)
        {
           Employee employee = new Employee();
           employee.firstName = "Generic";
           employee.lastName = "Employee" + " " + i;
           items.add(employee);
           employee.hire();
       }

        Staff Staff1 = new Staff();
        Staff1.firstName = "StaffPerson";
        Staff1.lastName = "GoodWorker";

        Faculty faculty1 = new Faculty();
        faculty1.firstName = "FacultyPerson";
        faculty1.lastName = "TerribleWorker";
        items.add(Staff1);
        items.add(faculty1);

// toolbar code: https://stackoverflow.com/questions/24896498/how-to-right-align-a-button-in-java-fx-toolbar/24905704
}
//Sourcecode: https://www.youtube.com/watch?v=PUH6njIXV1A
    public void ButtonDelete(ActionEvent actionEvent) {

        ObservableList<Employee> selectedRows, allemployees;
        allemployees = employeeListView.getItems();
        selectedRows = employeeListView.getSelectionModel().getSelectedItems();
        for(Employee employee: selectedRows)
        {
            allemployees.remove(employee);
        }
    }

    //Source code links
//https://www.youtube.com/watch?v=3KnkFyD8MSs
// https://coderanch.com/t/688570/java/Clearing-content-selected-textarea
    public void clear(ActionEvent actionEvent) {
        firstNameTextField.clear();
        lastNameTextField.clear();
        isActiveCheckBox.setSelected(false);
    }

    public void newadd(ActionEvent actionEvent) {
// Employee employee = new Employee(firstNameTextField.getText().Double.Parse);
        ObservableList<Employee> items = employeeListView.getItems();
        Employee newemployee = new Employee();
        newemployee.firstName = firstNameTextField.getText();
        newemployee.lastName = lastNameTextField.getText();
newemployee.isActive = isActiveCheckBox.isSelected();
        items.add(newemployee);
    }
}
