module com.example.treeview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.treeview to javafx.fxml;
    exports com.example.treeview;
}