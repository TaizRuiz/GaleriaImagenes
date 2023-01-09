module com.mycompany.galeria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.galeria to javafx.fxml;
    exports com.mycompany.galeria;
}
