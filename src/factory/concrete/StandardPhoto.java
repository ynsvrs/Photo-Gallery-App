package factory.concrete;

import factory.product.IPhotoType;

public class StandardPhoto implements IPhotoType {
    @Override public String getType() { return "Standard"; }
    @Override public String getDescription() { return "Standard square photo"; }
}