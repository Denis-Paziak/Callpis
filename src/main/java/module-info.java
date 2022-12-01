module com.example.first {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.first to javafx.fxml;
    exports com.example.first;
}