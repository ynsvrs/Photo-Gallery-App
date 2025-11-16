import decorator.interfaces.IPhoto;
import decorator.components.PlainPhoto;
import decorator.decorators.*;
import observer.observerpattern.ViewerUser;
import strategy.context.Gallery;
import strategy.model.Photo;
import strategy.strategy.*;
import observer.subject.*;
import facade.facadepattern.GalleryFacade;
import factory.creator.PhotoFactory;
import factory.concretecreator.*;
import factory.product.IPhotoType;
import adapter.adapter.LegacyPhotoAdapter;
import adapter.adaptee.LegacyPhoto;

public class PhotoGalleryApp {
    public static void main(String[] args) {
        System.out.println("║ PHOTO GALLERY APP ║\n");

        GalleryFacade facade = new GalleryFacade("My Gallery");
        facade.openGallery();

        // Facade
        System.out.println("--- FACADE ---");
        facade.addPhoto("Beach.jpg");
        facade.addPhoto("Mountain.jpg");

        // Decorator
        System.out.println("\n--- DECORATOR ---");
        IPhoto photo = new PlainPhoto("Sunset", "2025-01-01", 4.8);
        System.out.println("Original: " + photo.getDescription());
        photo = new GrayscaleFilter(photo);
        System.out.println("Grayscale: " + photo.getDescription());
        photo = new SepiaFilter(photo);
        System.out.println("Sepia: " + photo.getDescription());

        // Strategy
        System.out.println("\n--- STRATEGY ---");
        Photo p1 = new Photo("Beach", "2025-01-15", 4.5);
        Photo p2 = new Photo("Mountain", "2024-12-20", 4.8);
        Gallery gallery = new Gallery(new SortByDate());
        System.out.println(gallery.sortPhotos(p1, p2));
        gallery.setSortingStrategy(new SortByRating());
        System.out.println(gallery.sortPhotos(p1, p2));

        // Observer
        System.out.println("\n--- OBSERVER ---");
        PhotoGalleryManager manager = new PhotoGalleryManager("Community");
        manager.subscribe(new ViewerUser("Sunghoon", "Nature"));
        manager.uploadPhoto("001", "Forest Trail", "Nature");

        // Factory
        System.out.println("\n--- FACTORY ---");
        PhotoFactory portraitFactory = new PortraitFactory();
        IPhotoType portrait = portraitFactory.createPhoto();
        System.out.println("Created: " + portrait.getType() + " - " + portrait.getDescription());

        // Adapter and Decorator
        System.out.println("\n--- ADAPTER + DECORATOR ---");
        LegacyPhoto old = new LegacyPhoto("OldVacation", "2018-06-10", 5.0);
        old.displayLegacy();
        IPhoto adapted = new LegacyPhotoAdapter(old);
        System.out.println("Adapted: " + adapted.getDescription());
        IPhoto filtered = new GrayscaleFilter(adapted);
        filtered = new SepiaFilter(filtered);
        System.out.println("After Grayscale + Sepia: " + filtered.getDescription());

        // Full
        System.out.println("\n--- FULL ---");

        // Factory
        PhotoFactory factory = new PortraitFactory();
        IPhotoType photoType = factory.createPhoto();

        // Adapter + Decorator
        LegacyPhoto legacy = new LegacyPhoto("OldTrip", "2018-06-10", 5.0);
        IPhoto imported = new LegacyPhotoAdapter(legacy);
        IPhoto fullyFiltered = new GrayscaleFilter(imported);
        fullyFiltered = new SepiaFilter(fullyFiltered);

        // Facade
        facade.addPhoto(fullyFiltered.getName());

        // Strategy
        Photo sp1 = new Photo("Beach", "2025-01-15", 4.5);
        Photo sp2 = new Photo(fullyFiltered.getName(), fullyFiltered.getDate(), fullyFiltered.getRating());
        Gallery sortGallery = new Gallery(new SortByRating());
        System.out.println(sortGallery.sortPhotos(sp1, sp2));

        // Observer
        manager.subscribe(new ViewerUser("Naruto", "Vintage"));
        String msg = fullyFiltered.getName() + " (" + photoType.getType() + ", Grayscale + Sepia)";
        System.out.println("\n[Observer] Notifying users...");
        System.out.println("  [Sunghoon] notification: New photo: " + msg);
        System.out.println("  [Naruto] FAVORITE: " + msg);

        facade.displayPhotos();
        facade.closeGallery();
    }
}