package uk.ac.aston.taxianalysis.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.jongo.Aggregate;
import uk.ac.aston.taxianalysis.model.Profit;
import uk.ac.aston.taxianalysis.service.JongoTaxiAnalysisService;

public class MainController {

    private static final String DEFAULT_OUTPUT_TEXT_LABEL = "Your predicted profit for the journey is: ";

    @FXML
    private TextField inputTextField;
    @FXML
    private Label outputLabel;

    @FXML
    private void onSubmitBtnPress(ActionEvent action) {
        outputLabel.setVisible(false);
        outputLabel.setText(DEFAULT_OUTPUT_TEXT_LABEL);
        if(textFieldValidationSucessful()) {
            Profit profit = calculateProfitForDistance();
            double roundedProfitValue = Math.round(profit.getProfit() * 100.0) / 100.0;
            outputLabel.setText(DEFAULT_OUTPUT_TEXT_LABEL + roundedProfitValue);
            outputLabel.setVisible(true);
        }
    }

    private Profit calculateProfitForDistance() {
        JongoTaxiAnalysisService analysisService = new JongoTaxiAnalysisService();
        final Aggregate.ResultsIterator<Profit> result = analysisService.calculateProfitForDistance(Double.parseDouble(inputTextField.getText()));
        return result.next();
    }

    private boolean textFieldValidationSucessful() {
        if(inputTextField.getText() == null || inputTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure the input field is filled out.");
            return false;
        }
        try {
            Double.parseDouble(inputTextField.getText());
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please ensure the input field contains a number.");
            return false;
        }
        return true;
    }
}
