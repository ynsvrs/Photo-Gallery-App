package strategy.model;

public class Photo {
    private String name;
    private String date;
    private double rating;

    public Photo(String name, String date, double rating) {
        this.name = name;
        this.date = date;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public double getRating() { return rating; }
}