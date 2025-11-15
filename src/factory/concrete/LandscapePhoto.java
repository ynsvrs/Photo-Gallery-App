package factory.concrete;

import factory.product.IPhotoType;

public class LandscapePhoto implements IPhotoType {
    @Override public String getType() { return "Landscape"; }
    @Override public String getDescription() { return "Landscape orientation photo"; }
}
