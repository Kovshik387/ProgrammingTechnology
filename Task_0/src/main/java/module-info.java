module com.example.task_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task_0 to javafx.fxml;
    exports com.example.task_0;
}