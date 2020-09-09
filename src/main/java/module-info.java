module se.ecutbildning {
    requires javafx.controls;
    requires javafx.fxml;

    opens se.ecutbildning to javafx.fxml;
    exports se.ecutbildning;


    opens se.ecutbildning.controllers to javafx.fxml;
    exports se.ecutbildning.controllers;
}