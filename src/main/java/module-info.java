module io.github.jbarriospolo.termometro.termometro {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.jbarriospolo.termometro.termometro to javafx.fxml;
    exports io.github.jbarriospolo.termometro.termometro;
}