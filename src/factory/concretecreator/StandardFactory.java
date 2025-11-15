package factory.concretecreator;

import factory.concrete.StandardPhoto;
import factory.creator.PhotoFactory;
import factory.product.IPhotoType;

public class StandardFactory extends PhotoFactory {
    @Override
    public IPhotoType createPhoto() {
        return new StandardPhoto();
    }
}