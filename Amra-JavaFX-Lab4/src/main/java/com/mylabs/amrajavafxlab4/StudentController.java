package com.mylabs.amrajavafxlab4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

public class StudentController {
    //FXML UI elements
    @FXML private TextField stName, stAddress, stProvince, stCity, stPostal, stPhone, stEmail;
    @FXML private CheckBox studentCouncil, volunteerWork;
    @FXML private RadioButton rbCScience, rbBusiness;
    @FXML private ComboBox<String> cbSelectMajor;
    @FXML private ListView<String> listCourses;
    @FXML private TextArea stDisplay;

    @FXML
    public void initialize() {
        //set default to Computer Science
        rbCScience.setSelected(true);
        cbSelectMajor.setItems(FXCollections.observableArrayList("Java", "Python", "C#", "PHP", "Database"));

        //Update courses when RadioButton is clicked
        rbCScience.setOnAction(e -> {
            cbSelectMajor.setItems(FXCollections.observableArrayList("Java", "Python", "C#", "PHP", "Database"));
            listCourses.getItems().clear();
        });

        rbBusiness.setOnAction(e -> {
            cbSelectMajor.setItems(FXCollections.observableArrayList("Accounting", "Marketing", "Finance"));
            listCourses.getItems().clear();
        });

        //Add selected course to ListView
        cbSelectMajor.setOnAction(e -> {
            String course = cbSelectMajor.getValue();
            if (course != null && !listCourses.getItems().contains(course)) {
                listCourses.getItems().add(course);
            }
        });
    }

    @FXML
    private void onDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append(stName.getText()).append(", ")
                .append(stAddress.getText()).append(", ")
                .append(stCity.getText()).append(", ")
                .append(stProvince.getText()).append(", ")
                .append(stPostal.getText()).append(", ")
                .append(stPhone.getText()).append(", ")
                .append(stEmail.getText()).append("\n");

        sb.append("Activities: ");
        if (studentCouncil.isSelected()) sb.append("Student Council ");
        if (volunteerWork.isSelected()) sb.append("Volunteer Work ");
        sb.append("\n");

        sb.append("Major: ").append(rbCScience.isSelected() ? "Computer Science" : "Business").append("\n");

        sb.append("Courses:\n");
        for (String course : listCourses.getItems()) {
            sb.append(course).append("\n");
        }

        stDisplay.setText(sb.toString());
    }
}
