package Factory;

import Model.Circule;
import Model.Shape;
import Model.Square;

public class ShapeFactory implements IFactory{
    @Override
    public Shape createShape(String name) {
        if (name.equals("Круг")) {
            return new Circule();
        } else if (name.equals("Квадрат")) {
            return new Square();
        }
        return null;
    }
}
