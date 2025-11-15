package facade.components;

import facade.interfaces.ISystem;
import java.util.Collections;
import java.util.List;

public class SortSystem implements ISystem {
    private String name = "Sort System";
    private String status = "Inactive";

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

    public void sortPhotos(List<String> photos) {
        Collections.sort(photos);
        System.out.println("Photos sorted alphabetically.");
    }
}