package decorator.decorators;

import decorator.interfaces.IPhoto;

public class SepiaFilter extends PhotoDecorator {
    public SepiaFilter(IPhoto decoratedPhoto) {
        super(decoratedPhoto, "Sepia Filter");
    }
}