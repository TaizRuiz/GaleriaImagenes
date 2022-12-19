module com.mycompany.galeria {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.galeria to javafx.fxml;
    exports com.mycompany.galeria;
}
