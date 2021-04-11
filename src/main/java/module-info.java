module idata1002 {
    requires javafx.controls;
    requires javafx.fxml;

    opens idata1002 to javafx.fxml;
    exports idata1002;
}