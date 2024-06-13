module com.example.lab1programmingconcepts {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.lab1programmingconcepts to javafx.fxml;
    exports com.example.lab1programmingconcepts;
}