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

    private ToggleGroup majorGroup = new ToggleGroup();

    private ObservableList<String> cScienceCourses = FXCollections.observableArrayList("Java", "Python", "C#", "PHP", "Database");
    private ObservableList<String> businessCourses = FXCollections.observableArrayList("Accounting", "Marketing", "Finance");

    @FXML
    public void initialize() {
        //toggle group
        rbCScience.setToggleGroup(majorGroup);
        rbBusiness.setToggleGroup(majorGroup);

        //Default to Computer Science
        rbCScience.setSelected(true);
        cbSelectMajor.setItems(cScienceCourses);

        //Change courses when major changes
        majorGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == rbCScience) {
                cbSelectMajor.setItems(cScienceCourses);
            } else {
                cbSelectMajor.setItems(businessCourses);
            }
            listCourses.getItems().clear();
        });

        //Add course to ListView if not added
        cbSelectMajor.setOnAction(e -> {
            String selected = cbSelectMajor.getValue();
            if (selected != null && !listCourses.getItems().contains(selected)) {
                listCourses.getItems().add(selected);
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
