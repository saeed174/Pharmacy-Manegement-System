module com.mycompany.pharmacy {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pharmacy to javafx.fxml;
    exports com.mycompany.pharmacy;
}
