package facade.facade;

import facade.components.PhotoManager;
import facade.components.FilterSystem;
import facade.components.SortSystem;
import java.util.List;

public class GalleryFacade {
    private PhotoManager photoManager = new PhotoManager();
    private FilterSystem filterSystem = new FilterSystem();
    private SortSystem sortSystem = new SortSystem();
    private String galleryName;

    public GalleryFacade(String galleryName) { this.galleryName = galleryName; }

    public void openGallery() {
        System.out.println("\nOpening gallery: " + galleryName + "...");
        photoManager.activate(); filterSystem.activate(); sortSystem.activate();
        System.out.println(galleryName + " is ready.\n");
    }

    public void closeGallery() {
        System.out.println("\nClosing gallery...");
        photoManager.deactivate(); filterSystem.deactivate(); sortSystem.deactivate();
        System.out.println(galleryName + " is closed.\n");
    }

    public void addPhoto(String name) { photoManager.addPhoto(name); }
    public void applyFilter(String filter) { filterSystem.applyFilter(filter); }
    public void sortPhotos() { sortSystem.sortPhotos(photoManager.getPhotos()); }
    public void displayPhotos() { System.out.println("Photos: " + photoManager.getPhotos()); }
}