package Factory;

import Model.Shape;

public interface IFactory {
    public Shape createShape(String name);
}
