module com.example.test2b {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.test2b to javafx.fxml;
    exports com.example.test2b;
}