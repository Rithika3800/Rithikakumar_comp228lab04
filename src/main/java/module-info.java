module com.example.rithikakumar_comp228l4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rithikakumar_comp228l4 to javafx.fxml;
    exports com.example.rithikakumar_comp228l4;
}