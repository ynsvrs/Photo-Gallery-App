package factory.concrete;

import factory.product.IPhotoType;

public class PortraitPhoto implements IPhotoType {
    @Override public String getType() { return "Portrait"; }
    @Override public String getDescription() { return "Portrait orientation photo"; }
}