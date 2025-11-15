package factory.concretecreator;

import factory.concrete.PortraitPhoto;
import factory.creator.PhotoFactory;
import factory.product.IPhotoType;

public class PortraitFactory extends PhotoFactory {
    @Override
    public IPhotoType createPhoto() {
        return new PortraitPhoto();
    }
}