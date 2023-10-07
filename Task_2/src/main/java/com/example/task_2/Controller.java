package com.example.task_2;

import Factory.ShapeFactory;
import Model.Shape;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Canvas sheet;
    public ColorPicker colorPicker;
    public Label infoShape;
    public Spinner<Integer> spinner;
    public TextField nameShape;
    private Shape shape;
    private ShapeFactory factory;
    private GraphicsContext context;
    private int initialValue;

    private static void initializeHandlers(Controller controller){
        controller.sheet.setOnMouseClicked(controller::canvasClickHandler);
    }

    private void canvasClickHandler(MouseEvent event){
        double x = event.getX(); double y = event.getY();

        shape = factory.createShape(nameShape.getText());

        if (shape == null) {
            this.displayWarning("Такой фигуры не существует");
            return;
        }

        shape.setColor(this.colorPicker.getValue());
        shape.setX((int)x); shape.setY((int)y);
        shape.drawShape(context);
    }

    private void displayWarning(String text){
        var alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Ошибка");
        alert.setContentText(text);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        context = this.sheet.getGraphicsContext2D();
        factory = new ShapeFactory();

        var valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5,30,initialValue);
        spinner.setValueFactory(valueFactory);

        Controller.initializeHandlers(this);
    }
}