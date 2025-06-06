module com.example.threadedlivecounter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.threadedlivecounter to javafx.fxml;
    exports com.example.threadedlivecounter;
}