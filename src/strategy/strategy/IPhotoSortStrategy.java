package strategy.strategy;

import strategy.model.Photo;

public interface IPhotoSortStrategy {
    String sort(Photo photo1, Photo photo2);
}