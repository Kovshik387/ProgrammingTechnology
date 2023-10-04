package com.example.task_2;

import Factory.ShapeFactory;
import Model.Circule;
import Model.Shape;
import Model.Square;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class HelloController implements Initializable {
    public Canvas sheet;
    public ColorPicker colorPicker;
    public Label infoShape;
    public Spinner<Integer> spinner;
    public TextField nameShape;
    private Shape shape;
    private ShapeFactory factory;
    private GraphicsContext context;
    private int initialValue;

    public HelloController() {
    }

    public void ClickMouse(MouseEvent mouseEvent) {

        double x = mouseEvent.getX(); double y = mouseEvent.getY();

        shape = factory.createShape(nameShape.getText());

        if (shape == null) {
            System.out.println("Несуществующая фигура");
            return;
        }

        shape.setColor(this.colorPicker.getValue());
        shape.setX((int)x); shape.setY((int)y);
        shape.drawShape(context);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        context = this.sheet.getGraphicsContext2D();
        factory = new ShapeFactory();

        var valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5,30,initialValue);
        spinner.setValueFactory(valueFactory);
    }
}