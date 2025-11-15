package factory.concretecreator;

import factory.concrete.LandscapePhoto;
import factory.creator.PhotoFactory;
import factory.product.IPhotoType;

public class LandscapeFactory extends PhotoFactory {
    @Override
    public IPhotoType createPhoto() {
        return new LandscapePhoto();
    }
}