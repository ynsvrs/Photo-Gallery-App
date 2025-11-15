import decorator.interfaces.IPhoto;
import decorator.components.PlainPhoto;
import decorator.decorators.*;
import strategy.context.Gallery;
import strategy.model.Photo;
import strategy.strategy.*;
import observer.implementation.*;
import facade.facade.GalleryFacade;
import factory.creator.PhotoFactory;
import factory.concretecreator.*;
import factory.product.IPhotoType;
import adapter.adapter.LegacyPhotoAdapter;
import adapter.adaptee.LegacyPhoto;

public class PhotoGalleryApp {
    public static void main(String[] args) {
        System.out.println("║ PHOTO GALLERY APP - 6 PATTERNS INTEGRATED ║\n");

        GalleryFacade facade = new GalleryFacade("My Gallery");
        facade.openGallery();

        // 1. FACADE
        System.out.println("--- 1. FACADE ---");
        facade.addPhoto("Beach.jpg");
        facade.addPhoto("Mountain.jpg");

        // 2. DECORATOR
        System.out.println("\n---  Titanic 2. DECORATOR ---");
        IPhoto photo = new PlainPhoto("Sunset", "2025-01-01", 4.8);
        System.out.println("Original: " + photo.getDescription());
        photo = new GrayscaleFilter(photo);
        System.out.println("Grayscale: " + photo.getDescription());
        photo = new SepiaFilter(photo);
        System.out.println("Sepia: " + photo.getDescription());

        // 3. STRATEGY
        System.out.println("\n--- 3. STRATEGY ---");
        Photo p1 = new Photo("Beach", "2025-01-15", 4.5);
        Photo p2 = new Photo("Mountain", "2024-12-20", 4.8);
        Gallery gallery = new Gallery(new SortByDate());
        System.out.println(gallery.sortPhotos(p1, p2));
        gallery.setSortingStrategy(new SortByRating());
        System.out.println(gallery.sortPhotos(p1, p2));

        // 4. OBSERVER
        System.out.println("\n--- 4. OBSERVER ---");
        PhotoGalleryManager manager = new PhotoGalleryManager("Community");
        manager.subscribe(new ViewerUser("Alice", "Nature"));
        manager.uploadPhoto("001", "Forest Trail", "Nature");

        // 5. FACTORY
        System.out.println("\n--- 5. FACTORY ---");
        PhotoFactory portraitFactory = new PortraitFactory();
        IPhotoType portrait = portraitFactory.createPhoto();
        System.out.println("Created: " + portrait.getType() + " - " + portrait.getDescription());

        PhotoFactory landscapeFactory = new LandscapeFactory();
        IPhotoType landscape = landscapeFactory.createPhoto();
        System.out.println("Created: " + landscape.getType() + " - " + landscape.getDescription());

        // 6. ADAPTER
        System.out.println("\n--- 6. ADAPTER ---");
        LegacyPhoto old = new LegacyPhoto("OldVacation", "20180-06-10", 5.0);
        old.displayLegacy();

        IPhoto adapted = new LegacyPhotoAdapter(old);  // FIXED: 'adapted' defined here
        System.out.println("Adapted Name: " + adapted.getName());
        System.out.println("Adapted Date: " + adapted.getDate());
        System.out.println("Adapted Rating: " + adapted.getRating());

        // INTEGRATION: Adapter + Decorator
        System.out.println("\n--- INTEGRATION: Adapter + Decorator ---");
        IPhoto decoratedLegacy = new GrayscaleFilter(adapted);
        System.out.println(decoratedLegacy.getDescription());

        facade.displayPhotos();
        facade.closeGallery();

        System.out.println("║   ALL 6 PATTERNS SUCCESSFULLY INTEGRATED   ║");
    }
}