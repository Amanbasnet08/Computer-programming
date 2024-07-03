module com.example.test2bprogrammingconcepts {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.test2bprogrammingconcepts to javafx.fxml;
    exports com.example.test2bprogrammingconcepts;
}