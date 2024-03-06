module com.thepigrat.felixclicker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.thepigrat.felixclicker to javafx.fxml;
    exports com.thepigrat.felixclicker;
}