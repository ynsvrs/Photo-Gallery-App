package factory.creator;

import factory.product.IPhotoType;

public abstract class PhotoFactory {
    public abstract IPhotoType createPhoto();
}
