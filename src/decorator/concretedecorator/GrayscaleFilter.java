package decorator.concretedecorator;

import decorator.component.IPhoto;
import decorator.decorator.PhotoDecorator;

public class GrayscaleFilter extends PhotoDecorator {
    public GrayscaleFilter(IPhoto decoratedPhoto) {
        super(decoratedPhoto, "Grayscale Filter");
    }
}