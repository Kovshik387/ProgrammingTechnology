package com.example.task_1;

import Model.Circule;
import Model.Shape;
import Model.Square;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class HelloController {
    public Canvas sheet;
    public ColorPicker colorPicker;
    public TextField sizeNumber;
    public Label infoShape;

    private Shape shape;
    @FXML
    private Label welcomeText;

    @FXML
    public void ButtonOneAction(ActionEvent actionEvent) {
        GraphicsContext context = this.sheet.getGraphicsContext2D();

        System.out.println(this.colorPicker.toString());

        shape = new Circule(50,50,this.colorPicker.getValue(), Double.valueOf(this.sizeNumber.getText()),30.);
        shape.drawShape(context);
    }

    public void ButtonTwoAction(ActionEvent actionEvent) {
        GraphicsContext context = this.sheet.getGraphicsContext2D();

        try {
            shape = new Square(20, 20,this.colorPicker.getValue(), Double.parseDouble(this.sizeNumber.getText()));
            System.out.println(shape.toString());
            shape.drawShape(context);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }

    }

    public void ClickMouse(MouseEvent mouseEvent) {
        sizeNumber.setText("10");

        GraphicsContext context = this.sheet.getGraphicsContext2D();

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        System.out.println("Нажата:" + mouseEvent.getButton());

        MouseButton but = mouseEvent.getButton();

        if (but == MouseButton.PRIMARY){
            shape = new Square((int)x, (int)y,this.colorPicker.getValue(), Double.parseDouble(this.sizeNumber.getText()));
            infoShape.setText("" + shape);
            shape.drawShape(context);
        }
        else {
            shape = new Circule((int)x,(int)y,this.colorPicker.getValue(), Double.valueOf(this.sizeNumber.getText()),30.);
            infoShape.setText(shape.toString());
            shape.drawShape(context);
        }


    }
}