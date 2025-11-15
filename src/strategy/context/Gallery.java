package strategy.context;

import strategy.model.Photo;
import strategy.strategy.IPhotoSortStrategy;

public class Gallery {
    private IPhotoSortStrategy strategy;

    public Gallery(IPhotoSortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setSortingStrategy(IPhotoSortStrategy strategy) {
        this.strategy = strategy;
    }

    public String sortPhotos(Photo photo1, Photo photo2) {
        return strategy.sort(photo1, photo2);
    }
}