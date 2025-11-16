package decorator.concretedecorator;

import decorator.component.IPhoto;
import decorator.decorator.PhotoDecorator;

public class SepiaFilter extends PhotoDecorator {
    public SepiaFilter(IPhoto decoratedPhoto) {
        super(decoratedPhoto, "Sepia Filter");
    }
}