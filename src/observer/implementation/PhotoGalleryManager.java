package observer.implementation;

import observer.interfaces.IPhotoGallery;
import observer.interfaces.IViewer;
import observer.models.Photo;
import java.util.ArrayList;
import java.util.List;

public class PhotoGalleryManager implements IPhotoGallery {
    private List<IViewer> viewers = new ArrayList<>();
    private List<Photo> photos = new ArrayList<>();
    private String galleryName;

    public PhotoGalleryManager(String galleryName) {
        this.galleryName = galleryName;
    }

    @Override public void subscribe(IViewer viewer) {
        viewers.add(viewer);
        System.out.println(viewer.getUsername() + " subscribed to " + galleryName);
    }

    @Override public void unsubscribe(IViewer viewer) {
        viewers.remove(viewer);
        System.out.println(viewer.getUsername() + " unsubscribed from " + galleryName);
    }

    @Override public void notifyViewers(String update) {
        System.out.println("\n[" + galleryName + "] Notifying viewers...");
        viewers.forEach(v -> v.update(update));
    }

    public void uploadPhoto(String id, String title, String category) {
        Photo photo = new Photo(id, title, category);
        photos.add(photo);
        System.out.println("\nUploaded: " + title + " [" + category + "]");
        notifyViewers("New photo: " + title + " in " + category);
    }

    public int getPhotoCount() { return photos.size(); }
}