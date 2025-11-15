package adapter.adaptee;

public class LegacyPhoto {
    private String title;
    private String captureDate;
    private double stars;

    public LegacyPhoto(String title, String captureDate, double stars) {
        this.title = title;
        this.captureDate = captureDate;
        this.stars = stars;
    }

    // Legacy methods
    public String getTitle() { return title; }
    public String getCaptureDate() { return captureDate; }
    public double getStars() { return stars; }

    public void displayLegacy() {
        System.out.println("Legacy Photo: " + title + " | " + captureDate + " | " + stars + " stars");
    }
}