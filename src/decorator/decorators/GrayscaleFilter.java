package decorator.decorators;

import decorator.interfaces.IPhoto;

public class GrayscaleFilter extends PhotoDecorator {
    public GrayscaleFilter(IPhoto decoratedPhoto) {
        super(decoratedPhoto, "Grayscale Filter");
    }
}