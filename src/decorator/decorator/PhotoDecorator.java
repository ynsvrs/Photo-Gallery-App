package decorator.decorator;

import decorator.component.IPhoto;

public abstract class PhotoDecorator implements IPhoto {
    protected IPhoto decoratedPhoto;
    protected String filterName;

    public PhotoDecorator(IPhoto decoratedPhoto, String filterName) {
        this.decoratedPhoto = decoratedPhoto;
        this.filterName = filterName;
    }

    @Override public String getDescription() {
        return decoratedPhoto.getDescription() + " + " + filterName;
    }

    @Override public String getName() { return decoratedPhoto.getName(); }
    @Override public String getDate() { return decoratedPhoto.getDate(); }
    @Override public double getRating() { return decoratedPhoto.getRating(); }
}
