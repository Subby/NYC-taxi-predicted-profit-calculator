package uk.ac.aston.taxianalysis.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AbstractController {
    protected void loadScreen(Stage primaryStage, String layoutFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/layouts/" + layoutFile));
            Scene scene = new Scene(root);
            primaryStage.setTitle("NYC Taxi Predicted Profit Calculator");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
