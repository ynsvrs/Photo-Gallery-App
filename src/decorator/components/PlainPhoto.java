package decorator.components;

import decorator.interfaces.IPhoto;

public class PlainPhoto implements IPhoto {
    private String name;
    private String date;
    private double rating;

    public PlainPhoto(String name, String date, double rating) {
        this.name = name;
        this.date = date;
        this.rating = rating;
    }

    @Override public String getDescription() { return "Photo: " + name; }
    @Override public String getName() { return name; }
    @Override public String getDate() { return date; }
    @Override public double getRating() { return rating; }
}