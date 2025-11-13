package com.mylabs.amrajavafxlab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentInfoApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudentInfoApp.class.getResource("student-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);

        stage.setTitle("Student Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
