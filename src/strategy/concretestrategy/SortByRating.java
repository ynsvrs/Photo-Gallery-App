package strategy.concretestrategy;

import strategy.model.Photo;
import strategy.strategy.IPhotoSortStrategy;

public class SortByRating implements IPhotoSortStrategy {
    @Override
    public String sort(Photo photo1, Photo photo2) {
        if (photo1.getRating() > photo2.getRating()) {
            return "Sorted by rating: " + photo1.getRating() + ", " + photo2.getRating();
        } else {
            return "Sorted by rating: " + photo2.getRating() + ", " + photo1.getRating();
        }
    }
}