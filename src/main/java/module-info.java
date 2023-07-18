module com.example.hostelmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.hostelmanagementsystem to javafx.fxml;
    exports com.example.hostelmanagementsystem;
}