package facade.components;

import facade.interfaces.ISystem;

public class FilterSystem implements ISystem {
    private String name = "Filter System";
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

    public void applyFilter(String filterName) {
        System.out.println("Applying " + filterName + " filter...");
    }
}