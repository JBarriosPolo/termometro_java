package io.github.jbarriospolo.termometro.termometro;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class ThermometerController {
    @FXML
    private TextField inputCelsius;
    @FXML
    private Label resultText;
    @FXML
    private ProgressBar temperaturaBarHot;
    @FXML
    private ProgressBar temperaturaBarCool;

    @FXML
    public void initialize() {
        inputCelsius.textProperty().addListener((observable, oldValue, newValue) -> {
            updateTemperature(newValue);
        });
    }

    private void updateTemperature(String text) {
        try {
            double celsius = Double.parseDouble(text);
            double fahrenheit = celsius * 9 / 5 + 32;
            resultText.setText(String.format("%.1f °C es equivalente a %.1f °F", celsius, fahrenheit));
            if (celsius > 0) {
                temperaturaBarHot.setProgress(celsius / 100.0);
                temperaturaBarCool.setProgress(0);
            } else {
                temperaturaBarCool.setProgress(-celsius / 100.0);
                temperaturaBarHot.setProgress(0);
            }
        } catch (NumberFormatException e) {
            temperaturaBarHot.setProgress(0);
            temperaturaBarCool.setProgress(0);
            resultText.setText("Por favor, ingrese un número válido.");
        }
    }
}
