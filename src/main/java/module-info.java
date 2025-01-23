module org.calma.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.calma.demo to javafx.fxml;
    exports org.calma.demo;
}