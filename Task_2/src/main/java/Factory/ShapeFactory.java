package Factory;

import Model.Circle;
import Model.Rectangle;
import Model.Shape;
import Model.Square;

public class ShapeFactory implements IFactory{
    @Override
    public Shape createShape(String name) {
        if (name.equals("Круг")) {
            return new Circle();
        } else if (name.equals("Квадрат")) {
            return new Square();
        } else if (name.equals("Треугольник")){
            return new Rectangle();
        } else
        return null;
    }
}
