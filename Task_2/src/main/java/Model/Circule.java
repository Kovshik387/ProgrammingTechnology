package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circule extends Shape  {
    private final Double height;
    public Circule(int x,int y, Color color, Double height, Double width){
        super(x, y, color);
        this.height = height;
    }

    public Circule(){
        super(20,20,Color.AQUA); this.height = 20.0;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(super.getX() ,super.getY(),this.height, this.height);
    }

    @Override
    public String toString(){
        return "Круг с координатами x: " + super.getX() + " y: " + super.getY() + " Цвет: " + super.getColor().toString();
    }
}
