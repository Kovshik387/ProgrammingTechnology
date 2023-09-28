package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circule extends Shape  {
    private final Double height;
    private final Double width;
    public Circule(int x,int y, Color color, Double height, Double width){
        super(x, y, color);
        this.height = height; this.width = width;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(super.getX() ,super.getY(),this.width,this.height);
    }

    @Override
    public String toString(){
        return "Круг с координатами x: " + super.getX() + " y: " + super.getY() + " Цвет: " + super.getColor().toString();
    }
}
