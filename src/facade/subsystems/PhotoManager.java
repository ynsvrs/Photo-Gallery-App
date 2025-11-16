package facade.subsystems;

import facade.interfaces.ISystem;
import java.util.ArrayList;
import java.util.List;

public class PhotoManager implements ISystem {
    private String name = "Photo Manager";
    private String status = "Inactive";
    private List<String> photos = new ArrayList<>();

    @Override public String getName() { return name; }
    @Override public String getStatus() { return status; }

    @Override public void activate() {
        status = "Active";
        System.out.println(name + " is now ACTIVE.");
    }

    @Override public void deactivate() {
        status = "Inactive";
        System.out.println(name + " is now INACTIVE.");
    }

    public void addPhoto(String photoName) {
        photos.add(photoName);
        System.out.println(photoName + " added.");
    }

    public List<String> getPhotos() { return photos; }
}
